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

import com.spring.rest.model.User;
import com.spring.rest.modelrequests.UserRequest;
import com.spring.rest.model.UserAuth;
import com.spring.rest.apiresponse.UserResponse;
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

@Api(value = "User Mangment System" , description = "Service used to perform operation on user.", tags = "user")
@RestController
@ExposesResourceFor(UserController.class)
// @RequestMapping("/User")
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	CommonDocumentService commonDocumentService;
	
	@Autowired
	ValidationService validationService;

	@Autowired
	JwtUtil	jwtUtil;
	
    String url=SolrUrls.USER_URL;
    
		
	@ApiOperation(value = "Service used to create User")
	@StandardApiResponses
	@RequestMapping(value="/user" , method=RequestMethod.POST)
	@ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "create a new User",
                         content = @Content(mediaType = "application/json",
                         schema = @Schema(implementation = User.class)))
        })
	public ResponseEntity<?>   createUser(@RequestBody  UserRequest userRequest
 , HttpServletResponse response, HttpServletRequest request) {
		
	       try {
	          
	            
			//	user.setID(Utility.getUniqueId());
	          
			
	    	   User user = ModelMapperUtil.mapCreateRequestToModel(userRequest,  User.class);

	            // Call service layer
	            Object apiResponse = commonDocumentService.addDocumentAndExceptionByTemplate( user, url);
	            if (apiResponse instanceof Exception) {
	                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                        .body(ErrorResponse.of("internal_error", "Failed to save user"));
	            }
	            return ResponseEntity.status(HttpStatus.CREATED)
	                    .body(new ResponseMessage.Builder("User created successfully", 201)
	                            .withUserObject(user)
	                            .build());
	           }
	        catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body(ErrorResponse.of("internal_error", "Unexpected error occurred", e.getMessage()));
	        }
	    }
	
@ApiOperation(value = "This service used to update User")
@StandardApiResponses	
@RequestMapping(value="/user" , method=RequestMethod.PUT)
public ResponseEntity<?> updateuser(
        @RequestBody User user,
        HttpServletResponse response,
        HttpServletRequest request) {

    String userId = null;

    try {
       

         // ✅ Check for ID in Customers POJO
	        if (user.getID() == null || user.getID().trim().isEmpty()) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new ResponseMessage.Builder("No Unique ID to update, Invalid ID", 400).build());
	        }

    
	        userId = user.getID();
            
            // ✅ Query Solr for existing record
	        Object apiResponse = commonDocumentService.advanceQueryAndExceptionByTemplate("ID:" + userId, url);

        if (apiResponse instanceof Exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseMessage.Builder("Server down Internal server error", 500).build());
        }

        QueryResponse queryResponse = (QueryResponse) apiResponse;
        if (queryResponse.getResults().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseMessage.Builder("No Unique ID to update, Invalid ID", 400).build());
		}
       
        commonDocumentService.updateDocumentAndExceptionByTemplate(user, url);

        // ✅ Success Response
        ResponseMessage successResponse = new ResponseMessage.Builder("Content updated Successfully", 200)
                .withID(userId)
                .withUserObject(user)
                .withResponseType("updated")
                .build();

        return ResponseEntity.ok(successResponse);

    } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ResponseMessage.Builder("Unexpected server error occurred", 500).build());
    }
}

	
	@ApiOperation(value = "This service used to search User by query")
	@StandardApiResponses
	@RequestMapping(value="/user" , method=RequestMethod.GET)
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found",
                         content = @Content(mediaType = "application/json",
                         schema = @Schema(implementation = UserResponse.class)))
        })
	public ModelMap  searchUser(@RequestParam(name = "query", required = true) String query,
			@RequestParam(name = "rows",  defaultValue = "8", required = false) String rows ,
			@RequestParam(name = "start",defaultValue = "0", required = false) String start,
			@RequestParam(name = "fl" ,defaultValue = "" , required = false) String fl ,
			@RequestParam(name = "fq" ,defaultValue = "" , required = false) String[] fq ,
			//default value asc|desc
			@RequestParam(name = "sort" ,defaultValue = "" , required = false) String sort,
			

			@RequestParam(name = "advanceField" ,defaultValue = "" , required = false) String[] facetField ,
			@RequestParam(name = "advanceQuery" ,defaultValue = "" , required = false) String facetQuery ,
			@RequestParam(name = "advance" ,defaultValue = "false" , required = false) String facet ,

			HttpServletRequest request, HttpServletResponse response
			) {
		ModelMap model=new ModelMap();
		List<FacetFieldDTO> advance=null;
	//		query=Utility.getQuery(query, userId);
			Map<String, String[]> searchCriteria=new HashMap<>(); 
			searchCriteria.put("q", new String[] { query });
			searchCriteria.put("rows", new String[] { rows });
			searchCriteria.put("start", new String[] { start });
			searchCriteria.put("fl", new String[] { fl });
			searchCriteria.put("fq", fq);
			searchCriteria.put("sort", new String[] { sort });
			
			searchCriteria.put("facet", new String[] { facet } );
			searchCriteria.put("facet.query",  new String[] { facetQuery } );
			if (facetField != null && facetField.length > 0) {
			    searchCriteria.put("facet.field", facetField);
			}
			
		    var apiResponse = commonDocumentService.advanceSearchDocumentByTemplate(searchCriteria, url);
		
		    List<FacetField> facetFieldsResponse =  ((QueryResponse)apiResponse).getFacetFields();
				if(facet.equals("true")) {
		          advance=facetFieldsResponse.stream().map(this::mapToFacetFieldDTO).collect(Collectors.toList());
		        }
		
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
					model.addAttribute("advanced",advance);
				return model.addAttribute("data",((QueryResponse) apiResponse).getResults());
		}
	}
	
	@Hidden
	@ApiOperation(value = "This service used to search content by query")
	@RequestMapping(value="/searchUserById" , method=RequestMethod.GET)
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
	
