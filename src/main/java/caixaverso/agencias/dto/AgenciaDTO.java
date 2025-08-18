package caixaverso.agencias.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class AgenciaDTO {

    @JsonProperty("nome_agencia")
    private String nomeAgencia;
    @JsonProperty("nome_gestor")
    private String nomeGestor;
    private int cgc;
    @JsonProperty("data_inauguracao")
    private LocalDate dataInauguracao;
    private String endereco;

    public String getNomeAgencia() {
        return nomeAgencia;
    }

    public void setNomeAgencia(String nomeAgencia) {
        this.nomeAgencia = nomeAgencia;
    }

    public String getNomeGestor() {
        return nomeGestor;
    }

    public void setNomeGestor(String nomeGestor) {
        this.nomeGestor = nomeGestor;
    }

    public int getCgc() {
        return cgc;
    }

    public void setCgc(int cgc) {
        this.cgc = cgc;
    }

    public LocalDate getDataInauguracao() {
        return dataInauguracao;
    }

    public void setDataInauguracao(LocalDate dataInauguracao) {
        this.dataInauguracao = dataInauguracao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
