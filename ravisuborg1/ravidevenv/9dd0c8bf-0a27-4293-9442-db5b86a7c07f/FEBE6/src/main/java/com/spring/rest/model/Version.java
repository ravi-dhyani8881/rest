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
public class Version implements Serializable {


    @JsonProperty("ID")
    private String iD;

    private String projectId;

    private String name;

    private String description;

    private String schemaJson;

    private int status;

    private String notes;

    private String domain;

    private String graphQlUrl;

    private String restUrl;

    private String createdBy;

    private String createdAt;

    private String updatedAt;


/*

    @Id
    private String iD;
    private String projectId;
    private String name;
    private String description;
    private String schemaJson;
    private int status;
    private String notes;
    private String domain;
    private String graphQlUrl;
    private String restUrl;
    private String createdBy;
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

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId( String projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName( String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description) {
        this.description = description;
    }

    public String getSchemaJson() {
        return schemaJson;
    }

    public void setSchemaJson( String schemaJson) {
        this.schemaJson = schemaJson;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus( int status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes( String notes) {
        this.notes = notes;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain( String domain) {
        this.domain = domain;
    }

    public String getGraphQlUrl() {
        return graphQlUrl;
    }

    public void setGraphQlUrl( String graphQlUrl) {
        this.graphQlUrl = graphQlUrl;
    }

    public String getRestUrl() {
        return restUrl;
    }

    public void setRestUrl( String restUrl) {
        this.restUrl = restUrl;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy( String createdBy) {
        this.createdBy = createdBy;
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