package com.spring.rest.apiresponse;


import com.spring.rest.model.Campaigns;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response wrapper for Configuration data")
public class CampaignsResponse {

    @Schema(description = "Wrapped API response for configurations")
    private ApiResponseLocal<Campaigns> response;

    public CampaignsResponse(ApiResponseLocal<Campaigns> response) {
        this.response = response;
    }

    public ApiResponseLocal<Campaigns> getResponse() {
        return response;
    }

    public void setResponse(ApiResponseLocal<Campaigns> response) {
        this.response = response;
    }
}
