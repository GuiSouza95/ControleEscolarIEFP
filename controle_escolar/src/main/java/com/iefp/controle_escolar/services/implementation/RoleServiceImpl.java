package com.iefp.controle_escolar.services.implementation;

import com.iefp.controle_escolar.dtos.RoleDTO;
import com.iefp.controle_escolar.entities.RoleEntity;
import com.iefp.controle_escolar.mappers.RoleMapper;
import com.iefp.controle_escolar.repositories.RoleRepository;
import com.iefp.controle_escolar.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public List<RoleDTO> listarTodos() {

        List<RoleEntity> roleEntities = roleRepository.findAll();
        return roleMapper.toDTOList(roleEntities);
    }

    @Override
    public RoleDTO buscarPorId(Long id) {

        RoleEntity roleEntity = roleRepository.findById(id).orElseThrow();
        return roleMapper.toDTO(roleEntity);
    }

    @Override
    public RoleEntity salvar(RoleEntity role) {
        return roleRepository.save(role);
    }

    @Override
    public void excluir(Long id) {
        roleRepository.deleteById(id);
    }

}