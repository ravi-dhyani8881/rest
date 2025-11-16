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
public class Invitation implements Serializable {


    private String id;
    private String email;
    private String orgId;
    private String role;
    private String token;
    private String createdAt;
    private String updatedAt;


/*

    @Id
    private String id;
    private String email;
    private String orgId;
    private String role;
    private String token;
    private String createdAt;
    private String updatedAt;

*/

    public String getId() {
        return id;
    }

    public void setId( String id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail( String email) {
        this.email = email;
    }
    public String getOrgId() {
        return orgId;
    }

    public void setOrgId( String orgId) {
        this.orgId = orgId;
    }
    public String getRole() {
        return role;
    }

    public void setRole( String role) {
        this.role = role;
    }
    public String getToken() {
        return token;
    }

    public void setToken( String token) {
        this.token = token;
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