package com.spring.rest.apiresponse;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "UserAuthResponse")
public class UserAuthResponse {

    @Schema(description = "Response message", example = "User authenticated successfully.")
    private String message;

    @Schema(description = "HTTP response code", example = "200")
    private int status;

    @Schema(description = "User ID if authentication successful", example = "6f7c8b1d-1234")
    private String userId;

    @Schema(description = "Authentication result type", example = "AUTHENTICATED")
    private String responseType;

    public UserAuthResponse() {}

    public UserAuthResponse(String message, int status, String userId, String responseType) {
        this.message = message;
        this.status = status;
        this.userId = userId;
        this.responseType = responseType;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getResponseType() {
		return responseType;
	}

	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}
   
}