package com.spring.rest.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.service.CommonDocumentService;
import com.spring.rest.util.ResponseMessage;
import com.spring.rest.util.SolrUrls;
import com.spring.rest.util.Utility;
import com.spring.rest.validation.ValidationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Environment Mangment System" , description = "Service used to perform operation on environment.", tags = "environment")
@RestController
@ExposesResourceFor(EnvironmentController.class)
@RequestMapping("/Environment")
public class EnvironmentController {
	
	@Autowired
	CommonDocumentService commonDocumentService;
	
	@Autowired
	ValidationService validationService;
	
    String url=SolrUrls.ENVIRONMENT_URL;
    
		
	@ApiOperation(value = "Service used to add Environment")
	@RequestMapping(value="/addEnvironment" , method=RequestMethod.POST)
	public ModelMap  addEnvironment(@RequestBody Map<String, Object> payload , HttpServletResponse response, HttpServletRequest request,
			@RequestHeader(name="X-API-Key", required=true) String apiKey ,
			@RequestHeader(name="X-USER-ID", required=true) String userId) {
		
		ModelMap model=new ModelMap();
	//	String contentId=Utility.getUniqueId();
		
		String contentId = payload.containsKey("ID") && payload.get("ID") != null ? payload.get("ID").toString() : Utility.getUniqueId();

		
		String requestUri = request.getRequestURI();
		System.out.println("--->"+requestUri.substring(0));
		
		
		if(validationService.validateApiKey(apiKey, userId) == 500 )
		{	
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		//	return model.addAttribute("Message", new ResponseMessage("Server down Internal server error", 500));
			return model.addAttribute("Message", new ResponseMessage.Builder("Server down Internal server error", 500).build());
			 
		}else if(validationService.validateApiKey(apiKey, userId) == 401) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	//		 return model.addAttribute("Message", new ResponseMessage("Invalid Api Key", 403));
			return model.addAttribute("Message", new ResponseMessage.Builder("Invalid Api Key", 403).build());
		}
		try {
			
			if (!payload.containsKey("ID") || payload.get("ID") == null) {
		        payload.put("ID", contentId);
		        
		    }
		 //       payload.put("ID", contentId);
		//	payload.put("custId", userId);
			Object apiResponse = commonDocumentService.addDocumentByTemplate(payload, url);
			
			if(apiResponse instanceof Exception )
			{
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			//	return model.addAttribute("Message", new ResponseMessage("Server down Internal server error", 500));
				return model.addAttribute("Message", new ResponseMessage.Builder("Server down Internal server error", 500).build());	
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	//	return model.addAttribute("Message", new ResponseMessage("Content added Sucesfully", 201,contentId,"created"));
		
		return model.addAttribute("Message", new ResponseMessage.Builder("Content added Sucesfully", 201)
																.withID(contentId)
																.withResponseType("created")
																.build());
	}
	
	@ApiOperation(value = "This service used to update Environment")
	@RequestMapping(value="/updateEnvironment" , method=RequestMethod.PUT)
	public ModelMap  updateenvironment(@RequestBody Map<String, Object> payload , HttpServletResponse response, HttpServletRequest request,
			@RequestHeader(name="X-API-Key", required=true) String apiKey ,
			@RequestHeader(name="X-USER-ID", required=true) String userId) {
		
		ModelMap model=new ModelMap();
		String contentId=null;
		
	
		
		if(validationService.validateApiKey(apiKey, userId) == 500 )
		{	
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		//	return model.addAttribute("Message", new ResponseMessage("Server down Internal server error", 500));
			return model.addAttribute("Message", new ResponseMessage.Builder("Server down Internal server error", 500).build());
			
		}else if(validationService.validateApiKey(apiKey, userId) == 401) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			// return model.addAttribute("Message", new ResponseMessage("Invalid Api Key", 401));
			return model.addAttribute("Message", new ResponseMessage.Builder("Invalid Api Key", 401).build());
			
			 
		} else if(!payload.containsKey("ID")) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			// return model.addAttribute("Message", new ResponseMessage("Unique ID missing from request, Invalid ID", 400));
			return model.addAttribute("Message", new ResponseMessage.Builder("Unique ID missing from request, Invalid ID", 400).build());
		}
		
