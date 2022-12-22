package com.soimrayh.systemapi.service;

import com.soimrayh.systemapi.model.Colaborador;

import java.util.List;

public interface ColaboradorService {
    Colaborador save(Colaborador colaborador);

    List<Colaborador> getAll();

    boolean delete(Long id);

    Colaborador getOne(Long id);

    Colaborador update(Long id, Colaborador colaborador);
}
