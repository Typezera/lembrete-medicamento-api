package com.LembreteMedicamento.lembretemedicamento.service;

import com.LembreteMedicamento.lembretemedicamento.dto.MedicamentoRequest;
import com.LembreteMedicamento.lembretemedicamento.model.Medicamento;
import com.LembreteMedicamento.lembretemedicamento.repository.MedicamentoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class MedicamentoService {
    private final MedicamentoRepository medicamentoRepository;

    public MedicamentoService(MedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }

    public void salvarMed(MedicamentoRequest request){
        LocalDateTime horarioConv = conversorHorario(request.getHorario());

        Medicamento med = new Medicamento();
        med.setNome(request.getNome());
        med.setHorario(horarioConv);
        med.setStatus(request.getStatus());
        med.setUsuario(null);

        medicamentoRepository.save(med);
    }

    public LocalDateTime conversorHorario(String horario){
        try{
            return LocalDateTime.parse(horario);
        }catch (Exception e ){
            if(horario.toLowerCase().contains("horas")){
                int hora = Integer.parseInt(horario.replaceAll("\\D", ""));
                return LocalDateTime.of(LocalDate.now(), LocalTime.of(hora, 0));
            } else {
                throw new RuntimeException("Formato de hora inválido!");
            }
        }
    }
}
