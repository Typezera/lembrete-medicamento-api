package com.LembreteMedicamento.lembretemedicamento.controller;

import com.LembreteMedicamento.lembretemedicamento.dto.MedicamentoRequest;
import com.LembreteMedicamento.lembretemedicamento.service.MedicamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicamento")
public class MedicamentoController {
    private final MedicamentoService medicamentoService;

    public MedicamentoController(MedicamentoService medicamentoService){
        this.medicamentoService = medicamentoService;
    }

    @PostMapping
    public ResponseEntity<?> criarMedicamento(@RequestBody MedicamentoRequest criarMed){
        try{
            medicamentoService.salvarMed(criarMed);
            return ResponseEntity.ok("Medicamento salvo");
        } catch (Exception e ){
            return ResponseEntity.badRequest().body("Erro ao salvar Medicamento..." + e.getMessage());
        }
    }

}
