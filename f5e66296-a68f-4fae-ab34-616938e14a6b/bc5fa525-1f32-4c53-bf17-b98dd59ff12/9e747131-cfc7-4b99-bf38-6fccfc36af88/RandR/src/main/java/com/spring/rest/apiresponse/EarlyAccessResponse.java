package com.spring.rest.apiresponse;


import com.spring.rest.model.EarlyAccess;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response wrapper for Configuration data")
public class EarlyAccessResponse {

    @Schema(description = "Wrapped API response for configurations")
    private ApiResponseLocal<EarlyAccess> response;

    public EarlyAccessResponse(ApiResponseLocal<EarlyAccess> response) {
        this.response = response;
    }

    public ApiResponseLocal<EarlyAccess> getResponse() {
        return response;
    }

    public void setResponse(ApiResponseLocal<EarlyAccess> response) {
        this.response = response;
    }
}
