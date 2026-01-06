package com.spring.rest.modelrequests;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PublishLogRequest {


    // --- Fields ---

    private int endpointType;


    private String orgId;


    private String subOrgId;


    private String environmentId;


    private String json;


    private String version;


    private String userId;


    // --- Getters & Setters ---


    public int getEndpointType() {
        return endpointType;
    }

    public void setEndpointType(int endpointType) {
        this.endpointType = endpointType;
    }



    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }



    public String getSubOrgId() {
        return subOrgId;
    }

    public void setSubOrgId(String subOrgId) {
        this.subOrgId = subOrgId;
    }



    public String getEnvironmentId() {
        return environmentId;
    }

    public void setEnvironmentId(String environmentId) {
        this.environmentId = environmentId;
    }



    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }



    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }



    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


}
