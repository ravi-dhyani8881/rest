package com.spring.rest.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data // Generates getters, setters, toString, equals, hashCode
@NoArgsConstructor // Generates a no-argument constructor (required by Jackson for deserialization)
@AllArgsConstructor // Generates a constructor with all fields
@JsonInclude(JsonInclude.Include.NON_NULL) 
public class PublishRest implements Serializable {


    private String iD;
    private String orgID;
    private String subOrgID;
    private String envId;
    private String userId;
    private String publish_rest_json;
    private String publish_type;
    private String version;


/*

    private String iD;
    private String orgID;
    private String subOrgID;
    private String envId;
    private String userId;
    private String publish_rest_json;
    private String publish_type;
    private String version;

*/

    public String getID() {
        return iD;
    }

    public void setID( String iD) {
        this.iD = iD;
    }
    public String getOrgID() {
        return orgID;
    }

    public void setOrgID( String orgID) {
        this.orgID = orgID;
    }
    public String getSubOrgID() {
        return subOrgID;
    }

    public void setSubOrgID( String subOrgID) {
        this.subOrgID = subOrgID;
    }
    public String getEnvId() {
        return envId;
    }

    public void setEnvId( String envId) {
        this.envId = envId;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId( String userId) {
        this.userId = userId;
    }
    public String getPublish_rest_json() {
        return publish_rest_json;
    }

    public void setPublish_rest_json( String publish_rest_json) {
        this.publish_rest_json = publish_rest_json;
    }
    public String getPublish_type() {
        return publish_type;
    }

    public void setPublish_type( String publish_type) {
        this.publish_type = publish_type;
    }
    public String getVersion() {
        return version;
    }

    public void setVersion( String version) {
        this.version = version;
    }
}