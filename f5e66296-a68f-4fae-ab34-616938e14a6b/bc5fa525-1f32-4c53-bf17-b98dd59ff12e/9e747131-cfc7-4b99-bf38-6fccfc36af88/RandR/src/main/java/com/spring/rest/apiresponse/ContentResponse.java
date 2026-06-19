package com.spring.rest.apiresponse;


import com.spring.rest.model.Content;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response wrapper for Configuration data")
public class ContentResponse {

    @Schema(description = "Wrapped API response for configurations")
    private ApiResponseLocal<Content> response;

    public ContentResponse(ApiResponseLocal<Content> response) {
        this.response = response;
    }

    public ApiResponseLocal<Content> getResponse() {
        return response;
    }

    public void setResponse(ApiResponseLocal<Content> response) {
        this.response = response;
    }
}
