package com.spring.rest.controller;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Base64;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.rest.model.DeploymentConfiguration;
import com.spring.rest.modelrequests.DeploymentConfigurationRequest;
import com.spring.rest.model.UserAuth;
import com.spring.rest.apiresponse.DeploymentConfigurationResponse;
import com.main.external.exception.user.UserException;
import com.spring.rest.apiresponse.UserSignUpExample;
import com.spring.rest.apiresponse.UserAuthResponse;
import com.spring.rest.util.JwtUtil;
import com.spring.rest.custom.ErrorResponse;
import com.spring.rest.util.ModelMapperUtil;
import com.spring.rest.custom.StandardApiResponses;
import com.spring.rest.service.CommonDocumentService;
import com.spring.rest.util.FacetFieldDTO;
import com.spring.rest.util.FacetValueDTO;
import com.spring.rest.util.ResponseMessage;
import com.spring.rest.util.SolrUrls;
import com.spring.rest.util.Utility;
import com.spring.rest.validation.ValidationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

// version for 18.0.0

@Api(value = "Deploymentconfiguration Mangment System" , description = "Service used to perform operation on deploymentConfiguration.", tags = "deploymentConfiguration")
@RestController
@ExposesResourceFor(DeploymentconfigurationController.class)
// @RequestMapping("/Deploymentconfiguration")
@RequestMapping("/api")
public class DeploymentconfigurationController {
	
	@Autowired
	CommonDocumentService commonDocumentService;
	
	@Autowired
	ValidationService validationService;

	@Autowired
	JwtUtil	jwtUtil;
	
    String url=SolrUrls.DEPLOYMENTCONFIGURATION_URL;
    
		
	@ApiOperation(value = "Service used to create Deploymentconfiguration")
	@StandardApiResponses
	@RequestMapping(value="/deploymentConfiguration" , method=RequestMethod.POST)
	@ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "create a new Deploymentconfiguration",
                         content = @Content(mediaType = "application/json",
                         schema = @Schema(implementation = DeploymentConfiguration.class)))
        })
	public ResponseEntity<?>   createDeploymentconfiguration(@RequestBody  DeploymentConfigurationRequest deploymentConfigurationRequest
 , HttpServletResponse response, HttpServletRequest request) {
		
	       try {
	          
	            
			//	deploymentConfiguration.setID(Utility.getUniqueId());
	          
			
	    	   DeploymentConfiguration deploymentConfiguration = ModelMapperUtil.mapCreateRequestToModel(deploymentConfigurationRequest,  DeploymentConfiguration.class);

	            // Call service layer
	            Object apiResponse = commonDocumentService.addDocumentAndExceptionByTemplate( deploymentConfiguration, url);
	            if (apiResponse instanceof Exception) {
	                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                        .body(ErrorResponse.of("internal_error", "Failed to save deploymentConfiguration"));
	            }
	            return ResponseEntity.status(HttpStatus.CREATED)
	                    .body(new ResponseMessage.Builder("DeploymentConfiguration created successfully", 201)
	                            .withUserObject(deploymentConfiguration)
	                            .build());
	           }
	        catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body(ErrorResponse.of("internal_error", "Unexpected error occurred", e.getMessage()));
	        }
	    }
	
