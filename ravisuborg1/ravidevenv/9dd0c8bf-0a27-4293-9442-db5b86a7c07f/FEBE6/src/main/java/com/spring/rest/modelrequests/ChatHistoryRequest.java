package com.spring.rest.modelrequests;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChatHistoryRequest {


    private String userId;

    private String messages;


    @JsonProperty("ID")
    public String getID() {
        return iD;
    }

    @JsonProperty("ID")
    public void setID( String iD) {
        this.iD = iD;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId( String userId) {
        this.userId = userId;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages( String messages) {
        this.messages = messages;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt( String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt( String updatedAt) {
        this.updatedAt = updatedAt;
    }

}