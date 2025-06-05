package com.iefp.controle_escolar.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotaDTO {
    private Long id;
    private Long alunoId;
    private Long disciplinaId;
    private Double nota1;
    private Double nota2;
    private Double media;
    private String situacao;
}