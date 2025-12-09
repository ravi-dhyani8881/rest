package com.spring.rest.modelrequests;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PublishLogRequestRequest {


    private int endpointType;

    private String orgId;

    private String subOrgId;

    private String environmentId;

    private String json;

    private String version;

    private String userId;

}