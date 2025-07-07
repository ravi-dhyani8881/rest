package com.spring.rest.util;

public interface SolrUrls {
	public static String protocol="http";
			
	public static String host="solr-service-9dd0c8bf-0a27-4293-9442-db5b86a7c07f";
			
	
    public static String port="80";
	public static String context="solr";
							
      public static String baseUrl= protocol+"://"+host+":"+port+"/"+context;
	
 //   public static String APIKEY_URL= protocol+"://"+host+":"+port+"/"+context+"/apiKey";
	

    public static final String CONTENT2_URL = baseUrl+"/"+"content2";
    public static final String RAVIME2_URL = baseUrl+"/"+"ravime2";
    public static final String ORDERS_URL = baseUrl+"/"+"orders";
    public static final String HEADSHEET_URL = baseUrl+"/"+"headsheet";
    public static final String APIKEY_URL = baseUrl+"/"+"apiKey";
    public static final String USERS_URL = baseUrl+"/"+"users";
}
