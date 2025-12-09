package com.spring.rest.modelrequests;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConfigurationRequest {


    // --- Fields ---

    private String replicaSize;


    // --- Getters & Setters ---


    public String getReplicaSize() {
        return replicaSize;
    }

    public void setReplicaSize(String replicaSize) {
        this.replicaSize = replicaSize;
    }


}
