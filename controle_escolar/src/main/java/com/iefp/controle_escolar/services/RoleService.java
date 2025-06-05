package com.iefp.controle_escolar.services;

import com.iefp.controle_escolar.entities.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    List<Role> listarTodos();
    Optional<Role> buscarPorId(Long id);
    Role salvar(Role role);
    void excluir(Long id);
}
