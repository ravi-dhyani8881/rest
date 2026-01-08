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
public class User implements Serializable {


    @JsonProperty("ID")
    private String iD;

    private String email;

    private String firstName;

    private String middleName;

    private String lastName;

    private String address;

    private String company;

    private String role;

    private String password;

    private String passwordSalt;

    private String createdAt;

    private String updatedAt;

    private String userActivationKey;

    private String userStatus;


/*

    @Id
    private String iD;
    private String email;
    private String firstName;
    private String middleName;
    private String lastName;
    private String address;
    private String company;
    private String role;
    private String password;
    private String passwordSalt;
    private String createdAt;
    private String updatedAt;
    private String userActivationKey;
    private String userStatus;

*/

    @JsonProperty("ID")
    public String getID() {
        return iD;
    }

    @JsonProperty("ID")
    public void setID( String iD) {
        this.iD = iD;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName( String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName( String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName( String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress( String address) {
        this.address = address;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany( String company) {
        this.company = company;
    }

    public String getRole() {
        return role;
    }

    public void setRole( String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password) {
        this.password = password;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt( String passwordSalt) {
        this.passwordSalt = passwordSalt;
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

    public String getUserActivationKey() {
        return userActivationKey;
    }

    public void setUserActivationKey( String userActivationKey) {
        this.userActivationKey = userActivationKey;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus( String userStatus) {
        this.userStatus = userStatus;
    }
}