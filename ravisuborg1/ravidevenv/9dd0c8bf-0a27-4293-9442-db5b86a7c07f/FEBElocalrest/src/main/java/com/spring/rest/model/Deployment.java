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
public class Deployment implements Serializable {


    @JsonProperty("ID")
    private String iD;

    private String projectId;

    private String versionId;

    private String deploymentConfigurationId;

    private String deployedBy;

    private String status;

    private String createdAt;

    private String updatedAt;


/*

    @Id
    private String iD;
    private String projectId;
    private String versionId;
    private String deploymentConfigurationId;
    private String deployedBy;
    private String status;
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

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId( String projectId) {
        this.projectId = projectId;
    }

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId( String versionId) {
        this.versionId = versionId;
    }

    public String getDeploymentConfigurationId() {
        return deploymentConfigurationId;
    }

    public void setDeploymentConfigurationId( String deploymentConfigurationId) {
        this.deploymentConfigurationId = deploymentConfigurationId;
    }

    public String getDeployedBy() {
        return deployedBy;
    }

    public void setDeployedBy( String deployedBy) {
        this.deployedBy = deployedBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus( String status) {
        this.status = status;
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