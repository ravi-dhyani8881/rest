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
public class UserOrgMapping implements Serializable {


    private int id;


/*

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

*/

    public int getId() {
        return id;
    }

    public void setId( int id) {
        this.id = id;
    }
}