package com.spring.rest.apiresponse;


import com.spring.rest.model.User;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response wrapper for Configuration data")
public class UserResponse {

    @Schema(description = "Wrapped API response for configurations")
    private ApiResponseLocal<User> response;

    public UserResponse(ApiResponseLocal<User> response) {
        this.response = response;
    }

    public ApiResponseLocal<User> getResponse() {
        return response;
    }

    public void setResponse(ApiResponseLocal<User> response) {
        this.response = response;
    }
}
