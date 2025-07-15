package com.spring.rest.util;

public interface SolrUrls {
	public static String protocol="http";
			
	public static String host="solr-service-cb24d1f9-d384-4cdb-8274-44c76eb1ab34";
			
	
    public static String port="80";
	public static String context="solr";
							
      public static String baseUrl= protocol+"://"+host+":"+port+"/"+context;
	
 //   public static String APIKEY_URL= protocol+"://"+host+":"+port+"/"+context+"/apiKey";
	

    public static final String USERS_URL = baseUrl+"/"+"users";
    public static final String PROFILE_URL = baseUrl+"/"+"profile";
}
