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
public class EarlyAccess implements Serializable {


    private String iD;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private String company;
    private String companyUrl;
    private String description;
    private String createdAt;
    private String updatedAt;


/*

    @Id
    private String iD;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private String company;
    private String companyUrl;
    private String description;
    private String createdAt;
    private String updatedAt;

*/

    public String getID() {
        return iD;
    }

    public void setID( String iD) {
        this.iD = iD;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName( String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName( String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail( String email) {
        this.email = email;
    }
    public String getRole() {
        return role;
    }

    public void setRole( String role) {
        this.role = role;
    }
    public String getCompany() {
        return company;
    }

    public void setCompany( String company) {
        this.company = company;
    }
    public String getCompanyUrl() {
        return companyUrl;
    }

    public void setCompanyUrl( String companyUrl) {
        this.companyUrl = companyUrl;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription( String description) {
        this.description = description;
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