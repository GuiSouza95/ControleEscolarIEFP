package com.iefp.controle_escolar.services.implementation;

import com.iefp.controle_escolar.services.LoginService;
import lombok.RequiredArgsConstructor;
import com.iefp.controle_escolar.dtos.LoginRequestDTO;
import com.iefp.controle_escolar.dtos.LoginResponseDTO;
import com.iefp.controle_escolar.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final UsuarioRepository repository;

    @Override
    public LoginResponseDTO loginValidation(LoginRequestDTO loginRequest) {
        return null;
    }
}
