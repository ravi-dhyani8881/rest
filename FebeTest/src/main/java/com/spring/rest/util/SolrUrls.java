package com.spring.rest.util;

public interface SolrUrls {
	public static String protocol="http";
			
	public static String host="solr-service-";
			
	
    public static String port="80";
	public static String context="solr";
							
	public static String baseUrl= protocol+"://"+host+":"+port+"/"+context;
	
    public static String APIKEY_URL= protocol+"://"+host+":"+port+"/"+context+"/apiKey";
	

    public static final String USERS_URL = baseUrl+"/"+"users";
    public static final String PROFILES_URL = baseUrl+"/"+"profiles";
    public static final String PRODUCT_URL = baseUrl+"/"+"product";
    public static final String ORDERS_URL = baseUrl+"/"+"orders";
}