package com.iefp.controle_escolar.DTO;

import java.time.LocalDateTime;

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
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}