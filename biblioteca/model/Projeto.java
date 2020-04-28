package br.com.biblioteca.model;

import br.com.biblioteca.model.Risco;
import br.com.biblioteca.model.Status;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.ZonedDateTime;

/**
 * Projetos entity.
 */
@Entity
@Table(name = "projeto")
public class Projeto {
    @Id
    private Long id;

    @Column(name = "nome", nullable = false, length = 200)
    private String nome;

    @Column(name = "data_inicio")
    private ZonedDateTime dataInicio;

    @Column(name = "data_previsao_fim")
    private ZonedDateTime dataPrevisaoFim;

    @Column(name = "data_fim")
    private ZonedDateTime dataFim;

    @Column(name = "orcamento")
    private Float orcamento;

    @Column(name = "descricao", length = 5000)
    private String descricao;

    @Column(name = "status")
    private Status status;

    @Column(name = "risco")
    private Risco risco;

    @Column(name = "idgerente")
    private Long idgerente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ZonedDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(ZonedDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Long getIdgerente() {
        return idgerente;
    }

    public void setIdgerente(Long idgerente) {
        this.idgerente = idgerente;
    }

    public ZonedDateTime getDataPrevisaoFim() {
        return dataPrevisaoFim;
    }

    public void setDataPrevisaoFim(ZonedDateTime dataPrevisaoFim) {
        this.dataPrevisaoFim = dataPrevisaoFim;
    }

    public ZonedDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(ZonedDateTime dataFim) {
        this.dataFim = dataFim;
    }

    public Float getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Float orcamento) {
        this.orcamento = orcamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Risco getRisco() {
        return risco;
    }

    public void setRisco(Risco risco) {
        this.risco = risco;
    }
}
