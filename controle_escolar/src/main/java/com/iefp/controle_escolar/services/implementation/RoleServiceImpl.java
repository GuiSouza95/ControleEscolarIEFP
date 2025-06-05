package com.iefp.controle_escolar.services.implementation;

import com.iefp.controle_escolar.entities.Role;
import com.iefp.controle_escolar.repositories.RoleRepository;
import com.iefp.controle_escolar.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public List<Role> listarTodos() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> buscarPorId(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public Role salvar(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void excluir(Long id) {
        roleRepository.deleteById(id);
    }

}