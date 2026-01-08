package com.spring.rest.modelrequests;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Campaign_submissionsRequest {


    // --- Fields ---

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


    // --- Getters & Setters ---


    public String getCampaign_key() {
        return campaign_key;
    }

    public void setCampaign_key(String campaign_key) {
        this.campaign_key = campaign_key;
    }



    public String getCampaign_variant() {
        return campaign_variant;
    }

    public void setCampaign_variant(String campaign_variant) {
        this.campaign_variant = campaign_variant;
    }



    public String getSource_type() {
        return source_type;
    }

    public void setSource_type(String source_type) {
        this.source_type = source_type;
    }



    public String getSource_id() {
        return source_id;
    }

    public void setSource_id(String source_id) {
        this.source_id = source_id;
    }



    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }



    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }



    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }



    public String getSubject_user_id() {
        return subject_user_id;
    }

    public void setSubject_user_id(String subject_user_id) {
        this.subject_user_id = subject_user_id;
    }



    public String getSubject_order_id() {
        return subject_order_id;
    }

    public void setSubject_order_id(String subject_order_id) {
        this.subject_order_id = subject_order_id;
    }



    public String getSubject_product_id() {
        return subject_product_id;
    }

    public void setSubject_product_id(String subject_product_id) {
        this.subject_product_id = subject_product_id;
    }



    public String getSubmitted_at() {
        return submitted_at;
    }

    public void setSubmitted_at(String submitted_at) {
        this.submitted_at = submitted_at;
    }



    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }


}
