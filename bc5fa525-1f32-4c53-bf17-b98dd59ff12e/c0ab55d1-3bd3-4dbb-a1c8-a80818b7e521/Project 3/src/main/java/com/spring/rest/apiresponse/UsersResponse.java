package com.spring.rest.apiresponse;


import com.spring.rest.model.Users;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response wrapper for Configuration data")
public class UsersResponse {

    @Schema(description = "Wrapped API response for configurations")
    private ApiResponseLocal<Users> response;

    public UsersResponse(ApiResponseLocal<Users> response) {
        this.response = response;
    }

    public ApiResponseLocal<Users> getResponse() {
        return response;
    }

    public void setResponse(ApiResponseLocal<Users> response) {
        this.response = response;
    }
}
