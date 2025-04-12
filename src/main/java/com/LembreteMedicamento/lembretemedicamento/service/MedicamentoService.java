package com.LembreteMedicamento.lembretemedicamento.service;

import com.LembreteMedicamento.lembretemedicamento.model.Medicamento;
import com.LembreteMedicamento.lembretemedicamento.repository.MedicamentoRepository;
import org.springframework.stereotype.Service;

@Service
public class MedicamentoService {
    private final MedicamentoRepository medicamentoRepository;

    public MedicamentoService(MedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }

    public Medicamento salvar(Medicamento medicamento){
        medicamentoRepository.save(medicamento);
        return medicamento;
    }
}
