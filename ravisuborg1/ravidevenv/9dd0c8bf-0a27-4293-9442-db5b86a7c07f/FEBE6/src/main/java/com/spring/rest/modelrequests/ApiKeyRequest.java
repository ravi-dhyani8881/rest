package com.spring.rest.modelrequests;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiKeyRequest {

    private String iD;
    private String userId;
    private String apiKey;
    private String status;
    private String projectId;
    private String createdAt;
    private String updatedAt;

}