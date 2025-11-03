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
public class GraphDeployments implements Serializable {


    private String iD;
    private String graphId;
    private String graphVersionID;
    private String deploymentConfigurationID;
    private Date createdAt;
    private String updatedAt;
    private String deployedBy;
    private String status;


/*

    @Id
    private String iD;
    private String graphId;
    @NotNull
    private String graphVersionID;
    @NotNull
    private String deploymentConfigurationID;
    @NotNull
    private Date createdAt;
    private String updatedAt;
    private String deployedBy;
    private String status;

*/

    public String getID() {
        return iD;
    }

    public void setID( String iD) {
        this.iD = iD;
    }
    public String getGraphId() {
        return graphId;
    }

    public void setGraphId( String graphId) {
        this.graphId = graphId;
    }
    public String getGraphVersionID() {
        return graphVersionID;
    }

    public void setGraphVersionID( String graphVersionID) {
        this.graphVersionID = graphVersionID;
    }
    public String getDeploymentConfigurationID() {
        return deploymentConfigurationID;
    }

    public void setDeploymentConfigurationID( String deploymentConfigurationID) {
        this.deploymentConfigurationID = deploymentConfigurationID;
    }
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt( Date createdAt) {
        this.createdAt = createdAt;
    }
    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt( String updatedAt) {
        this.updatedAt = updatedAt;
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
}