@ApiOperation(value = "This service used to update Deploymentconfiguration")
@StandardApiResponses	
@RequestMapping(value="/deploymentConfiguration" , method=RequestMethod.PUT)
public ResponseEntity<?> updatedeploymentConfiguration(
        @RequestBody DeploymentConfiguration deploymentConfiguration,
        HttpServletResponse response,
        HttpServletRequest request) {

    String deploymentConfigurationId = null;

    try {
       

         // ✅ Check for ID in Customers POJO
	        if (deploymentConfiguration.getID() == null || deploymentConfiguration.getID().trim().isEmpty()) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new ResponseMessage.Builder("No Unique ID to update, Invalid ID", 400).build());
	        }

    
	        deploymentConfigurationId = deploymentConfiguration.getID();
            
            // ✅ Query Solr for existing record
	        Object apiResponse = commonDocumentService.advanceQueryAndExceptionByTemplate("ID:" + deploymentConfigurationId, url);

        if (apiResponse instanceof Exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseMessage.Builder("Server down Internal server error", 500).build());
        }

        QueryResponse queryResponse = (QueryResponse) apiResponse;
        if (queryResponse.getResults().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseMessage.Builder("No Unique ID to update, Invalid ID", 400).build());
		}
       
        commonDocumentService.updateDocumentAndExceptionByTemplate(deploymentConfiguration, url);

        // ✅ Success Response
        ResponseMessage successResponse = new ResponseMessage.Builder("Content updated Successfully", 200)
                .withID(deploymentConfigurationId)
                .withUserObject(deploymentConfiguration)
                .withResponseType("updated")
                .build();

        return ResponseEntity.ok(successResponse);

    } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ResponseMessage.Builder("Unexpected server error occurred", 500).build());
    }
}

	
	@ApiOperation(value = "This service used to search Deploymentconfiguration by query")
	@StandardApiResponses
	@RequestMapping(value="/deploymentConfiguration" , method=RequestMethod.GET)
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found",
                         content = @Content(mediaType = "application/json",
                         schema = @Schema(implementation = DeploymentConfigurationResponse.class)))
        })
	public ModelMap  searchDeploymentconfiguration(@RequestParam(name = "query", required = true) String query,
			@RequestParam(name = "rows",  defaultValue = "8", required = false) String rows ,
			@RequestParam(name = "start",defaultValue = "0", required = false) String start,
			@RequestParam(name = "fl" ,defaultValue = "" , required = false) String fl ,
			@RequestParam(name = "fq" ,defaultValue = "" , required = false) String[] fq ,
			//default value asc|desc
			@RequestParam(name = "sort" ,defaultValue = "" , required = false) String sort,
			
			HttpServletRequest request, HttpServletResponse response
			) {
		ModelMap model=new ModelMap();
		Object apiResponse=null;
		
	//		query=Utility.getQuery(query, userId);
			Map<String, String[]> searchCriteria=new HashMap<>(); 
			searchCriteria.put("q", new String[] { query });
			searchCriteria.put("rows", new String[] { rows });
			searchCriteria.put("start", new String[] { start });
			searchCriteria.put("fl", new String[] { fl });
			searchCriteria.put("fq", fq);
			searchCriteria.put("sort", new String[] { sort });
			
			 apiResponse = commonDocumentService.advanceSearchDocumentByTemplate(searchCriteria, url);
			 if(apiResponse instanceof Exception )
			{
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			//	return model.addAttribute("Message", new ResponseMessage("Server down Internal server error",500));
				return model.addAttribute("Message", new ResponseMessage.Builder("Server down Internal server error", 500).build());
				
			}else {
				
				((QueryResponse) apiResponse).getResults().forEach((K)-> {
					System.out.println(K.get("ID"));							
				});
						
				 Map<String, Object> pagination = new LinkedHashMap<>();
				    pagination.put("total",((QueryResponse) apiResponse).getResults().getNumFound() );
				    pagination.put("limit", rows);
				    pagination.put("offset", start);
				
				    model.addAttribute("pagination",pagination);
				return model.addAttribute("data",((QueryResponse) apiResponse).getResults());
		}
	}
	
	@Hidden
	@ApiOperation(value = "This service used to search content by query")
	@RequestMapping(value="/searchDeploymentconfigurationById" , method=RequestMethod.GET)
	public ModelMap  searchContentById(@RequestParam(name = "Id", required = true) String query,
			@RequestParam(name = "rows",  defaultValue = "8", required = false) String rows ,
			@RequestParam(name = "start",defaultValue = "0", required = false) String start,
			@RequestParam(name = "fl" ,defaultValue = "" , required = false) String fl ,
			@RequestParam(name = "fq" ,defaultValue = "" , required = false) String[] fq ,
			//default value asc|desc
			@RequestParam(name = "sort" ,defaultValue = "" , required = false) String sort,
			@RequestHeader(name="X-API-Key", required=true) String apiKey ,
			@RequestHeader(name="X-USER-ID", required=true) String userId,
		
			HttpServletRequest request, HttpServletResponse response
			) {
		ModelMap model=new ModelMap();
		Object apiResponse=null;
		
		String requestUri = request.getRequestURI();
        System.out.println("--->"+requestUri.substring(0));
		
		
		if(validationService.validateApiKey(apiKey, userId) == 500 )
		{	
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		//	return model.addAttribute("Message", new ResponseMessage("Server down Internal server error", 500));
			return model.addAttribute("Message", new ResponseMessage.Builder("Server down Internal server error", 500).build()); 
		}else if(validationService.validateApiKey(apiKey, userId) == 401) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		//	 return model.addAttribute("Message", new ResponseMessage("Invalid Api Key", 401));
			return model.addAttribute("Message", new ResponseMessage.Builder("Invalid Api Key", 401).build());
		}else {
			query=Utility.getQuery(query, userId);
			Map<String, String[]> searchCriteria=new HashMap<>(); 
			searchCriteria.put("q", new String[] { query });
			searchCriteria.put("rows", new String[] {  rows });
			searchCriteria.put("start", new String[] { start });
			searchCriteria.put("fl", new String[] { fl });
			searchCriteria.put("fq", fq);
			searchCriteria.put("sort", new String[] { sort });
			
			 apiResponse = commonDocumentService.advanceSearchDocumentByTemplate(searchCriteria, url);
			 if(apiResponse instanceof Exception )
			{
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			//	return model.addAttribute("Message", new ResponseMessage("Server down Internal server error",500));
				return model.addAttribute("Message", new ResponseMessage.Builder("Server down Internal server error", 500).build());
			}else {
				
				((QueryResponse) apiResponse).getResults().forEach((K)-> {
					System.out.println(K.get("ID"));							
				});
				
 //				 To check number of review in Content
//				 apiDetailsQuery="reviewContentId:"+((QueryResponse) apiResponse).getResults().get;
//				 apiDetails=commonDocumentService.advanceSearchDocumentByTemplate(searchCriteria, url);
				
			//	return model.addAttribute("result",((QueryResponse) apiResponse).getResults().get(0));
				return model.addAllAttributes(((QueryResponse) apiResponse).getResults().get(0))	;
			//return	model.addAttribute(((QueryResponse) apiResponse).getResults().get(0));
			//	return model.addAllAttributes(((QueryResponse) apiResponse).getResults())	;
			}
		}
	}
	
