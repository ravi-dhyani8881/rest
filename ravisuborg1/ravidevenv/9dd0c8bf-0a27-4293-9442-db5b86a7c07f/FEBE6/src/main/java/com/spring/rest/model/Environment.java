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
public class Environment implements Serializable {


    private String iD;
    private String orgID;
    private String subOrgID;
    private String enviromentName;
    private String enviromentDesc;


/*

    private String iD;
    private String orgID;
    private String subOrgID;
    private String enviromentName;
    private String enviromentDesc;

*/

    public String getID() {
        return iD;
    }

    public void setID( String iD) {
        this.iD = iD;
    }
    public String getOrgID() {
        return orgID;
    }

    public void setOrgID( String orgID) {
        this.orgID = orgID;
    }
    public String getSubOrgID() {
        return subOrgID;
    }

    public void setSubOrgID( String subOrgID) {
        this.subOrgID = subOrgID;
    }
    public String getEnviromentName() {
        return enviromentName;
    }

    public void setEnviromentName( String enviromentName) {
        this.enviromentName = enviromentName;
    }
    public String getEnviromentDesc() {
        return enviromentDesc;
    }

    public void setEnviromentDesc( String enviromentDesc) {
        this.enviromentDesc = enviromentDesc;
    }
}