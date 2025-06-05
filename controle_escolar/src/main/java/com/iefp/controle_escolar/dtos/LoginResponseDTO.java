package com.iefp.controle_escolar.dtos;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDTO {

    private String message;
    private Boolean authenticated;
    private Long usuarioId;
    private String perfil; // "Aluno" ou "Professor"
}
