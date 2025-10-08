package com.spring.rest.util;

public interface SolrUrls {
	public static String protocol="http";
			
	public static String host="solr-service-2566dc81-6e7f-41a6-b391-14b9493ff73b";
			
	
    public static String port="80";
	public static String context="solr";
							
      public static String baseUrl= protocol+"://"+host+":"+port+"/"+context;
	
    public static String APIKEY_URL= protocol+"://"+host+":"+port+"/"+context+"/apiKey";
	

    public static final String PRODUCTS_URL = baseUrl+"/"+"products";
    public static final String SALES_URL = baseUrl+"/"+"sales";
    public static final String PURCHASES_URL = baseUrl+"/"+"purchases";
}
