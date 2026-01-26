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
public class Reviews implements Serializable {


    @JsonProperty("ID")
    private String iD;

    private String productId;

    private String userId;

    private int rating;

    private String comment;

    private String createdAt;

    private String updatedAt;


/*

    @Id
    private String iD;
    private String productId;
    private String userId;
    private int rating;
    private String comment;
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

    public String getProductId() {
        return productId;
    }

    public void setProductId( String productId) {
        this.productId = productId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId( String userId) {
        this.userId = userId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating( int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment( String comment) {
        this.comment = comment;
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