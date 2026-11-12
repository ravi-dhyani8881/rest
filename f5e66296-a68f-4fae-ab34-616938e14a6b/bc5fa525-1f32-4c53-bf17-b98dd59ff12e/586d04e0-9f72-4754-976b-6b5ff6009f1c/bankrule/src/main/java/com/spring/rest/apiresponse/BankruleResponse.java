package com.spring.rest.apiresponse;


import com.spring.rest.model.Bankrule;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response wrapper for Configuration data")
public class BankruleResponse {

    @Schema(description = "Wrapped API response for configurations")
    private ApiResponseLocal<Bankrule> response;

    public BankruleResponse(ApiResponseLocal<Bankrule> response) {
        this.response = response;
    }

    public ApiResponseLocal<Bankrule> getResponse() {
        return response;
    }

    public void setResponse(ApiResponseLocal<Bankrule> response) {
        this.response = response;
    }
}
