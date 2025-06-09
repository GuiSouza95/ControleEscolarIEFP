package com.iefp.controle_escolar.dtos;

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
    private String profile;
    private String nickname;
    private List<MenuItemDTO> menuItems;
}
