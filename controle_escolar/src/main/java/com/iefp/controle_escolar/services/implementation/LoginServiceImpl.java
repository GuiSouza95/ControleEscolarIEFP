package com.iefp.controle_escolar.services.implementation;

import com.iefp.controle_escolar.dtos.MenuItemDTO;
import com.iefp.controle_escolar.entities.UserEntity;
import com.iefp.controle_escolar.services.LoginService;
import com.iefp.controle_escolar.utils.CriptografiaUtil;
import lombok.RequiredArgsConstructor;
import com.iefp.controle_escolar.dtos.LoginRequestDTO;
import com.iefp.controle_escolar.dtos.LoginResponseDTO;
import com.iefp.controle_escolar.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public LoginResponseDTO loginValidation(LoginRequestDTO loginRequest) {

        UserEntity userFound = usuarioRepository.findByUsuario(loginRequest.getUsuario()).orElse(null);

        if (userFound == null) {
            return LoginResponseDTO.builder()
                    .authenticated(false)
                    .message("Usuário ou senha inválida.")
                    .build();
        }

        if (userFound.isAccountNonLocked()) {
            return LoginResponseDTO.builder()
                    .authenticated(false)
                    .message("Conta bloqueada. Contacte o administrador.")
                    .build();
        }

        if (!CriptografiaUtil.verificarSenha(loginRequest.getPassword(), userFound.getPassword())) {

            userFound.setTentativas(userFound.getTentativas() + 1);

            if (userFound.getTentativas() >= 5){
                userFound.setAccountNonLocked(true);
            }

            usuarioRepository.save(userFound);

            return LoginResponseDTO.builder()
                    .authenticated(false)
                    .message("Usuário ou senha inválida.")
                    .build();
        }

        List<MenuItemDTO> menuItems = userFound.getRole().get(0).getMenuItems().stream()
                .map(item -> new MenuItemDTO(item.getTitle(), item.getRoute()))
                .toList();

        return LoginResponseDTO.builder()
                .authenticated(true)
                .userId(userFound.getId())
                .profile(userFound.getRole().get(0).getNome())
                .nickname(userFound.getNome())
                .menuItems(menuItems)
                .build();
        }
}
