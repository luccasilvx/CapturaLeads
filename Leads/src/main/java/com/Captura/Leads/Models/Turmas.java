package com.Captura.Leads.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "turmas")
public class Turmas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    @JsonProperty("curso_id")
    private Cursos cursos;
}
