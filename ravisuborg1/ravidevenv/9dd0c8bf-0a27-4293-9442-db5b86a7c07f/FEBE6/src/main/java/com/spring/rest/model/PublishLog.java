package com.spring.rest.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data // Generates getters, setters, toString, equals, hashCode
@NoArgsConstructor // Generates a no-argument constructor (required by Jackson for deserialization)
@AllArgsConstructor // Generates a constructor with all fields
@JsonInclude(JsonInclude.Include.NON_NULL) 
public class PublishLog implements Serializable {


    @JsonProperty("ID")
    private String iD;

    private int endpointType;

    private String orgId;

    private String subOrgId;

    private String environmentId;

    private String json;

    private String version;

    private String userId;

    private String createdAt;

    private String updatedAt;


/*

    @Id
    private String iD;
    private int endpointType;
    private String orgId;
    private String subOrgId;
    private String environmentId;
    private String json;
    private String version;
    private String userId;
    private String createdAt;
    private String updatedAt;

*/

    @JsonProperty("ID")
    public String getID() {
        return iD;
    }

    @JsonProperty("ID")
    public void setID( String iD) {
        this.iD = iD;
    }

    public int getEndpointType() {
        return endpointType;
    }

    public void setEndpointType( int endpointType) {
        this.endpointType = endpointType;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId( String orgId) {
        this.orgId = orgId;
    }

    public String getSubOrgId() {
        return subOrgId;
    }

    public void setSubOrgId( String subOrgId) {
        this.subOrgId = subOrgId;
    }

    public String getEnvironmentId() {
        return environmentId;
    }

    public void setEnvironmentId( String environmentId) {
        this.environmentId = environmentId;
    }

    public String getJson() {
        return json;
    }

    public void setJson( String json) {
        this.json = json;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion( String version) {
        this.version = version;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId( String userId) {
        this.userId = userId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt( String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt( String updatedAt) {
        this.updatedAt = updatedAt;
    }
}