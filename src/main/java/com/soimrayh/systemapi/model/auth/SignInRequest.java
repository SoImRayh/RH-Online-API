package com.soimrayh.systemapi.model.auth;

import lombok.Data;

@Data
public class SignInRequest {
    private String username;
    private String password;
}
