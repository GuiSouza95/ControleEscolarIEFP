package com.iefp.controle_escolar.services;

import com.iefp.controle_escolar.dtos.LoginRequestDTO;
import com.iefp.controle_escolar.dtos.LoginResponseDTO;
import com.iefp.controle_escolar.entities.Aluno;

import java.util.List;
import java.util.Optional;

public interface LoginService {

    LoginResponseDTO loginValidation(LoginRequestDTO loginRequest);
}
