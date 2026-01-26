package com.spring.rest.apiresponse;


import com.spring.rest.model.Products;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response wrapper for Configuration data")
public class ProductsResponse {

    @Schema(description = "Wrapped API response for configurations")
    private ApiResponseLocal<Products> response;

    public ProductsResponse(ApiResponseLocal<Products> response) {
        this.response = response;
    }

    public ApiResponseLocal<Products> getResponse() {
        return response;
    }

    public void setResponse(ApiResponseLocal<Products> response) {
        this.response = response;
    }
}
