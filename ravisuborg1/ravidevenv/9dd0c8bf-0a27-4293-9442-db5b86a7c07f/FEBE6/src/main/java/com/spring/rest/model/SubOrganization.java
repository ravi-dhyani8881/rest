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
public class SubOrganization implements Serializable {


    private String iD;
    private String subOrgName;
    private String orgID;
    private String subOrgDesc;


/*

    private String iD;
    private String subOrgName;
    private String orgID;
    private String subOrgDesc;

*/

    public String getID() {
        return iD;
    }

    public void setID( String iD) {
        this.iD = iD;
    }
    public String getSubOrgName() {
        return subOrgName;
    }

    public void setSubOrgName( String subOrgName) {
        this.subOrgName = subOrgName;
    }
    public String getOrgID() {
        return orgID;
    }

    public void setOrgID( String orgID) {
        this.orgID = orgID;
    }
    public String getSubOrgDesc() {
        return subOrgDesc;
    }

    public void setSubOrgDesc( String subOrgDesc) {
        this.subOrgDesc = subOrgDesc;
    }
}