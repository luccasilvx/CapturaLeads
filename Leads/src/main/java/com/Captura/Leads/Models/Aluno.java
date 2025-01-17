package com.Captura.Leads.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "alunos")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo_matricula;

    @JsonProperty("nome")
    private String nome;

    @Email
    @JsonProperty("email")
    private String email;

    @JsonProperty("telefone")
    private String telefone;

    @JsonProperty("data_cadastro")
    private LocalDate data_cadastro;

    @JoinColumn(name = "turma_id")
    @JsonProperty("turma_id")
    @ManyToOne
    private Turmas turmas;

    @JoinColumn(name = "curso_id")
    @JsonProperty("curso_id")
    @ManyToOne
    private Cursos cursos;


    public Long getCodigo_matricula() {
        return codigo_matricula;
    }

    public void setCodigo_matricula(Long codigo_matricula) {
        this.codigo_matricula = codigo_matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(LocalDate data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public Turmas getTurmas() {
        return turmas;
    }

    public void setTurmas(Turmas turmas) {
        this.turmas = turmas;
    }

    public Cursos getCursos() {
        return cursos;
    }

    public void setCursos(Cursos cursos) {
        this.cursos = cursos;
    }
}
