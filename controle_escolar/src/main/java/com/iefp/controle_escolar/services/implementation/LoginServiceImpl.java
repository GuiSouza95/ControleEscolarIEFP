package com.iefp.controle_escolar.services.implementation;

import com.iefp.controle_escolar.entities.Aluno;
import com.iefp.controle_escolar.entities.Usuario;
import com.iefp.controle_escolar.repositories.AlunoRepository;
import com.iefp.controle_escolar.services.LoginService;
import com.iefp.controle_escolar.utils.CriptografiaUtil;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import com.iefp.controle_escolar.dtos.LoginRequestDTO;
import com.iefp.controle_escolar.dtos.LoginResponseDTO;
import com.iefp.controle_escolar.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final UsuarioRepository usuarioRepository;
    private final AlunoRepository alunoRepository;

    @Override
    public LoginResponseDTO loginValidation(LoginRequestDTO loginRequest) {

        Usuario usuarioFound = usuarioRepository.findByUsuario(loginRequest.getUsuario()).orElse(null);

        if (usuarioFound == null) {
            return LoginResponseDTO.builder()
                    .authenticated(false)
                    .message("Usuário ou senha inválida.")
                    .build();
        }


        if (!CriptografiaUtil.verificarSenha(loginRequest.getPassword(), usuarioFound.getPassword())) {

            if (usuarioFound.isAccountNonLocked()) {
                return LoginResponseDTO.builder()
                        .authenticated(false)
                        .message("Conta bloqueada. Contacte o administrador.")
                        .build();
            }

            usuarioFound.setTentativas(usuarioFound.getTentativas() + 1);

            if (usuarioFound.getTentativas()>=5){
                usuarioFound.setAccountNonLocked(true);
            }

            usuarioRepository.save(usuarioFound);

            return LoginResponseDTO.builder()
                    .authenticated(false)
                    .message("Usuário ou senha inválida.")
                    .build();
        }


        Aluno alunoFound = alunoRepository.findByUsuarioId(usuarioFound.getId()).orElse(null);

        return LoginResponseDTO.builder()
                .authenticated(true)
                .userId(usuarioFound.getId())
                .perfil(usuarioFound.getRole().get(0).getNome())
                .aluno(alunoFound)
                .build();
        }

}
