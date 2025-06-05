package com.iefp.controle_escolar.dtos;

import java.time.LocalDateTime;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DisciplinaDTO {
    private Long id;
    private String nome;
    private int carga_horaria;
    private Set<Long> turmaIds;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
