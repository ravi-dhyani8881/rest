package com.spring.rest.util;

public interface SolrUrls {
	public static String protocol="http";
			
	public static String host="solr-service-5b331d9f-3592-499f-8dc3-18626338bbf2";
			
	
    public static String port="80";
	public static String context="solr";
							
      public static String baseUrl= protocol+"://"+host+":"+port+"/"+context;
	
    public static String APIKEY_URL= protocol+"://"+host+":"+port+"/"+context+"/apiKey";
	

    public static final String REVIEWS_URL = baseUrl+"/"+"reviews";
}
