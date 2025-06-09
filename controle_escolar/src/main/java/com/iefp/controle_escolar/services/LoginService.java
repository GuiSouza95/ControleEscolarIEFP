package com.iefp.controle_escolar.services;

import com.iefp.controle_escolar.dtos.LoginRequestDTO;
import com.iefp.controle_escolar.dtos.LoginResponseDTO;

public interface LoginService {

    LoginResponseDTO loginValidation(LoginRequestDTO loginRequest);
}