@ApiOperation(value = "This service delete Deploymentconfiguration by query")
@StandardApiResponses
@DeleteMapping("/deploymentConfiguration")
public ResponseEntity<?> deleteDeploymentconfigurationByQuery(
        @RequestParam(name = "query") String query) {

    try {
       

        // ✅ Delete Operation
        Object apiResponse = commonDocumentService.deleteDocumentAndExceptionByTemplate(query, url);

        if (apiResponse instanceof Exception) {
            Exception ex = (Exception) apiResponse;

            if (ex.getMessage().contains("SyntaxError")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new ResponseMessage.Builder("Invalid Query or Syntax Error", 400).build());
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(new ResponseMessage.Builder("Server down Internal server error", 500).build());
            }
        }

        // ✅ Success
        return ResponseEntity.ok(
                new ResponseMessage.Builder("Deploymentconfiguration deleted successfully with Query", 200)
                        .withQuery(query)
                        .withResponseType("deleted")
                        .build()
        );

    } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ResponseMessage.Builder("Unexpected error occurred", 500).build());
    }
}

//	public Map<String, Object> createDoc(Map<String, Object> payload , SolrDocument solrDocument) {
//		solrDocument.forEach((k,v) ->{
//	 		payload.put(k, v);
//	 	});
//		return payload;
//	}

	
	
	public Map<String, Object> createDoc(Map<String, Object> payload, SolrDocument solrDocument) {
	    // Create a new HashMap to store the merged result
	    Map<String, Object> updatedDoc = new HashMap<>();

	    // Copy all existing Solr document fields
	    solrDocument.forEach(updatedDoc::put);

	    // Overwrite with values from payload (new updates)
	    updatedDoc.putAll(payload);

	    return updatedDoc;
	}

	@Hidden
	// @GetMapping("/findByQuery")
	public  ResponseEntity<ResponseMessage>  advanceSearch(@RequestParam(name = "query", required = true) String query,
			@RequestParam(name = "rows",  defaultValue = "8", required = false) String rows ,
			@RequestParam(name = "start",defaultValue = "0", required = false) String start,
			@RequestParam(name = "filterField" ,defaultValue = "" , required = false) String fl ,
			@RequestParam(name = "filterQuery" ,defaultValue = "" , required = false) String[] fq ,
			//default value asc|desc
			@RequestParam(name = "advanceField" ,defaultValue = "" , required = false) String[] facetField ,
			@RequestParam(name = "advanceQuery" ,defaultValue = "" , required = false) String facetQuery ,
			@RequestParam(name = "advance" ,defaultValue = "false" , required = false) String facet ,
			
			@RequestParam(name = "sort" ,defaultValue = "" , required = false) String sort,
			HttpServletRequest request, HttpServletResponse response
			) {
		
		List<FacetFieldDTO> advance=null;
		Map<String, String[]> searchCriteria=new HashMap<>(); 
		SolrQuery solrQuery = new SolrQuery();
		ModifiableSolrParams searchParams = new ModifiableSolrParams();
	
		if (facetField != null) {
            for (String facetFields : facetField) {
                
                solrQuery.addFacetField(facetFields);
              //  searchCriteria.put("facet.field", facetFields);
            }
        }		   
		searchParams.add("q", new String[] { query });
		searchParams.add("rows", new String[] { rows });
		searchParams.add("start", new String[] { start });
		searchParams.add("fl", new String[] { fl });
		searchParams.add("fq", fq);
		searchParams.add("sort", new String[] { sort });
	//	searchParams.add("facet.pivot", facetField);
		
		searchParams.add("facet.query", new String[] { facetQuery });
		searchParams.add("facet", new String[] { facet });
	
	//	solrQuery.addFacetField("try");
	//	solrQuery.addFacetField("contentType");
	//	solrQuery.addFacetField("ID");
		solrQuery.add(searchParams);
		
		var requestUri=request.getRequestURI();
		
	//	System.out.println("Reuquested Url------>"+requestUri+"------->"+query);
		
		int colonIndex = Utility.findNthIndexOf(request.getRequestURI(), '/', 2);
		
		var  apiResponse = ((QueryResponse)commonDocumentService.advanceSearchDocumentAndExceptionByTemplate(searchCriteria, url,solrQuery));

        List<FacetField> facetFieldsResponse =  apiResponse.getFacetFields();
		
      //  printFacetResults(facetFieldsResponse);
        
        if(facet.equals("true")) {
          advance=facetFieldsResponse.stream().map(this::mapToFacetFieldDTO).collect(Collectors.toList());
        }
		//  ResponseMessage successResponse = new ResponseMessage(null, 200,apiResponse.getResults().getNumFound(),apiResponse.getResults(),null,null,null,start,rows,advance);
		  
		 ResponseMessage successResponse= new ResponseMessage.Builder(null, 200)
					.withNumFound(apiResponse.getResults().getNumFound())
					.withDocument(apiResponse.getResults())
					.withStart(start)
					.withRow(rows)
					.withDto(advance)
					.withResponseType(null)
					.build();
		  
		//  ResponseMessage(String responseMessage, int responseCode, Long numFound, SolrDocumentList document,String iD, String query, String responseType) 
		 
		  return new ResponseEntity<>(successResponse, HttpStatus.OK);	
	}
	
	
	private FacetFieldDTO mapToFacetFieldDTO(FacetField facetField) {
        FacetFieldDTO facetFieldDTO = new FacetFieldDTO();
        facetFieldDTO.setFieldName(facetField.getName());

        List<FacetValueDTO> valuesDTO = facetField.getValues().stream()
                .map(count -> new FacetValueDTO(count.getName(), count.getCount()))
                .collect(Collectors.toList());

        facetFieldDTO.setValues(valuesDTO);

        return facetFieldDTO;
    }
	


	
	
}
