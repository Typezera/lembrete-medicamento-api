package com.LembreteMedicamento.lembretemedicamento.dto;

import com.LembreteMedicamento.lembretemedicamento.enums.StatusMedicamento;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class MedicamentoRequest {
    private String nome;
    private String horario;
    private StatusMedicamento status;

    public StatusMedicamento getStatus() {
        return status;
    }

    public void setStatus(StatusMedicamento status) {
        this.status = status;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
