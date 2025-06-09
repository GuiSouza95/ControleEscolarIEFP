package com.iefp.controle_escolar.services;

import com.iefp.controle_escolar.dtos.UserDTO;
import com.iefp.controle_escolar.entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<UserDTO> listarTodos();
    List<UserDTO> listarPorNome (String nome);
    List<UserDTO> listarProfessores();
    Optional<UserEntity> buscarPorUsuario(String usuario);
    UserDTO buscarPorId(Long id);
    void salvar(UserDTO user);
    void excluirById(Long id);
}
