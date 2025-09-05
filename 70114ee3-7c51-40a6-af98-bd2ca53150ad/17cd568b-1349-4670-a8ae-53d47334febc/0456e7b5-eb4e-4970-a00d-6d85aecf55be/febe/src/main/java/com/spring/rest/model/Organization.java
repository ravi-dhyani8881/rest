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
public class Organization implements Serializable {


    private int iD;
    private String orgName;
    private String orgDesc;


/*

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iD;
    private String orgName;
    private String orgDesc;

*/

    public int getID() {
        return iD;
    }

    public void setID( int iD) {
        this.iD = iD;
    }
    public String getOrgName() {
        return orgName;
    }

    public void setOrgName( String orgName) {
        this.orgName = orgName;
    }
    public String getOrgDesc() {
        return orgDesc;
    }

    public void setOrgDesc( String orgDesc) {
        this.orgDesc = orgDesc;
    }
}