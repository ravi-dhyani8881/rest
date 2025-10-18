package com.spring.rest.apiresponse;


import com.spring.rest.model.GraphVersions;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response wrapper for Configuration data")
public class GraphVersionsResponse {

    @Schema(description = "Wrapped API response for configurations")
    private ApiResponseLocal<GraphVersions> response;

    public GraphVersionsResponse(ApiResponseLocal<GraphVersions> response) {
        this.response = response;
    }

    public ApiResponseLocal<GraphVersions> getResponse() {
        return response;
    }

    public void setResponse(ApiResponseLocal<GraphVersions> response) {
        this.response = response;
    }
}
