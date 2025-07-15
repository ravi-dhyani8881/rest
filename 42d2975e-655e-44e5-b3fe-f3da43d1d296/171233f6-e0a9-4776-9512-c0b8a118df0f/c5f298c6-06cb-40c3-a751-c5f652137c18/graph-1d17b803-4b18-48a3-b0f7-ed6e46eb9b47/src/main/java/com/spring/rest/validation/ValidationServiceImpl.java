package com.spring.rest.validation;

import javax.servlet.http.HttpServletResponse;

import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.rest.service.CommonDocumentService;
import com.spring.rest.util.SolrUrls;

@Component
public class ValidationServiceImpl implements ValidationService {
	
	@Autowired
	CommonDocumentService commonDocumentService;
	String url=SolrUrls.APIKEY_URL;
	@Override
	public int validateApiKey(String apiKey, String userId) {
		String query="ID:"+userId+" && apiKey:"+apiKey+" && status: A";
		Object queryResponse=commonDocumentService.advanceQueryByTemplate(query,url);
		
		if(queryResponse instanceof Exception) {
			return HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
		}else if(((QueryResponse)queryResponse).getResults().size() >0) {
			return HttpServletResponse.SC_OK;
		}else if(((QueryResponse)queryResponse).getResults().size() ==0){
			return HttpServletResponse.SC_UNAUTHORIZED;		
		}
		return 0;
	}
}