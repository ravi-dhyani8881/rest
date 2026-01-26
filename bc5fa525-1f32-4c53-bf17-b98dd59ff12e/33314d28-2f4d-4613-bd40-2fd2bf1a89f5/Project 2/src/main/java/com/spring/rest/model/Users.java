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
public class Users implements Serializable {


    @JsonProperty("ID")
    private String id;

    private String name;

    private String password_hash;

    private String email;


/*

    @Id
    private String id;
    private String name;
    @Secure
    private String password_hash;
    private String email;

*/

    @JsonProperty("ID")
    public String getId() {
        return id;
    }

    @JsonProperty("ID")
    public void setId( String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name) {
        this.name = name;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash( String password_hash) {
        this.password_hash = password_hash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email) {
        this.email = email;
    }
}