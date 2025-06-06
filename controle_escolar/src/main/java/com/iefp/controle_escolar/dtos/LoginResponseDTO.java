package com.iefp.controle_escolar.dtos;

import com.iefp.controle_escolar.entities.Aluno;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDTO {

    private String message;
    private boolean authenticated;
    private Long userId;
    private String perfil;
    private Aluno aluno;
}
