/*

package com.spring.rest.util;

public interface SolrUrls {
	public static String protocol="http";
			
	public static String host="solr-service-ddf1a570-8722-4903-9c1a-1a3af36a2f59";
			
	
    public static String port="80";
	public static String context="solr";
							
      public static String baseUrl= protocol+"://"+host+":"+port+"/"+context;
	
  //  public static String APIKEY_URL= protocol+"://"+host+":"+port+"/"+context+"/apiKey";


    public static String APIKEY_URL = protocol + "://" + host + ":" + port + "/" + context + "/apiKey";

    public static final String USER_URL = baseUrl+"/"+"User";
}

*/


package com.spring.rest.util;

public interface SolrUrls {
    public static String protocol = "http";
    public static String host = "solr-service-ddf1a570-8722-4903-9c1a-1a3af36a2f59";
    public static String port = "80";
    public static String context = "solr";
							
    public static String baseUrl = protocol + "://" + host + ":" + port + "/" + context;

    public static String APIKEY_URL = protocol + "://" + host + ":" + port + "/" + context + "/apiKey";

    public static final String USER_URL = baseUrl + "/" + "User";
}

