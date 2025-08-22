package com.spring.rest.util;

public interface SolrUrls {
	public static String protocol="http";
			
	public static String host="solr-service-2f06784f-c6b6-4778-90a2-8fa5124eef88";
			
	
    public static String port="80";
	public static String context="solr";
							
      public static String baseUrl= protocol+"://"+host+":"+port+"/"+context;
	
    public static String APIKEY_URL= protocol+"://"+host+":"+port+"/"+context+"/apiKey";
	

    public static final String DISTRIBUTION_URL = baseUrl+"/"+"Distribution";
    public static final String VENDER_URL = baseUrl+"/"+"vender";
    public static final String PRODUCTRATINGS_URL = baseUrl+"/"+"productRatings";
}