		try {
			contentId=(String) payload.get("ID");
			Object apiResponse =commonDocumentService.advanceQueryByTemplate("ID:"+contentId, url);
					
			if(apiResponse instanceof Exception )
			{
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			//	return model.addAttribute("Message", new ResponseMessage("Server down Internal server error", 500));
				return model.addAttribute("Message", new ResponseMessage.Builder("Server down Internal server error", 500).build());
			}else if(((QueryResponse) apiResponse).getResults().size() == 0) {
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			//	return model.addAttribute("Message", new ResponseMessage("No Unique ID to update, Invalid ID", 400));
				return model.addAttribute("Message", new ResponseMessage.Builder("No Unique ID to update, Invalid ID", 400).build());
				
			}else {
				SolrDocument solrDocument = ((QueryResponse) apiResponse).getResults().get(0);
				apiResponse =commonDocumentService.updateDocumentByTemplate(this.createDoc(payload, solrDocument), url) ;	
			}			
		//	return model.addAttribute("Message", new ResponseMessage("Content updated Sucesfully", 201,contentId,"created"));
			
			return model.addAttribute("Message", new ResponseMessage.Builder("Content updated Sucesfully", 201)
																	.withID(contentId)
																	.withResponseType("created")
																	.build());
		}catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		//	return model.addAttribute("Message", new ResponseMessage("Server down Internal server error", 500));
			return model.addAttribute("Message", new ResponseMessage.Builder("Server down Internal server error", 500).build());
		}	
	}
	
	@ApiOperation(value = "This service used to search Environment by query")
	@RequestMapping(value="/searchEnvironmentByQuery" , method=RequestMethod.GET)
	public ModelMap  advanceSearch(@RequestParam(name = "query", required = true) String query,
			@RequestParam(name = "rows",  defaultValue = "8", required = false) String rows ,
			@RequestParam(name = "start",defaultValue = "0", required = false) String start,
			@RequestParam(name = "fl" ,defaultValue = "" , required = false) String fl ,
			@RequestParam(name = "fq" ,defaultValue = "" , required = false) String fq ,
			//default value asc|desc
			@RequestParam(name = "sort" ,defaultValue = "" , required = false) String sort,
			@RequestHeader(name="X-API-Key", required=true) String apiKey ,
			@RequestHeader(name="X-USER-ID", required=true) String userId,
		
			HttpServletRequest request, HttpServletResponse response
			) {
		ModelMap model=new ModelMap();
		Object apiResponse=null;
		
		
		
		
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
	//		query=Utility.getQuery(query, userId);
			Map<String, String> searchCriteria=new HashMap<String,String>(); 
			searchCriteria.put("q", query);
			searchCriteria.put("rows", rows);
			searchCriteria.put("start", start);
			searchCriteria.put("fl", fl);
			searchCriteria.put("fq", fq);
			searchCriteria.put("sort", sort);
			
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
				
				return model.addAttribute("result",((QueryResponse) apiResponse).getResults());
			}
		}
	}
	
	@ApiOperation(value = "This service used to search content by query")
	@RequestMapping(value="/searchEnvironmentById" , method=RequestMethod.GET)
	public ModelMap  searchContentById(@RequestParam(name = "Id", required = true) String query,
			@RequestParam(name = "rows",  defaultValue = "8", required = false) String rows ,
			@RequestParam(name = "start",defaultValue = "0", required = false) String start,
			@RequestParam(name = "fl" ,defaultValue = "" , required = false) String fl ,
			@RequestParam(name = "fq" ,defaultValue = "" , required = false) String fq ,
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
			Map<String, String> searchCriteria=new HashMap<String,String>(); 
			searchCriteria.put("q", query);
			searchCriteria.put("rows", rows);
			searchCriteria.put("start", start);
			searchCriteria.put("fl", fl);
			searchCriteria.put("fq", fq);
			searchCriteria.put("sort", sort);
			
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
	
	@ApiOperation(value = "This service delete Environment by query")
	@RequestMapping(value="/deleteEnvironmentByQuery" , method=RequestMethod.DELETE)
	public ModelMap  deleteByQuery(@RequestParam(name = "query", required = true) String query , 
			HttpServletResponse response, HttpServletRequest request,
			@RequestHeader(name="X-API-Key", required=true) String apiKey ,
			@RequestHeader(name="X-USER-ID", required=true) String userId) {
		
		ModelMap model=new ModelMap();
		
		
		if(validationService.validateApiKey(apiKey, userId) == 500 )
		{	
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		//	return model.addAttribute("Message", new ResponseMessage("Server down Internal server error", 500));
			return model.addAttribute("Message", new ResponseMessage.Builder("Server down Internal server error", 500).build());
			 
		}else if(validationService.validateApiKey(apiKey, userId) == 401) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			 // return model.addAttribute("Message", new ResponseMessage("Invalid Api Key",401));
			return model.addAttribute("Message", new ResponseMessage.Builder("Invalid Api Key", 401).build());
			
		}
		
		Object apiResponse = commonDocumentService.deleteDocumentByTemplate(query, url);
		
		if(apiResponse instanceof Exception )
		{
			if(((Exception) apiResponse).getMessage().contains("SyntaxError")) {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			//	return model.addAttribute("Message", new ResponseMessage("Invalid Query or SyntaxError, SyntaxError", 401));
				return model.addAttribute("Message", new ResponseMessage.Builder("Invalid Api Key", 401).build());
				
			}else{
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			//	return model.addAttribute("Message", new ResponseMessage("Server down Internal server error", 500));
				return model.addAttribute("Message", new ResponseMessage.Builder("Server down Internal server error", 500).build());
			}
		}
	//	return model.addAttribute("Message", new ResponseMessage("Content deleted Sucesfully with Query", 200,query,"deleted"));
		return model.addAttribute("Message", new ResponseMessage.Builder("Content deleted Sucesfully with Query", 200)
																.withQuery(query)
																.withResponseType("deleted")
																.build());
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


	
	
}