package com.spring.rest.util;

public interface SolrUrls {
	public static String protocol="http";
			
	public static String host="solr-service-aa7098b5-0f03-4f41-bb10-db9a919a52eb";
			
	
    public static String port="80";
	public static String context="solr";
							
      public static String baseUrl= protocol+"://"+host+":"+port+"/"+context;
	
    public static String APIKEY_URL= protocol+"://"+host+":"+port+"/"+context+"/apiKey";
	

    public static final String REVIEWS_URL = baseUrl+"/"+"reviews";
    public static final String PRODUCTS_URL = baseUrl+"/"+"products";
    public static final String RATINGS_URL = baseUrl+"/"+"ratings";
}
