package com.spring.rest.util;

public interface SolrUrls {
	public static String protocol="http";
			
	public static String host="solr-service-98451fb4-15a4-4418-95a4-67d5e5c3d0e1";
			
	
    public static String port="80";
	public static String context="solr";
							
      public static String baseUrl= protocol+"://"+host+":"+port+"/"+context;
	
    public static String APIKEY_URL= protocol+"://"+host+":"+port+"/"+context+"/apiKey";
	

    public static final String REVIEWS_URL = baseUrl+"/"+"reviews";
}
