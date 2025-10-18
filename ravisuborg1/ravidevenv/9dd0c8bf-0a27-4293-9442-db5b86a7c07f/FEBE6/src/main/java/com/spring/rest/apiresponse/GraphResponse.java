package com.spring.rest.apiresponse;


import com.spring.rest.model.Graph;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response wrapper for Configuration data")
public class GraphResponse {

    @Schema(description = "Wrapped API response for configurations")
    private ApiResponseLocal<Graph> response;

    public GraphResponse(ApiResponseLocal<Graph> response) {
        this.response = response;
    }

    public ApiResponseLocal<Graph> getResponse() {
        return response;
    }

    public void setResponse(ApiResponseLocal<Graph> response) {
        this.response = response;
    }
}
