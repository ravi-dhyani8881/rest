package com.spring.rest.apiresponse;


import com.spring.rest.model.Invitation;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response wrapper for Configuration data")
public class InvitationResponse {

    @Schema(description = "Wrapped API response for configurations")
    private ApiResponseLocal<Invitation> response;

    public InvitationResponse(ApiResponseLocal<Invitation> response) {
        this.response = response;
    }

    public ApiResponseLocal<Invitation> getResponse() {
        return response;
    }

    public void setResponse(ApiResponseLocal<Invitation> response) {
        this.response = response;
    }
}
