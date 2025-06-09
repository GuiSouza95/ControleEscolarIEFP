package com.iefp.controle_escolar.dtos;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;
    private String nome;
    private String usuario;
    private String status;
    private List<RoleDTO> profiles;
    private RoleDTO profile;
    private Long profileId;
    private String sexo;
    private LocalDate dataNascimento;
}