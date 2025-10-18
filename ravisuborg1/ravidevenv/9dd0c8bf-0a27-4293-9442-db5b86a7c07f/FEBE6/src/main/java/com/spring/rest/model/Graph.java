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
public class Graph implements Serializable {


    private String iD;
    private String graphName;
    private String orgID;
    private String subOrgID;
    private String envId;
    private Date createdAt;
    private Date updatedAt;


/*

    private String iD;
    private String graphName;
    private String orgID;
    private String subOrgID;
    private String envId;
    private Date createdAt;
    private Date updatedAt;

*/

    public String getID() {
        return iD;
    }

    public void setID( String iD) {
        this.iD = iD;
    }
    public String getGraphName() {
        return graphName;
    }

    public void setGraphName( String graphName) {
        this.graphName = graphName;
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
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt( Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt( Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}