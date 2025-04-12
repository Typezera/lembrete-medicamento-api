package com.LembreteMedicamento.lembretemedicamento.enums;

public enum StatusMedicamento {
    PENDENTE( "Pendente" ),
    CONSUMIDO("CONSUMIDO"),
    ESQUECEU("ESQUECEU");

    private final String descricao;

    StatusMedicamento(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
