package com.spring.rest.apiresponse;


import com.spring.rest.model.ChatHistory;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response wrapper for Configuration data")
public class ChatHistoryResponse {

    @Schema(description = "Wrapped API response for configurations")
    private ApiResponseLocal<ChatHistory> response;

    public ChatHistoryResponse(ApiResponseLocal<ChatHistory> response) {
        this.response = response;
    }

    public ApiResponseLocal<ChatHistory> getResponse() {
        return response;
    }

    public void setResponse(ApiResponseLocal<ChatHistory> response) {
        this.response = response;
    }
}
