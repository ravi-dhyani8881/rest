/*

package com.spring.rest.util;

public interface SolrUrls {
	public static String protocol="http";
			
	public static String host="solr-service-6b2273ee-92f6-45d2-b731-fa95e1cde686";
			
	
    public static String port="80";
	public static String context="solr";
							
      public static String baseUrl= protocol+"://"+host+":"+port+"/"+context;
	
  //  public static String APIKEY_URL= protocol+"://"+host+":"+port+"/"+context+"/apiKey";


    public static String APIKEY_URL = protocol + "://" + host + ":" + port + "/" + context + "/apiKey";

    public static final String BUS_ROUTES_URL = baseUrl+"/"+"bus_routes";
    public static final String STOPS_URL = baseUrl+"/"+"stops";
    public static final String ROUTES_STOPS_URL = baseUrl+"/"+"routes_stops";
}

*/


package com.spring.rest.util;

public interface SolrUrls {
    public static String protocol = "http";
    public static String host = "solr-service-6b2273ee-92f6-45d2-b731-fa95e1cde686";
    public static String port = "80";
    public static String context = "solr";
							
    public static String baseUrl = protocol + "://" + host + ":" + port + "/" + context;

    public static String APIKEY_URL = protocol + "://" + host + ":" + port + "/" + context + "/apiKey";

    public static final String BUS_ROUTES_URL = baseUrl + "/" + "bus_routes";
    public static final String STOPS_URL = baseUrl + "/" + "stops";
    public static final String ROUTES_STOPS_URL = baseUrl + "/" + "routes_stops";
}

