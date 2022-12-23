package com.soimrayh.systemapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/teste")
public class TesteControler {

    @GetMapping("")
    public String teste(){
        return "acessado!";
    }
}
