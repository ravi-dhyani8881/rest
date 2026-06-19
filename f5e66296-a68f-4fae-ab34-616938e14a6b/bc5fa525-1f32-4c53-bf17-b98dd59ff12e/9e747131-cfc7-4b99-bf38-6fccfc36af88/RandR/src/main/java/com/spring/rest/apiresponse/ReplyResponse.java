package com.spring.rest.apiresponse;


import com.spring.rest.model.Reply;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response wrapper for Configuration data")
public class ReplyResponse {

    @Schema(description = "Wrapped API response for configurations")
    private ApiResponseLocal<Reply> response;

    public ReplyResponse(ApiResponseLocal<Reply> response) {
        this.response = response;
    }

    public ApiResponseLocal<Reply> getResponse() {
        return response;
    }

    public void setResponse(ApiResponseLocal<Reply> response) {
        this.response = response;
    }
}
