package com.LembreteMedicamento.lembretemedicamento.model;

import com.LembreteMedicamento.lembretemedicamento.enums.StatusMedicamento;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private LocalDateTime horario;
    @Enumerated(EnumType.STRING)
    private StatusMedicamento status;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public void Medicamento() {}

    public Long getId(){return id; }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public StatusMedicamento getStatus() {
        return status;
    }

    public void setStatus(StatusMedicamento status) {
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
