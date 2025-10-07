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
public class Ratings implements Serializable {


    private String iD;
    private String reviewId;
    private String productId;
    private int ratingValue;
    private String name;


/*

    @Id
    private String iD;
    @NotNull
    private String reviewId;
    @NotNull
    private String productId;
    private int ratingValue;
    private String name;

*/

    public String getID() {
        return iD;
    }

    public void setID( String iD) {
        this.iD = iD;
    }
    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId( String reviewId) {
        this.reviewId = reviewId;
    }
    public String getProductId() {
        return productId;
    }

    public void setProductId( String productId) {
        this.productId = productId;
    }
    public int getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue( int ratingValue) {
        this.ratingValue = ratingValue;
    }
    public String getName() {
        return name;
    }

    public void setName( String name) {
        this.name = name;
    }
}