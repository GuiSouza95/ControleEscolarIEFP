package com.iefp.controle_escolar.dtos;

import java.math.BigDecimal;

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
    private BigDecimal nota1;
    private BigDecimal nota2;
    private BigDecimal media;
    private String situacao;
}