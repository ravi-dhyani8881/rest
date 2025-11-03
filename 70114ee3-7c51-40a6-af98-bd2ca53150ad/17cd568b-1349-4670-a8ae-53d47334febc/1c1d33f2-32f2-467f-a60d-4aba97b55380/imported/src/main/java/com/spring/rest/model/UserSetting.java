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
public class UserSetting implements Serializable {


    private String iD;
    private String orgID;
    private String subOrgId;
    private String envId;
    private String userId;


/*

    @Id
    private String iD;
    private String orgID;
    private String subOrgId;
    private String envId;
    private String userId;

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
    public String getSubOrgId() {
        return subOrgId;
    }

    public void setSubOrgId( String subOrgId) {
        this.subOrgId = subOrgId;
    }
    public String getEnvId() {
        return envId;
    }

    public void setEnvId( String envId) {
        this.envId = envId;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId( String userId) {
        this.userId = userId;
    }
}