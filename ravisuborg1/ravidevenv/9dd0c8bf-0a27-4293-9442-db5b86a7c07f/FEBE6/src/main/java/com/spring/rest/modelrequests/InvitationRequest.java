package com.spring.rest.modelrequests;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InvitationRequest {

    private String iD;
    private String email;
    private String orgId;
    private String role;
    private String token;
    private String createdAt;
    private String updatedAt;

}