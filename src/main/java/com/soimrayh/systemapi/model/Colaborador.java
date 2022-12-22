package com.soimrayh.systemapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Colaborador {
    private long id;
    private String firstName;
    private String lastName;
    private String emailID;
}
