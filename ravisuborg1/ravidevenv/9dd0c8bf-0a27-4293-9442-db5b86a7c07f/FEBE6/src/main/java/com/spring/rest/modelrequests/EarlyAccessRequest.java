package com.spring.rest.modelrequests;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EarlyAccessRequest {


    private String firstName;

    private String lastName;

    private String email;

    private String role;

    private String company;

    private String companyUrl;

    private String description;

}