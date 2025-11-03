package com.spring.rest.apiresponse;


import com.spring.rest.model.PublishGraph;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response wrapper for Configuration data")
public class PublishGraphResponse {

    @Schema(description = "Wrapped API response for configurations")
    private ApiResponseLocal<PublishGraph> response;

    public PublishGraphResponse(ApiResponseLocal<PublishGraph> response) {
        this.response = response;
    }

    public ApiResponseLocal<PublishGraph> getResponse() {
        return response;
    }

    public void setResponse(ApiResponseLocal<PublishGraph> response) {
        this.response = response;
    }
}
