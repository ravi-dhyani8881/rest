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
public class Purchases implements Serializable {


    private String iD;
    private String productId;
    private String quantity;
    private String totalCost;
    private String purchaseDate;
    private String createdAt;
    private String updatedAt;


/*

    @Id
    private String iD;
    private String productId;
    private String quantity;
    private String totalCost;
    private String purchaseDate;
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
    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost( String totalCost) {
        this.totalCost = totalCost;
    }
    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate( String purchaseDate) {
        this.purchaseDate = purchaseDate;
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