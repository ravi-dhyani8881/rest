package com.spring.rest.apiresponse;


import com.spring.rest.model.UserSetting;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response wrapper for Configuration data")
public class UserSettingResponse {

    @Schema(description = "Wrapped API response for configurations")
    private ApiResponseLocal<UserSetting> response;

    public UserSettingResponse(ApiResponseLocal<UserSetting> response) {
        this.response = response;
    }

    public ApiResponseLocal<UserSetting> getResponse() {
        return response;
    }

    public void setResponse(ApiResponseLocal<UserSetting> response) {
        this.response = response;
    }
}
