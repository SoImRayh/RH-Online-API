package com.soimrayh.systemapi.service.implementation;

import com.soimrayh.systemapi.entity.ColaboradorEntity;
import com.soimrayh.systemapi.model.Colaborador;
import com.soimrayh.systemapi.repository.Colaboradorrepository;
import com.soimrayh.systemapi.service.ColaboradorService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColaboboradorServiceImplementation implements ColaboradorService {
    private final Colaboradorrepository colaboradorrepository;

    public ColaboboradorServiceImplementation(Colaboradorrepository colaboradorrepository) {
        this.colaboradorrepository = colaboradorrepository;
    }

    @Override
    public Colaborador save(Colaborador colaborador) {
        ColaboradorEntity colaboradorEntity = new ColaboradorEntity();
        BeanUtils.copyProperties(colaborador, colaboradorEntity);
        colaboradorrepository.save(colaboradorEntity);
        return colaborador;
    }

    @Override
    public List<Colaborador> getAll() {
        List<ColaboradorEntity> colaboradorEntityList = colaboradorrepository.findAll();

        return colaboradorEntityList.stream().map(col ->
                        new Colaborador(col.getId() , col.getFirstName(), col.getLastName(), col.getEmailID()))
                .toList();
    }

    @Override
    public boolean delete(Long id) {
        ColaboradorEntity colaboradorEntity = colaboradorrepository.findById(id).get();
        colaboradorrepository.delete(colaboradorEntity);
        return true;
    }

    @Override
    public Colaborador getOne(Long id) {
        ColaboradorEntity  colaboradorEntity = colaboradorrepository.findById(id).get();
        Colaborador colaborador = new Colaborador();
        BeanUtils.copyProperties(colaboradorEntity, colaborador);
        return colaborador;
    }

    @Override
    public Colaborador update(Long id, Colaborador colaborador) {
        ColaboradorEntity colaboradorEntity = colaboradorrepository.findById(id).get();
        colaboradorEntity.setFirstName(colaborador.getFirstName());
        colaboradorEntity.setLastName(colaborador.getLastName());
        colaboradorEntity.setEmailID(colaborador.getEmailID());

        colaboradorrepository.save(colaboradorEntity);
        return colaborador;
    }
}
