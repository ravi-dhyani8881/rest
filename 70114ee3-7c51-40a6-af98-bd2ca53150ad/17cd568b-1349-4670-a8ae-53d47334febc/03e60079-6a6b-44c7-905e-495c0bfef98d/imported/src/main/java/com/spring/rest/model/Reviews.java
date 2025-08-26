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
public class Reviews implements Serializable {


    private String iD;
    private int rating;
    private String reviewText;
    private String productId;
    private String userId;
    private String createdAt;
    private String updatedAt;


/*

    @Id
    private String iD;
    @Column(unique = true)
    private int rating;
    @NotNull
    private String reviewText;
    @NotNull
    private String productId;
    @NotNull
    private String userId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String createdAt;
    @NotNull
    private String updatedAt;

*/

    public String getID() {
        return iD;
    }

    public void setID( String iD) {
        this.iD = iD;
    }
    public int getRating() {
        return rating;
    }

    public void setRating( int rating) {
        this.rating = rating;
    }
    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText( String reviewText) {
        this.reviewText = reviewText;
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