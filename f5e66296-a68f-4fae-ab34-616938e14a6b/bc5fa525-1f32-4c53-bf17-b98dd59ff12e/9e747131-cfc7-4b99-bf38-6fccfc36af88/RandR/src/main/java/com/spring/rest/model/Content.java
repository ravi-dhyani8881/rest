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
public class Content implements Serializable {


    @JsonProperty("ID")
    private String iD;

    private String contentdesc;

    private Date createdDate;

    private Date updatedDate;


/*

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String iD;
    private String contentdesc;
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

    public String getContentdesc() {
        return contentdesc;
    }

    public void setContentdesc( String contentdesc) {
        this.contentdesc = contentdesc;
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