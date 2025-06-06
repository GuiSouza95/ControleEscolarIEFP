package com.iefp.controle_escolar.dtos;

import com.iefp.controle_escolar.entities.Aluno;
import lombok.*;

import java.util.List;

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
    private List<MenuItemDTO> menuItens;
}
