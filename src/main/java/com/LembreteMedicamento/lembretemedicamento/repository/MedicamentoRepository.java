package com.LembreteMedicamento.lembretemedicamento.repository;

import com.LembreteMedicamento.lembretemedicamento.model.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {

}
