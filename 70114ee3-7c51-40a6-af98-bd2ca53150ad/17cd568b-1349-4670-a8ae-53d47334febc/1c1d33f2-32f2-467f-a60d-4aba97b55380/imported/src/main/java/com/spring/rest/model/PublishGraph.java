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
public class PublishGraph implements Serializable {


    private int iD;
    private String orgID;
    private String subOrgID;
    private String envId;
    private String publish_graph_json;
    private String version;


/*

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iD;
    private String orgID;
    private String subOrgID;
    private String envId;
    private String publish_graph_json;
    private String version;

*/

    public int getID() {
        return iD;
    }

    public void setID( int iD) {
        this.iD = iD;
    }
    public String getOrgID() {
        return orgID;
    }

    public void setOrgID( String orgID) {
        this.orgID = orgID;
    }
    public String getSubOrgID() {
        return subOrgID;
    }

    public void setSubOrgID( String subOrgID) {
        this.subOrgID = subOrgID;
    }
    public String getEnvId() {
        return envId;
    }

    public void setEnvId( String envId) {
        this.envId = envId;
    }
    public String getPublish_graph_json() {
        return publish_graph_json;
    }

    public void setPublish_graph_json( String publish_graph_json) {
        this.publish_graph_json = publish_graph_json;
    }
    public String getVersion() {
        return version;
    }

    public void setVersion( String version) {
        this.version = version;
    }
}