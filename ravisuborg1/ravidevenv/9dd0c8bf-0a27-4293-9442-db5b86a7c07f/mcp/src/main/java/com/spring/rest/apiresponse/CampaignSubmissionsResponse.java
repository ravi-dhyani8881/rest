package com.spring.rest.apiresponse;


import com.spring.rest.model.CampaignSubmissions;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response wrapper for Configuration data")
public class CampaignSubmissionsResponse {

    @Schema(description = "Wrapped API response for configurations")
    private ApiResponseLocal<CampaignSubmissions> response;

    public CampaignSubmissionsResponse(ApiResponseLocal<CampaignSubmissions> response) {
        this.response = response;
    }

    public ApiResponseLocal<CampaignSubmissions> getResponse() {
        return response;
    }

    public void setResponse(ApiResponseLocal<CampaignSubmissions> response) {
        this.response = response;
    }
}
