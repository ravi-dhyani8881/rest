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
public class Like implements Serializable {


    @JsonProperty("ID")
    private String iD;

    private String reviewId;

    private String userId;

    private String contentId;

    private Date createdDate;

    private Date updatedDate;


/*

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String iD;
    private String reviewId;
    private String userId;
    private String contentId;
    private Date createdDate;
    private Date updatedDate;

*/

    @JsonProperty("ID")
    public String getID() {
        return iD;
    }

    @JsonProperty("ID")
    public void setID( String iD) {
        this.iD = iD;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId( String reviewId) {
        this.reviewId = reviewId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId( String userId) {
        this.userId = userId;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId( String contentId) {
        this.contentId = contentId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate( Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate( Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}