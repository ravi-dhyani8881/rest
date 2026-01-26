/*

package com.spring.rest.util;

public interface SolrUrls {
	public static String protocol="http";
			
	public static String host="solr-service-05a9a253-a873-43ca-8913-d317e491c165";
			
	
    public static String port="80";
	public static String context="solr";
							
      public static String baseUrl= protocol+"://"+host+":"+port+"/"+context;
	
  //  public static String APIKEY_URL= protocol+"://"+host+":"+port+"/"+context+"/apiKey";


    public static String APIKEY_URL = protocol + "://" + host + ":" + port + "/" + context + "/apiKey";

    public static final String PRODUCTS_URL = baseUrl+"/"+"products";
    public static final String USERS_URL = baseUrl+"/"+"users";
    public static final String REVIEWS_URL = baseUrl+"/"+"reviews";
}

*/


package com.spring.rest.util;

public interface SolrUrls {
    public static String protocol = "http";
    public static String host = "solr-service-05a9a253-a873-43ca-8913-d317e491c165";
    public static String port = "80";
    public static String context = "solr";
							
    public static String baseUrl = protocol + "://" + host + ":" + port + "/" + context;

    public static String APIKEY_URL = protocol + "://" + host + ":" + port + "/" + context + "/apiKey";

    public static final String PRODUCTS_URL = baseUrl + "/" + "products";
    public static final String USERS_URL = baseUrl + "/" + "users";
    public static final String REVIEWS_URL = baseUrl + "/" + "reviews";
}

