package com.spring.rest.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data // Generates getters, setters, toString, equals, hashCode
@NoArgsConstructor // Generates a no-argument constructor (required by Jackson for deserialization)
@AllArgsConstructor // Generates a constructor with all fields
@JsonInclude(JsonInclude.Include.NON_NULL) 
public class GraphVersions implements Serializable {


    private String iD;
    private String graphId;
    private int graphVersion;
    private String graphJson;
    private boolean isSaved;
    private boolean isPublished;
    private boolean isDeployed;
    private Date createdAt;
    private Date updatedAt;
    private String createdBy;
    private String notes;


/*

    private String iD;
    private String graphId;
    private int graphVersion;
    private String graphJson;
    private boolean isSaved;
    private boolean isPublished;
    private boolean isDeployed;
    private Date createdAt;
    private Date updatedAt;
    private String createdBy;
    private String notes;

*/

    public String getID() {
        return iD;
    }

    public void setID( String iD) {
        this.iD = iD;
    }
    public String getGraphId() {
        return graphId;
    }

    public void setGraphId( String graphId) {
        this.graphId = graphId;
    }
    public int getGraphVersion() {
        return graphVersion;
    }

    public void setGraphVersion( int graphVersion) {
        this.graphVersion = graphVersion;
    }
    public String getGraphJson() {
        return graphJson;
    }

    public void setGraphJson( String graphJson) {
        this.graphJson = graphJson;
    }
    public boolean getIsSaved() {
        return isSaved;
    }

    public void setIsSaved( boolean isSaved) {
        this.isSaved = isSaved;
    }
    public boolean getIsPublished() {
        return isPublished;
    }

    public void setIsPublished( boolean isPublished) {
        this.isPublished = isPublished;
    }
    public boolean getIsDeployed() {
        return isDeployed;
    }

    public void setIsDeployed( boolean isDeployed) {
        this.isDeployed = isDeployed;
    }
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt( Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt( Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy( String createdBy) {
        this.createdBy = createdBy;
    }
    public String getNotes() {
        return notes;
    }

    public void setNotes( String notes) {
        this.notes = notes;
    }
}