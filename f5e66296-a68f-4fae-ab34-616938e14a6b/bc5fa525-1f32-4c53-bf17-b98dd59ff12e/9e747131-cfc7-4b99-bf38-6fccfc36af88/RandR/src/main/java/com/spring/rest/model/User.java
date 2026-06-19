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

    private String apiKey;

    private String emailAddress;

    private String email;

    private String password;

    private String userActivationKey;

    private String company;

    private String firstName;

    private String lastName;

    private String middleName;

    private String role;

    private String address;

    private Date createdDate;

    private Date updatedDate;


/*

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String iD;
    private String apiKey;
    private String emailAddress;
    private String email;
    private String password;
    private String userActivationKey;
    private String company;
    private String firstName;
    private String lastName;
    private String middleName;
    private String role;
    private String address;
    private Date createdDate;
    private Date updatedDate;

*/

    @JsonProperty("ID")
    public String getID() {
        return iD;
    }

    @JsonProperty("ID")
    public void setID( String iD) {
        this.iD = iD;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey( String apiKey) {
        this.apiKey = apiKey;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress( String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password) {
        this.password = password;
    }

    public String getUserActivationKey() {
        return userActivationKey;
    }

    public void setUserActivationKey( String userActivationKey) {
        this.userActivationKey = userActivationKey;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany( String company) {
        this.company = company;
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName( String middleName) {
        this.middleName = middleName;
    }

    public String getRole() {
        return role;
    }

    public void setRole( String role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress( String address) {
        this.address = address;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate( Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate( Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}