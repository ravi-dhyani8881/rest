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


    private String iD;
    private String configurationID;
    private String replicaCount;
    private Date createdAt;
    private Date updatedAt;


/*

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String iD;
    private String configurationID;
    private String replicaCount;
    private Date createdAt;
    private Date updatedAt;

*/

    public String getID() {
        return iD;
    }

    public void setID( String iD) {
        this.iD = iD;
    }
    public String getConfigurationID() {
        return configurationID;
    }

    public void setConfigurationID( String configurationID) {
        this.configurationID = configurationID;
    }
    public String getReplicaCount() {
        return replicaCount;
    }

    public void setReplicaCount( String replicaCount) {
        this.replicaCount = replicaCount;
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