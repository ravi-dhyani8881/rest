package com.spring.rest.apiresponse;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "UserSignUpExample", description = "Example signup response")
public class UserSignUpExample {

    @Schema(example = "User registered successfully. Please activate using email verification code.")
    public String responseMessage;

    @Schema(example = "201")
    public int statusCode;

    @Schema(example = "4e23b1f4-02d9-4d8a-a642-517f06d83abc")
    public String ID;

    @Schema(example = "7f1a2b33-78c2-4d4e-98d4-9430e4c2d9ab")
    public String activationCode;

    @Schema(example = "created")
    public String responseType;

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getActivationCode() {
		return activationCode;
	}

	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}

	public String getResponseType() {
		return responseType;
	}

	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}   
}