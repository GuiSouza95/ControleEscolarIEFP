package com.iefp.controle_escolar.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TurmaDTO {

    private Long id;
    private String nome;
    private String periodo;
}