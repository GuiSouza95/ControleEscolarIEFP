package com.iefp.controle_escolar.entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "Aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

  //  @ManyToOne
 //   @JoinColumn(name = "turma_id")
//    private Turma turma;

    private String nome;
    private String apelido;
    private String sexo;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    private Boolean ativo;

    private LocalDateTime dataCriacao;
    private LocalDateTime dataAlteracao;
}