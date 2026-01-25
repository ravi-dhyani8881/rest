/*

package com.spring.rest.util;

public interface SolrUrls {
	public static String protocol="http";
			
	public static String host="solr-service-50f89a6b-2a8c-451f-bddf-2d7efb75110e";
			
	
    public static String port="80";
	public static String context="solr";
							
      public static String baseUrl= protocol+"://"+host+":"+port+"/"+context;
	
  //  public static String APIKEY_URL= protocol+"://"+host+":"+port+"/"+context+"/apiKey";


    public static String APIKEY_URL = protocol + "://" + host + ":" + port + "/" + context + "/apiKey";

    public static final String USERS_URL = baseUrl+"/"+"users";
}

*/


package com.spring.rest.util;

public interface SolrUrls {
    public static String protocol = "http";
    public static String host = "solr-service-50f89a6b-2a8c-451f-bddf-2d7efb75110e";
    public static String port = "80";
    public static String context = "solr";
							
    public static String baseUrl = protocol + "://" + host + ":" + port + "/" + context;

    public static String APIKEY_URL = protocol + "://" + host + ":" + port + "/" + context + "/apiKey";

    public static final String USERS_URL = baseUrl + "/" + "users";
}

