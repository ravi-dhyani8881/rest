package com.spring.rest.service;

import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.rest.solr.SolrConnection;
import com.spring.rest.util.ResponseMessage;
import com.spring.rest.util.Utility;


@Component
public class CommonDocumentServiceImpl implements CommonDocumentService{
	
	@Autowired
	SolrConnection solrConnection;

	public String addDocument(Map<String, Object> payload,String url) {
		String ID=Utility.getUniqueId();
			SolrInputDocument document = new SolrInputDocument();
			document.addField("ID",ID);
			try {
		 	solrConnection.addDocument(url, this.createDoc2(payload, document));	
		}catch (Exception  e ) {
			e.printStackTrace();
		}
		
		return ID;
	}
	
	
	public String updateDocument(Map<String, Object> payload, String url) {
		SolrInputDocument document = new SolrInputDocument();
		 solrConnection.updateDocument(url, this.createDoc2(payload, document));
		return "sucess";
	}
	
	public QueryResponse advanceSearchDocument(Map<String, String[]> searchCriteria,String url) {
		
		return solrConnection.advanceSerach(url, searchCriteria);
	}

	
	public QueryResponse SearchByQuery(String query, String url) {
		return solrConnection.serachDocument(url, query);
	}

	
	public ResponseMessage addDocumentWithError(Map<String, Object> payload, String url) {
		String ID=Utility.getUniqueId();
		SolrInputDocument document = new SolrInputDocument();
		document.addField("ID",ID);
	 	solrConnection.addDocument(url, this.createDoc2(payload, document));
		return null;
	}

	
	public <T> T advanceSearchDocumentByTemplate(Map<String, String[]> searchCriteria, String url) {
		return solrConnection.advanceSerachByTemplate(url, searchCriteria);
	}
	
	public <T> T addDocumentByTemplate(Map<String, Object> payload,String url) {	 	
		return (T) solrConnection.addDocumentByTemplate(url, this.createDoc(payload));
	}
	
	
	
	public <T> T updateDocumentByTemplate(Map<String, Object> payload, String url) {
		return (T)  solrConnection.updateDocumentByTemplate(url, this.createDoc(payload));
	}
	
	
	
	public <T> T deleteDocumentByTemplate(String query, String url) {
		return (T)  solrConnection.deleteByTemplate(url, query);
	}
	
	
	
	public <T> T advanceQueryByTemplate(String query, String url) {
		return (T) solrConnection.serachQueryByTemplate(url, query);
	}

	
	
	public SolrInputDocument createDoc(Object payload) {
	    SolrInputDocument document = new SolrInputDocument();
	    if (payload == null) {
	        return document; // return empty doc if no payload
	    }
	    try {
	        Map<String, Object> map;
	        if (payload instanceof Map) {
	            // ✅ If payload is already a Map, cast directly
	            map = (Map<String, Object>) payload;
	        } else {
	            // ✅ Convert POJO → Map
	            ObjectMapper mapper = new ObjectMapper();
	            map = mapper.convertValue(payload, Map.class);
	        }
	        map.forEach((k, v) -> {
	            if (v != null) {
	                document.addField(k, v);
	            }
	        });
	    } catch (Exception e) {
	        throw new RuntimeException("Failed to convert payload to SolrInputDocument", e);
	    }
	    return document;
	}
	public SolrInputDocument createDoc(Map<String, Object> payload) {
		SolrInputDocument document = new SolrInputDocument();
		payload.forEach((k,v) ->{
	 		document.addField(k, v);
	 	});
		return document;
	}
	
	public SolrInputDocument createDoc2(Map<String, Object> payload, SolrInputDocument document) {
		payload.forEach((k,v) ->{
	 		document.addField(k, v);
	 	});
		return document;
	}

	@Override
	public <T> T advanceSearchDocumentAndExceptionByTemplate(Map<String, String[]> searchCriteria, String url,SolrQuery solrQuery) {
		return (T)solrConnection.advanceSerachAndExceptionByTemplate(url, searchCriteria,solrQuery);
		
	}

	@Override
	public <T> T addDocumentAndExceptionByTemplate(Object payload, String url) {
		return (T) solrConnection.addDocumentAndExceptionByTemplate(url, this.createDoc(payload));
	}

	@Override
	public <T> T updateDocumentAndExceptionByTemplate(Object payload, String url) {
		return (T) solrConnection.updateDocumentAndExceptionByTemplate(url, this.createDoc(payload));
		
	}

	@Override
	public <T> T deleteDocumentAndExceptionByTemplate(String query, String url) {
		return (T)  solrConnection.deleteByAndExceptionTemplate(url, query);
	}

	@Override
	public <T> T advanceQueryAndExceptionByTemplate(String query, String url) {
		return solrConnection.serachQueryAndExceptionByTemplate(url, query);
	}
}