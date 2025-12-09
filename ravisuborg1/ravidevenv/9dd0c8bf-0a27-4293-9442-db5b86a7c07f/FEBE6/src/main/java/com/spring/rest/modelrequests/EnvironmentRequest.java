package com.spring.rest.modelrequests;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnvironmentRequest {

    private String iD;
    private String orgId;
    private String subOrgId;
    private String name;
    private String description;
    private String createdAt;
    private String updatedAt;

}