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
public class User implements Serializable {


    private int iD;
    private String name;
    private String address;
    private String password;
    private Date dateOfBirth;
    private String orgID;
    private Date createdAt;
    private Date updatedAt;


/*

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iD;
    private String name;
    private String address;
    private String password;
    private Date dateOfBirth;
    private String orgID;
    private Date createdAt;
    private Date updatedAt;

*/

    public int getID() {
        return iD;
    }

    public void setID( int iD) {
        this.iD = iD;
    }
    public String getName() {
        return name;
    }

    public void setName( String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress( String address) {
        this.address = address;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword( String password) {
        this.password = password;
    }
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth( Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getOrgID() {
        return orgID;
    }

    public void setOrgID( String orgID) {
        this.orgID = orgID;
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