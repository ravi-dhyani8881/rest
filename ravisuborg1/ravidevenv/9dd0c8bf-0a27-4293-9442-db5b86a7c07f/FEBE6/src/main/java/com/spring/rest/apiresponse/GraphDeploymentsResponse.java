package com.spring.rest.apiresponse;


import com.spring.rest.model.GraphDeployments;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response wrapper for Configuration data")
public class GraphDeploymentsResponse {

    @Schema(description = "Wrapped API response for configurations")
    private ApiResponseLocal<GraphDeployments> response;

    public GraphDeploymentsResponse(ApiResponseLocal<GraphDeployments> response) {
        this.response = response;
    }

    public ApiResponseLocal<GraphDeployments> getResponse() {
        return response;
    }

    public void setResponse(ApiResponseLocal<GraphDeployments> response) {
        this.response = response;
    }
}
