package com.iefp.controle_escolar.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "turma_disciplina")
public class TurmaDisciplinaEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    private Long disciplinaId;
    private Long turmaId;
    private Long professorId;
    private Long cargaHoraria;
}