@ApiOperation(value = "This service delete User by query")
@StandardApiResponses
@DeleteMapping("/user")
public ResponseEntity<?> deleteUserByQuery(
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
                new ResponseMessage.Builder("User deleted successfully with Query", 200)
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
	

    // Special methods for User controller
 
    // Special methods for User controller
	@ApiResponses(value = {
	@ApiResponse(
	        responseCode = "201",
	        description = "User created successfully",
	        content = @Content(
	            mediaType = "application/json",
	            schema = @Schema(oneOf = { ResponseMessage.class, UserSignUpExample.class })
	        )
	    ),
	    @ApiResponse(
	        responseCode = "400",
	        description = "Validation failed",
	        content = @Content(schema = @Schema(implementation = ResponseMessage.class))
	    ),
	    @ApiResponse(
	        responseCode = "409",
	        description = "Email already exists",
	        content = @Content(schema = @Schema(implementation = ResponseMessage.class))
	    ),
	    @ApiResponse(
	        responseCode = "500",
	        description = "Server error",
	        content = @Content(schema = @Schema(implementation = ResponseMessage.class))
	    )})			
	@PostMapping("/userSignUp")
	public ModelMap  userSignUp(@Valid @RequestBody User user) {
		ModelMap model = new ModelMap();
		
		
	    try {
	        // ============================================================
	        // 1️⃣ Validate Email Exists
	        // ============================================================
	        if (emailExists(user.getEmail())) {
	        	
	        	return model.addAttribute("data",
						new ResponseMessage.Builder("Email already exists", 409)
								.withResponseType("duplicate").build());
	        }

	        // ============================================================
	        // 2️⃣ Generate IDs (system-generated)
	        // ============================================================
	        String userId = Utility.getUniqueId();
	        String activationCode = Utility.getUniqueId();

	   //     user.setId(userId);

	        Map<String, Object> payload = new HashMap<>();
	        payload.put("ID", userId);
	        payload.put("email", user.getEmail());
	        payload.put("firstName", user.getFirstName());
	        payload.put("middleName", user.getMiddleName());
	        payload.put("lastName", user.getLastName());
	        payload.put("address", user.getAddress());
	        payload.put("company", user.getCompany());
	        payload.put("role", user.getRole());
	        payload.put("userActivationKey", activationCode);
			payload.put("password", user.getPassword());
	        // ============================================================
	        // 3️⃣ Persist into Solr
	        // ============================================================
	        Object apiResponse = commonDocumentService
	                .addDocumentAndExceptionByTemplate(payload, url);

	        if (apiResponse instanceof Exception) {
	        	return model.addAttribute("data",
						new ResponseMessage.Builder("Server error", 500)
								.withResponseType("error").build());
	        }

	        // ============================================================
	        // 4️⃣ SUCCESS RESPONSE
	        // ============================================================
	        
	    	model.addAttribute("data",
					new ResponseMessage.Builder("User registered successfully. Please activate using email verification code.", HttpStatus.CREATED.value())
							.withID(userId).withActivationCode(activationCode).withResponseType("created").build());
	        return model;
	    } catch (Exception ex) {
	    	return model.addAttribute("data",
					new ResponseMessage.Builder("Unexpected error", 500)
							.withResponseType("error").build());
	    }
	}
   
	@PostMapping("/user-authentication")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "API use for user authentication", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserAuthResponse.class))) })
	@StandardApiResponses
	public ModelMap userAuth(@RequestBody @Valid UserAuth userAuth, HttpServletResponse response) {

		ModelMap model = new ModelMap();
		Map<String, String[]> searchCriteria = new HashMap<>();
		searchCriteria.put("q", new String[] { "((email:" + userAuth.getUsername() + ") && ( email:"
				+ userAuth.getUsername() + " && password:" + userAuth.getPassword() + "))" });
		searchCriteria.put("fl", new String[] { "userStatus,ID" });

		QueryResponse apiResponse = commonDocumentService.advanceSearchDocumentByTemplate(searchCriteria, url);

		((QueryResponse) apiResponse).getResults().forEach((C) -> {

			if (C.get("userStatus").equals("I")) {
				// model.addAttribute("Message", new ResponseMessage("User is inactive. Please
				// activate user account.", 403,null,null,null,null,"INACTIVE"));
				model.addAttribute("Message",
						new ResponseMessage.Builder("User is inactive. Please activate user account.", 403)
								.withResponseType("INACTIVE").build());

				response.setStatus(HttpServletResponse.SC_FORBIDDEN);

			} else {
				response.setStatus(HttpServletResponse.SC_OK);
				String email = userAuth.getUsername();
			    String solrUserId = C.get("ID").toString();

			    String jwt = jwtUtil.generateToken(solrUserId, email);

			  
				model.addAttribute("data",
						new ResponseMessage.Builder("User authenticated sucesfully.", HttpServletResponse.SC_OK)
								.withID(C.get("ID").toString()).withToken(jwt).withResponseType("AUTHENTICATED").build());
			}
		}

		);
		if (apiResponse.getResults().size() == 0) {

			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
					model.addAttribute("Message",
					new ResponseMessage.Builder("User / password incorrect", HttpServletResponse.SC_UNAUTHORIZED)
							.withResponseType("UNAUTHORIZED").build());
		}
		return model;
	}



		//Activate user one created by Me on 30/05/2021
