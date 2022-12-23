package com.soimrayh.systemapi.model.auth;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Classe que identifica como vai ser a respostas do token para o front
 * */

@Data
@NoArgsConstructor
public class JwtResponse {

    private String token;
    private final String type = "Bearer";
    private Long id;
    private String username;
    private List<String> roles;
}
