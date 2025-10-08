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
public class Products implements Serializable {


    private String iD;
    private String name;
    private String price;
    private String stock;
    private String createdAt;
    private String updatedAt;


/*

    @Id
    private String iD;
    @Column(unique = true)
    private String name;
    private String price;
    private String stock;
    private String createdAt;
    private String updatedAt;

*/

    public String getID() {
        return iD;
    }

    public void setID( String iD) {
        this.iD = iD;
    }
    public String getName() {
        return name;
    }

    public void setName( String name) {
        this.name = name;
    }
    public String getPrice() {
        return price;
    }

    public void setPrice( String price) {
        this.price = price;
    }
    public String getStock() {
        return stock;
    }

    public void setStock( String stock) {
        this.stock = stock;
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