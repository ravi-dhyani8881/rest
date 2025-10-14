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
public class ApiKey implements Serializable {


    private String iD;
    private String userId;
    private String apiKey;
    private String status;
    private String addedDate;
    private String lastUpdate;
    private String graphId;


/*

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String iD;
    private String userId;
    private String apiKey;
    private String status;
    private String addedDate;
    private String lastUpdate;
    private String graphId;

*/

    public String getID() {
        return iD;
    }

    public void setID( String iD) {
        this.iD = iD;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId( String userId) {
        this.userId = userId;
    }
    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey( String apiKey) {
        this.apiKey = apiKey;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus( String status) {
        this.status = status;
    }
    public String getAddedDate() {
        return addedDate;
    }

    public void setAddedDate( String addedDate) {
        this.addedDate = addedDate;
    }
    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate( String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    public String getGraphId() {
        return graphId;
    }

    public void setGraphId( String graphId) {
        this.graphId = graphId;
    }
}