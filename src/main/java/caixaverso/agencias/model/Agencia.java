package caixaverso.agencias.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.processing.Pattern;

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
    //@NotBlank(message = "CGC é obrigatório")
    //@Pattern(regexp = "\\d{4}", message = "CGC deve ter exatamente 4 dígitos")
    @Column(name = "cgc", nullable = false, length=4)
    private int cgc;
    @Column(name = "data_inauguracao", nullable = false)
    @JsonProperty("data_inauguracao")
    private LocalDate dataInauguracao;
    @Column(name = "endereco", nullable = false, length = 100)
    private String endereco;
    @JsonProperty("created_at")
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public Agencia(String nomeAgencia,
                   String nomeGestor,
                   int cgc,
                   LocalDate dataInauguracao,
                   String endereco) {
        this.nomeAgencia = nomeAgencia;
        this.nomeGestor = nomeGestor;
        this.cgc = cgc;
        this.dataInauguracao = dataInauguracao;
        this.endereco = endereco;
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

    public String getEndereco() {

        return endereco;
    }

    public void setEndereco(String endereco) {

        this.endereco = endereco;
    }

    public LocalDateTime getCreatedAt() {

        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {

        this.createdAt = createdAt;
    }
}
