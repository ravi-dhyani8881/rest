package com.spring.rest.apiresponse;


import com.spring.rest.model.Helpfull;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response wrapper for Configuration data")
public class HelpfullResponse {

    @Schema(description = "Wrapped API response for configurations")
    private ApiResponseLocal<Helpfull> response;

    public HelpfullResponse(ApiResponseLocal<Helpfull> response) {
        this.response = response;
    }

    public ApiResponseLocal<Helpfull> getResponse() {
        return response;
    }

    public void setResponse(ApiResponseLocal<Helpfull> response) {
        this.response = response;
    }
}
