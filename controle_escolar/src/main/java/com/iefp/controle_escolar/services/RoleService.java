package com.iefp.controle_escolar.services;

import com.iefp.controle_escolar.dtos.RoleDTO;
import com.iefp.controle_escolar.entities.RoleEntity;

import java.util.List;

public interface RoleService {

    List<RoleDTO> listarTodos();
    RoleDTO buscarPorId(Long id);
    RoleEntity salvar(RoleEntity role);
    void excluir(Long id);
}
