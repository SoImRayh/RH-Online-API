package com.soimrayh.systemapi.controller;

import com.soimrayh.systemapi.model.Colaborador;
import com.soimrayh.systemapi.service.ColaboradorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/colaboradores")
@CrossOrigin(origins = "*")
public class ColaboradorController {
    private final ColaboradorService colaboradorService;

    public ColaboradorController(ColaboradorService colaboradorService) {
        this.colaboradorService = colaboradorService;
    }


    @PostMapping("")
    public Colaborador createColaborador(@RequestBody Colaborador colaborador){
        return colaboradorService.save(colaborador);
    }


    @GetMapping("all")
    public List<Colaborador> getAll(){
        return colaboradorService.getAll();
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable Long id){
        boolean deleted = colaboradorService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }


    @GetMapping("{id}")
    public ResponseEntity<Colaborador> getOne(@PathVariable Long id){
        Colaborador colaborador = colaboradorService.getOne(id);
        return ResponseEntity.ok(colaborador);
    }


    @PutMapping("{id}")
    public ResponseEntity<Colaborador> update (@PathVariable Long id, @RequestBody Colaborador colaborador){
        return ResponseEntity.ok(colaboradorService.update(id, colaborador));
    }
}
