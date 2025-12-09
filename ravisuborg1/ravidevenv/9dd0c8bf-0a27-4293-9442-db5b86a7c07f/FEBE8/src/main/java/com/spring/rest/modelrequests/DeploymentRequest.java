package com.spring.rest.modelrequests;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeploymentRequest {


    // --- Fields ---

    private String projectId;


    private String versionId;


    private String deploymentConfigurationId;


    private String deployedBy;


    private String status;


    // --- Getters & Setters ---


    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }



    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }



    public String getDeploymentConfigurationId() {
        return deploymentConfigurationId;
    }

    public void setDeploymentConfigurationId(String deploymentConfigurationId) {
        this.deploymentConfigurationId = deploymentConfigurationId;
    }



    public String getDeployedBy() {
        return deployedBy;
    }

    public void setDeployedBy(String deployedBy) {
        this.deployedBy = deployedBy;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
