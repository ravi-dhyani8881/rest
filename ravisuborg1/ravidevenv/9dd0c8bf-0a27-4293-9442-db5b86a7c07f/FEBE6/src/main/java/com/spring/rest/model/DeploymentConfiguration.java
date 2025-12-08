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
public class DeploymentConfiguration implements Serializable {


    @JsonProperty("ID")
    private String iD;

    private String configurationId;

    private String replicaCount;

    private String createdAt;

    private String updatedAt;



/*

    @Id
    private String iD;
    private String configurationId;
    private String replicaCount;
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

    public String getConfigurationId() {
        return configurationId;
    }

    public void setConfigurationId( String configurationId) {
        this.configurationId = configurationId;
    }

    public String getReplicaCount() {
        return replicaCount;
    }

    public void setReplicaCount( String replicaCount) {
        this.replicaCount = replicaCount;
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
