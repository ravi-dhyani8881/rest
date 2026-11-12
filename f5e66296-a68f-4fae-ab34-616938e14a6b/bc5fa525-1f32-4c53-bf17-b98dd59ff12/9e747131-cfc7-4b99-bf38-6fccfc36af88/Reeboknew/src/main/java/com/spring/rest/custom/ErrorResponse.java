package com.spring.rest.custom;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Standard structure for error responses")
public class ErrorResponse {

    @Schema(description = "Error code representing the type of failure", example = "internal_error")
    private String code;

    @Schema(description = "User-friendly error message", example = "Internal server error occurred")
    private String message;

    @Schema(description = "Detailed developer message", example = "NullPointerException in EnvironmentService.java:42")
    private String details;

    public ErrorResponse() {}

    public ErrorResponse(String code, String message, String details) {
        this.code = code;
        this.message = message;
        this.details = details;
    }

    // ✅ Getters and setters
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }

    // 🔧 Static helper for quick creation
    public static ErrorResponse of(String code, String message) {
        return new ErrorResponse(code, message, null);
    }

    public static ErrorResponse of(String code, String message, String details) {
        return new ErrorResponse(code, message, details);
    }
}