//		{
//		"ID": "516e1aa5-9510-46f7-8e0d-26bdebf30a17",
//		"userActivationKey": "1234"
//		}
//	
	@Deprecated
	@PostMapping("/activate-user")
	public ModelMap activateUser(@RequestBody Map<String, Object> payload, HttpServletResponse response) {
		/*
		 * userStatus=A means Activated user
		 * userStatus=I means In-Activated user
		 */

		ModelMap model = new ModelMap();
		String activationKey=(String)payload.get("userActivationKey");
		String userId=(String)payload.get("userId");
		
		Map<String, String[]> searchCriteria=new HashMap<>(); 
	//	searchCriteria.put("q", "userActivationKey:"+activationKey+ " && "+ "ID:"+userId+ " && "+ "userStatus: I");
		
		searchCriteria.put("q", new String[] { "ID:"+userId }  );
		
	//	QueryResponse res= commonDocumentService.advanceSearchDocumentByTemplate(searchCriteria, url);	
		
		QueryResponse apiResponse = commonDocumentService.advanceSearchDocumentByTemplate(searchCriteria, url);
		
		if (apiResponse.getResults().size() == 0) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		//	return model.addAttribute("Message", new ResponseMessage("Invalid User", 401));
			return model.addAttribute("Message", new ResponseMessage.Builder("Invalid User", 401).build());
		} 
		else if(apiResponse.getResults().get(0).get("userActivationKey").equals("Activated")) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			
		//	return	model.addAttribute("Message", new ResponseMessage("User already activate through email activation code.",  HttpServletResponse.SC_BAD_REQUEST,null,null,null,null,"Bad request"));					
		
			return model.addAttribute("Message", new ResponseMessage.Builder("User already activate through email activation code.", HttpServletResponse.SC_BAD_REQUEST)
					.withID(userId)
					.withResponseType("Bad request")
					.build());
			
			
		}
		else if(!apiResponse.getResults().get(0).get("userActivationKey").equals(activationKey)) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		
		//	return	model.addAttribute("Message", new ResponseMessage("Invalid activation Key",  HttpServletResponse.SC_BAD_REQUEST,null,null,null,null,"Invalid request"));					
		
			return model.addAttribute("Message", new ResponseMessage.Builder("Invalid activation Key", HttpServletResponse.SC_BAD_REQUEST)
					.withID(userId)
					.withResponseType("Invalid request")
					.build());
			
		//	return model.addAttribute("Message", new ResponseMessage("Invalid activation Key", 401));
		}
		
			SolrDocument solrDocument = apiResponse.getResults().get(0);
			solrDocument.put("userStatus", "A");
			solrDocument.put("userActivationKey", "Activated");
			
			commonDocumentService.updateDocumentAndExceptionByTemplate(solrDocument, url) ;
		//	model.addAttribute("userId",userId);
			response.setStatus(HttpServletResponse.SC_OK);
		//	model.addAttribute("Message", new ResponseMessage("User activated Sucesfully.",  HttpServletResponse.SC_OK,null,null,null,null,"activated"));					
			
			
			 model.addAttribute("Message", new ResponseMessage.Builder("User activated Sucesfully.", HttpServletResponse.SC_OK)
					.withID(userId)
					.withResponseType("activated")
					.build());
			
			return model;
		} 
	
	@PostMapping("/activate-user-new")
	public ModelMap activateUserNew(@RequestBody Map<String, Object> payload, HttpServletResponse response) {
		/*
		 * userStatus=A means Activated user
		 * userStatus=I means In-Activated user
		 */

		ModelMap model = new ModelMap();
		String userActivationKeyDecode=null;
		String userEmail =null;
		String activationKey=(String)payload.get("userActivationKey");
		try {
		byte[] decodedBytes = Base64.getDecoder().decode(activationKey);
		//	String decodedString = new String(decodedBytes);
			
			String[] parts = new String(decodedBytes).split("\\+", 2);
			 userActivationKeyDecode = parts[0];
			 userEmail = parts[1];
		}catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		//	return	model.addAttribute("Message", new ResponseMessage("Invalid activation code",  HttpServletResponse.SC_BAD_REQUEST,null,null,null,null,"Bad request"));
			
		return	model.addAttribute("Message", new ResponseMessage.Builder("Invalid activation code.", HttpServletResponse.SC_BAD_REQUEST)
																	.withResponseType("Bad request")
																	.build());
		}
		
		Map<String, String[]> searchCriteria=new HashMap<>(); 
	//	searchCriteria.put("q", "userActivationKey:"+activationKey+ " && "+ "ID:"+userId+ " && "+ "userStatus: I");
		
		searchCriteria.put("q", new String[] { "email:"+userEmail } );
		
	//	QueryResponse res= commonDocumentService.advanceSearchDocumentByTemplate(searchCriteria, url);	
		
		QueryResponse apiResponse = commonDocumentService.advanceSearchDocumentByTemplate(searchCriteria, url);
		
		if (apiResponse.getResults().size() == 0) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		//	return model.addAttribute("Message", new ResponseMessage("Invalid User", 401));
			
			return	model.addAttribute("Message", new ResponseMessage.Builder("Invalid User.", HttpServletResponse.SC_UNAUTHORIZED).build());
			
		} 
		else if(apiResponse.getResults().get(0).get("userActivationKey").equals("Activated")) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			
		//	return	model.addAttribute("Message", new ResponseMessage("User already activate through email activation code.",  HttpServletResponse.SC_BAD_REQUEST,null,null,null,null,"Bad request"));	
			
			return	model.addAttribute("Message", new ResponseMessage.Builder("User already activate through email activation code.", HttpServletResponse.SC_BAD_REQUEST)
																	 .withResponseType("Bad request")
																	 .build());
			
		}
		else if(!apiResponse.getResults().get(0).get("userActivationKey").equals(userActivationKeyDecode)) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		
		//	return	model.addAttribute("Message", new ResponseMessage("Invalid activation Key",  HttpServletResponse.SC_BAD_REQUEST,null,null,null,null,"Invalid request"));					
		
			return	model.addAttribute("Message", new ResponseMessage.Builder("Invalid activation Key", HttpServletResponse.SC_BAD_REQUEST)
					 .withResponseType("Invalid request")
					 .build());

			
		//	return model.addAttribute("Message", new ResponseMessage("Invalid activation Key", 401));
		}
		
			SolrDocument solrDocument = apiResponse.getResults().get(0);
			solrDocument.put("userStatus", "A");
			solrDocument.put("userActivationKey", "Activated");
			
			commonDocumentService.updateDocumentAndExceptionByTemplate(solrDocument, url) ;
		//	model.addAttribute("userId",userId);
			response.setStatus(HttpServletResponse.SC_OK);
		//	model.addAttribute("Message", new ResponseMessage("User activated Sucesfully.",  HttpServletResponse.SC_OK,null,null,null,null,"activated"));					
			
			 model.addAttribute("Message", new ResponseMessage.Builder("User activated Sucesfully.", HttpServletResponse.SC_OK)
															  .withResponseType("activated")
															  .build());
			return model;
		} 


		@ApiOperation(value = "This service used to get User details by based on token")
	@StandardApiResponses
	@RequestMapping(value="/me" , method=RequestMethod.GET)
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found",
                         content = @Content(mediaType = "application/json",
                         schema = @Schema(implementation = User.class)))
        })
	public ModelMap  getUserDetailsByToken(
			
			@RequestHeader("Authorization") String authHeader,
			HttpServletRequest request, HttpServletResponse response
			) {
		ModelMap model=new ModelMap();
		String token = authHeader.substring(7);
		User user =null;
		try {
			 user = jwtUtil.getUserDetailsFromToken(token);
		}catch (Exception e) {
			return model.addAttribute("data",
					new ResponseMessage.Builder("Server error", 500)
							.withResponseType("error").build());
		}
		return model.addAttribute("data",user);
		}


	private boolean emailExists(String email) {
		Map<String, String[]> searchCriteria=new HashMap<>(); 
		searchCriteria.put("q", new String[] { "email:"+email } );
		searchCriteria.put("rows",  new String[] { "1" } );
		searchCriteria.put("start", new String[] { "0" });
       return ((QueryResponse)	commonDocumentService.advanceSearchDocumentByTemplate(searchCriteria, url)).getResults().size() > 0 ? true :false  ;
	
	}

	
	
}
