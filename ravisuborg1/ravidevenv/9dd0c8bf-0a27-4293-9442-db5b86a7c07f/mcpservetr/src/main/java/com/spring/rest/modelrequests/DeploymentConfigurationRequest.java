package com.spring.rest.modelrequests;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeploymentConfigurationRequest {


    // --- Fields ---

    private String configurationId;


    private String replicaCount;


    // --- Getters & Setters ---


    public String getConfigurationId() {
        return configurationId;
    }

    public void setConfigurationId(String configurationId) {
        this.configurationId = configurationId;
    }



    public String getReplicaCount() {
        return replicaCount;
    }

    public void setReplicaCount(String replicaCount) {
        this.replicaCount = replicaCount;
    }


}
