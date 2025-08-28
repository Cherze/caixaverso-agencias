package caixaverso.agencias.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "agencia")
public class Agencia {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "nome_agencia", nullable = false)
    @JsonProperty("nome_agencia")
    private String nomeAgencia;
    @Column(name = "nome_gestor", nullable = false)
    @JsonProperty("nome_gestor")
    private String nomeGestor;
    //@Pattern(regexp = "\\d{4}", message = "CGC deve ter exatamente 4 dígitos")
    @Column(name = "cgc", nullable = false, length=4)
    private int cgc;
    @Column(name = "data_inauguracao", nullable = false)
    @JsonProperty("data_inauguracao")
    private LocalDate dataInauguracao;
    @Column(name = "cep", nullable = false, length = 9)
    private String cep;
    @Column(name = "estado", nullable = false)
    private String estado;
    @Column(name = "cidade", nullable = false)
    private String cidade;
    @JsonProperty("created_at")
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public Agencia(String nomeAgencia,
                   String nomeGestor,
                   int cgc,
                   LocalDate dataInauguracao,
                   String cep) {
        this.nomeAgencia = nomeAgencia;
        this.nomeGestor = nomeGestor;
        this.cgc = cgc;
        this.dataInauguracao = dataInauguracao;
        this.cep = cep;
    }

    public Agencia() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getCep() {

        return cep;
    }

    public void setCep(String cep) {

        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public LocalDateTime getCreatedAt() {

        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {

        this.createdAt = createdAt;
    }
}
