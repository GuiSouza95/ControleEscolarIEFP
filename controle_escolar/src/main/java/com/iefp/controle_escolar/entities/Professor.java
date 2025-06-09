package com.iefp.controle_escolar.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "professor")
public class Professor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UserEntity usuario;

    /*@ManyToMany
    @JoinTable(
        name = "professor_turma",
        joinColumns = @JoinColumn(name = "professor_id"),
        inverseJoinColumns = @JoinColumn(name = "turma_id")
    )
    private List<Turma> turmas;

    @ManyToMany
    @JoinTable(
        name = "professor_disciplina",
        joinColumns = @JoinColumn(name = "professor_id"),
        inverseJoinColumns = @JoinColumn(name = "disciplina_id")
    )
    private List<Disciplina> disciplinas;*/
}