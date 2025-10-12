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
public class Bus_routes implements Serializable {


    private String routeID;
    private String name;
    private String createdAt;
    private String updatedAt;


/*

    @Id
    private String routeID;
    private String name;
    private String createdAt;
    private String updatedAt;

*/

    public String getRouteID() {
        return routeID;
    }

    public void setRouteID( String routeID) {
        this.routeID = routeID;
    }
    public String getName() {
        return name;
    }

    public void setName( String name) {
        this.name = name;
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