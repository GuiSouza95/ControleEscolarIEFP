package com.iefp.controle_escolar.dtos;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDTO {

    private String userName;
    private String password;
}
