package com.iefp.controle_escolar.mappers;

import com.iefp.controle_escolar.dtos.RoleDTO;
import com.iefp.controle_escolar.entities.RoleEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleMapper {

    public RoleDTO toDTO(RoleEntity role) {

        if (role == null) return null;

        return RoleDTO.builder()
                .id(role.getId())
                .nome(role.getNome())
                .build();
    }

    public RoleEntity toEntity(RoleDTO dto) {

        if (dto == null) return null;

        RoleEntity role = new RoleEntity();
        role.setId(dto.getId());
        role.setNome(dto.getNome());

        return role;
    }

    public List<RoleDTO> toDTOList(List<RoleEntity> users) {
        return users.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<RoleEntity> toEntityList(List<RoleDTO> users) {
        return users.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}