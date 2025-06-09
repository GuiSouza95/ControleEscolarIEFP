package com.iefp.controle_escolar.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TurmaDisciplinaDTO {

    private Long id;
    private Long turmaId;
    private String turmaNome;

    private Long disciplinaId;
    private String disciplinaNome;

    private Long professorId;
    private String professorNome;

    private Long cargaHoraria;
}
