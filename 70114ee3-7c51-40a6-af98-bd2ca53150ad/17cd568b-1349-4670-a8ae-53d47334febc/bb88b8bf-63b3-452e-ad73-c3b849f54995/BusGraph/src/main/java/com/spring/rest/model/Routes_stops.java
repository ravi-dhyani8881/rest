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
public class Routes_stops implements Serializable {


    private String routeID;
    private String stopID;
    private Date createdAt;
    private Date updatedAt;


/*

    private String routeID;
    private String stopID;
    private Date createdAt;
    private Date updatedAt;

*/

    public String getRouteID() {
        return routeID;
    }

    public void setRouteID( String routeID) {
        this.routeID = routeID;
    }
    public String getStopID() {
        return stopID;
    }

    public void setStopID( String stopID) {
        this.stopID = stopID;
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