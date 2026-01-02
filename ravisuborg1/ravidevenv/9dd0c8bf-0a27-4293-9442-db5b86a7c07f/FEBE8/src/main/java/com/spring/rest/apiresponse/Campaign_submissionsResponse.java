package com.spring.rest.apiresponse;


import com.spring.rest.model.Campaign_submissions;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response wrapper for Configuration data")
public class Campaign_submissionsResponse {

    @Schema(description = "Wrapped API response for configurations")
    private ApiResponseLocal<Campaign_submissions> response;

    public Campaign_submissionsResponse(ApiResponseLocal<Campaign_submissions> response) {
        this.response = response;
    }

    public ApiResponseLocal<Campaign_submissions> getResponse() {
        return response;
    }

    public void setResponse(ApiResponseLocal<Campaign_submissions> response) {
        this.response = response;
    }
}
