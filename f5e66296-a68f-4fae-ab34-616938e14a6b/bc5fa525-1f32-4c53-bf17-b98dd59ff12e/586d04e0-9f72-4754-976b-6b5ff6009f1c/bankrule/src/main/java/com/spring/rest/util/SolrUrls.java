/*

package com.spring.rest.util;

public interface SolrUrls {
	public static String protocol="http";
			
	public static String host="solr-service-073b6124-e8f2-41df-b9a3-4145c33b0e62";
			
	
    public static String port="80";
	public static String context="solr";
							
      public static String baseUrl= protocol+"://"+host+":"+port+"/"+context;
	
  //  public static String APIKEY_URL= protocol+"://"+host+":"+port+"/"+context+"/apiKey";


    public static String APIKEY_URL = protocol + "://" + host + ":" + port + "/" + context + "/apiKey";

    public static final String BANKRULE_URL = baseUrl+"/"+"bankrule";
}

*/


package com.spring.rest.util;

public interface SolrUrls {
    public static String protocol = "http";
    public static String host = "solr-service-073b6124-e8f2-41df-b9a3-4145c33b0e62";
    public static String port = "80";
    public static String context = "solr";
							
    public static String baseUrl = protocol + "://" + host + ":" + port + "/" + context;

    public static String APIKEY_URL = protocol + "://" + host + ":" + port + "/" + context + "/apiKey";

    public static final String BANKRULE_URL = baseUrl + "/" + "bankrule";
}

