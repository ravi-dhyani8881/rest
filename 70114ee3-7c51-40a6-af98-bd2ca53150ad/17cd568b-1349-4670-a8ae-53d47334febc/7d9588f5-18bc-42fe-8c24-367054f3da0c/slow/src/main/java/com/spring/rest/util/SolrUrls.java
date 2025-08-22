package com.spring.rest.util;

public interface SolrUrls {
	public static String protocol="http";
			
	public static String host="solr-service-630af869-856a-4261-9a9a-4066c9c15d85";
			
	
    public static String port="80";
	public static String context="solr";
							
      public static String baseUrl= protocol+"://"+host+":"+port+"/"+context;
	
    public static String APIKEY_URL= protocol+"://"+host+":"+port+"/"+context+"/apiKey";
	

    public static final String PRODUCTS_URL = baseUrl+"/"+"products";
    public static final String REVIEWS_URL = baseUrl+"/"+"reviews";
    public static final String PRODUCTRATINGS_URL = baseUrl+"/"+"productRatings";
}
