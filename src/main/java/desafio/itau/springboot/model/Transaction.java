package desafio.itau.springboot.model;

import java.time.OffsetDateTime;

import jakarta.validation.constraints.NotBlank;

public class Transaction {
    @NotBlank
    private double valor;
    @NotBlank
    private OffsetDateTime dataHora;

    public Transaction(final double valor, final OffsetDateTime dataHora){
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }

    public double getValor() {
        return valor;
    }
}
