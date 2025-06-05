package com.iefp.controle_escolar.services;

import com.iefp.controle_escolar.entities.Role;
import com.iefp.controle_escolar.repositories.RoleRepository;
import com.iefp.controle_escolar.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public List<Role> listarTodos() {
        return roleRepository.findAll();
    }

    public Optional<Role> buscarPorId(Long id) {
        return roleRepository.findById(id);
    }

    public Role salvar(Role role) {
        return roleRepository.save(role);
    }

    public void excluir(Long id) {
        roleRepository.deleteById(id);
    }

}