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
public class Sales implements Serializable {


    private String iD;
    private String productId;
    private String quantity;
    private String totalPrice;
    private String saleDate;
    private String createdAt;
    private String updatedAt;


/*

    @Id
    private String iD;
    private String productId;
    private String quantity;
    private String totalPrice;
    private String saleDate;
    private String createdAt;
    private String updatedAt;

*/

    public String getID() {
        return iD;
    }

    public void setID( String iD) {
        this.iD = iD;
    }
    public String getProductId() {
        return productId;
    }

    public void setProductId( String productId) {
        this.productId = productId;
    }
    public String getQuantity() {
        return quantity;
    }

    public void setQuantity( String quantity) {
        this.quantity = quantity;
    }
    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice( String totalPrice) {
        this.totalPrice = totalPrice;
    }
    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate( String saleDate) {
        this.saleDate = saleDate;
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