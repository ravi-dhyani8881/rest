package com.spring.rest.util;

public interface SolrUrls {
	public static String protocol="http";
			
	public static String host="solr-service-0f460a37-725d-4a7a-8070-e49b8461b064";
			
	
    public static String port="80";
	public static String context="solr";
							
      public static String baseUrl= protocol+"://"+host+":"+port+"/"+context;
	
    public static String APIKEY_URL= protocol+"://"+host+":"+port+"/"+context+"/apiKey";
	

    public static final String REVIEWS_URL = baseUrl+"/"+"reviews";
}
