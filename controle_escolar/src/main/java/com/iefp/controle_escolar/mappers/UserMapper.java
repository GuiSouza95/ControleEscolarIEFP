package com.iefp.controle_escolar.mappers;

import com.iefp.controle_escolar.dtos.UserDTO;
import com.iefp.controle_escolar.entities.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final RoleMapper roleMapper;

    public UserDTO toDTO(UserEntity user) {

        if (user == null) return null;

        return UserDTO.builder()
                .id(user.getId())
                .nome(user.getNome())
                .usuario(user.getUsuario())
                .status(user.getStatus())
                .profiles(roleMapper.toDTOList(user.getRole()))
                .profile(roleMapper.toDTO(user.getRole().get(0)))
                .sexo(user.getSexo())
                .dataNascimento(user.getDataNascimento())
                .build();
    }

    public UserEntity toEntity(UserDTO dto) {
        if (dto == null) return null;

        UserEntity user = new UserEntity();
        user.setId(dto.getId());
        user.setNome(dto.getNome());
        user.setUsuario(dto.getUsuario());
        user.setStatus(dto.getStatus());
        user.setStatus(dto.getStatus());
        user.setDataNascimento(dto.getDataNascimento());
        user.setSexo(dto.getSexo());
        user.setRole(roleMapper.toEntityList(dto.getProfiles()));

        return user;
    }

    public List<UserDTO> toDTOList(List<UserEntity> users) {
        return users.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}