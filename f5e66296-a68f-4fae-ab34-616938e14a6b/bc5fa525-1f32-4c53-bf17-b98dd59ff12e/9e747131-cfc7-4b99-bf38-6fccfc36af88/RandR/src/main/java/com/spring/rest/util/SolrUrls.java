/*

package com.spring.rest.util;

public interface SolrUrls {
	public static String protocol="http";
			
	public static String host="solr-service-e90ea533-89c5-4761-af3b-4b2473c47e85";
			
	
    public static String port="80";
	public static String context="solr";
							
      public static String baseUrl= protocol+"://"+host+":"+port+"/"+context;
	
  //  public static String APIKEY_URL= protocol+"://"+host+":"+port+"/"+context+"/apiKey";


    public static String APIKEY_URL = protocol + "://" + host + ":" + port + "/" + context + "/apiKey";

    public static final String CONTENT_URL = baseUrl+"/"+"content";
    public static final String USER_URL = baseUrl+"/"+"user";
    public static final String REVIEW_URL = baseUrl+"/"+"review";
    public static final String LIKE_URL = baseUrl+"/"+"like";
    public static final String HELPFULL_URL = baseUrl+"/"+"helpfull";
    public static final String DISLIKE_URL = baseUrl+"/"+"dislike";
    public static final String REPLY_URL = baseUrl+"/"+"reply";
}

*/


package com.spring.rest.util;

public interface SolrUrls {
    public static String protocol = "http";
    public static String host = "solr-service-e90ea533-89c5-4761-af3b-4b2473c47e85";
    public static String port = "80";
    public static String context = "solr";
							
    public static String baseUrl = protocol + "://" + host + ":" + port + "/" + context;

    public static String APIKEY_URL = protocol + "://" + host + ":" + port + "/" + context + "/apiKey";

    public static final String CONTENT_URL = baseUrl + "/" + "content";
    public static final String USER_URL = baseUrl + "/" + "user";
    public static final String REVIEW_URL = baseUrl + "/" + "review";
    public static final String LIKE_URL = baseUrl + "/" + "like";
    public static final String HELPFULL_URL = baseUrl + "/" + "helpfull";
    public static final String DISLIKE_URL = baseUrl + "/" + "dislike";
    public static final String REPLY_URL = baseUrl + "/" + "reply";
}

