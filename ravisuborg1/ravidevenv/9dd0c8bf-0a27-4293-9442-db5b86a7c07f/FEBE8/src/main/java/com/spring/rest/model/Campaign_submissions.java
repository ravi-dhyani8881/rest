package com.spring.rest.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data // Generates getters, setters, toString, equals, hashCode
@NoArgsConstructor // Generates a no-argument constructor (required by Jackson for deserialization)
@AllArgsConstructor // Generates a constructor with all fields
@JsonInclude(JsonInclude.Include.NON_NULL) 
public class Campaign_submissions implements Serializable {


    @JsonProperty("ID")
    private String iD;

    private String campaign_key;

    private String campaign_variant;

    private String source_type;

    private String source_id;

    private String platform;

    private String channel;

    private String locale;

    private String subject_user_id;

    private String subject_order_id;

    private String subject_product_id;

    private String submitted_at;

    private String payload;

    private String createdAt;

    private String updatedAt;


	public Campaign_submissions () {
	super();
    }

/*

    @Id
    private String iD;
    private String campaign_key;
    private String campaign_variant;
    private String source_type;
    private String source_id;
    private String platform;
    private String channel;
    private String locale;
    private String subject_user_id;
    private String subject_order_id;
    private String subject_product_id;
    private String submitted_at;
    private String payload;
    private String createdAt;
    private String updatedAt;

*/

    @JsonProperty("ID")
    public String getID() {
        return iD;
    }

    @JsonProperty("ID")
    public void setID( String iD) {
        this.iD = iD;
    }

    public String getCampaign_key() {
        return campaign_key;
    }

    public void setCampaign_key( String campaign_key) {
        this.campaign_key = campaign_key;
    }

    public String getCampaign_variant() {
        return campaign_variant;
    }

    public void setCampaign_variant( String campaign_variant) {
        this.campaign_variant = campaign_variant;
    }

    public String getSource_type() {
        return source_type;
    }

    public void setSource_type( String source_type) {
        this.source_type = source_type;
    }

    public String getSource_id() {
        return source_id;
    }

    public void setSource_id( String source_id) {
        this.source_id = source_id;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform( String platform) {
        this.platform = platform;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel( String channel) {
        this.channel = channel;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale( String locale) {
        this.locale = locale;
    }

    public String getSubject_user_id() {
        return subject_user_id;
    }

    public void setSubject_user_id( String subject_user_id) {
        this.subject_user_id = subject_user_id;
    }

    public String getSubject_order_id() {
        return subject_order_id;
    }

    public void setSubject_order_id( String subject_order_id) {
        this.subject_order_id = subject_order_id;
    }

    public String getSubject_product_id() {
        return subject_product_id;
    }

    public void setSubject_product_id( String subject_product_id) {
        this.subject_product_id = subject_product_id;
    }

    public String getSubmitted_at() {
        return submitted_at;
    }

    public void setSubmitted_at( String submitted_at) {
        this.submitted_at = submitted_at;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload( String payload) {
        this.payload = payload;
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