package com.spring.rest.apiresponse;


import com.spring.rest.model.Project;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response wrapper for Configuration data")
public class ProjectResponse {

    @Schema(description = "Wrapped API response for configurations")
    private ApiResponseLocal<Project> response;

    public ProjectResponse(ApiResponseLocal<Project> response) {
        this.response = response;
    }

    public ApiResponseLocal<Project> getResponse() {
        return response;
    }

    public void setResponse(ApiResponseLocal<Project> response) {
        this.response = response;
    }
}
