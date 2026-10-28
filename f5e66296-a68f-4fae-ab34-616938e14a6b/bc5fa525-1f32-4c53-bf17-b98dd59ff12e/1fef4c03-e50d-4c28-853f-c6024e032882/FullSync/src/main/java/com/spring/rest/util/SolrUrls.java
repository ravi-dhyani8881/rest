/*

package com.spring.rest.util;

public interface SolrUrls {
	public static String protocol="http";
			
	public static String host="solr-service-0de66117-2ae7-4309-8feb-43ac0d57e8e6";
			
	
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
    public static String host = "solr-service-0de66117-2ae7-4309-8feb-43ac0d57e8e6";
    public static String port = "80";
    public static String context = "solr";
							
    public static String baseUrl = protocol + "://" + host + ":" + port + "/" + context;

    public static String APIKEY_URL = protocol + "://" + host + ":" + port + "/" + context + "/apiKey";

    public static final String USER_URL = baseUrl + "/" + "User";
}

