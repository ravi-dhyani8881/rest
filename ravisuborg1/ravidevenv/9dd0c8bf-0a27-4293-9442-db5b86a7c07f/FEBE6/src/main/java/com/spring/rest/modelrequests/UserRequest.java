package com.spring.rest.modelrequests;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRequest {

    private String iD;
    private String email;
    private String firstName;
    private String middleName;
    private String lastName;
    private String address;
    private String company;
    private String role;
    private String password;
    private String passwordSalt;
    private String createdAt;
    private String updatedAt;
    private String userActivationKey;
    private String userStatus;

}