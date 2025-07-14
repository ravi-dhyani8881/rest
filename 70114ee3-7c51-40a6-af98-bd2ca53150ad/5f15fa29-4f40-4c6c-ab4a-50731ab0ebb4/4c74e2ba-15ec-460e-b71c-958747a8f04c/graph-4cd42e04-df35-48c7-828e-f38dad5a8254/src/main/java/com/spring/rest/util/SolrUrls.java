package com.spring.rest.util;

public interface SolrUrls {
	public static String protocol="http";
			
	public static String host="solr-service-4c74e2ba-15ec-460e-b71c-958747a8f04c";
			
	
    public static String port="80";
	public static String context="solr";
							
      public static String baseUrl= protocol+"://"+host+":"+port+"/"+context;
	
 //   public static String APIKEY_URL= protocol+"://"+host+":"+port+"/"+context+"/apiKey";
	

    public static final String USER_URL = baseUrl+"/"+"user";
    public static final String ORGANIZATION_URL = baseUrl+"/"+"organization";
    public static final String SUBORGANIZATION_URL = baseUrl+"/"+"subOrganization";
    public static final String ENVIRONMENT_URL = baseUrl+"/"+"environment";
    public static final String GRAPH_URL = baseUrl+"/"+"graph";
    public static final String PUBLISHGRAPH_URL = baseUrl+"/"+"publishGraph";
    public static final String PUBLISHREST_URL = baseUrl+"/"+"publishRest";
    public static final String APIKEY_URL = baseUrl+"/"+"apiKey";
    public static final String USERSETTING_URL = baseUrl+"/"+"userSetting";
    public static final String GRAPHSTATUS_URL = baseUrl+"/"+"graphStatus";
    public static final String GRAPHDEPLOYMENTSTATUS_URL = baseUrl+"/"+"graphDeploymentStatus";
}
