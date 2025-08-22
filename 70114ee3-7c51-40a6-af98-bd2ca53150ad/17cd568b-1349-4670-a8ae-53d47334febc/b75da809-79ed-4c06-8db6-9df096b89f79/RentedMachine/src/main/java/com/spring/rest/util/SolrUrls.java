package com.spring.rest.util;

public interface SolrUrls {
	public static String protocol="http";
			
	public static String host="solr-service-de3d7ca2-c067-4881-8cd4-4688ffd4e1dc";
			
	
    public static String port="80";
	public static String context="solr";
							
      public static String baseUrl= protocol+"://"+host+":"+port+"/"+context;
	
    public static String APIKEY_URL= protocol+"://"+host+":"+port+"/"+context+"/apiKey";
	

    public static final String DISTRIBUTION_URL = baseUrl+"/"+"Distribution";
    public static final String VENDER_URL = baseUrl+"/"+"vender";
    public static final String PRODUCTRATINGS_URL = baseUrl+"/"+"productRatings";
}
