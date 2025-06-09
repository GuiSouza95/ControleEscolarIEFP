package com.iefp.controle_escolar.services.implementation;

import com.iefp.controle_escolar.dtos.RoleDTO;
import com.iefp.controle_escolar.dtos.UserDTO;
import com.iefp.controle_escolar.entities.UserEntity;
import com.iefp.controle_escolar.mappers.UserMapper;
import com.iefp.controle_escolar.repositories.UsuarioRepository;
import com.iefp.controle_escolar.services.RoleService;
import com.iefp.controle_escolar.services.UsuarioService;
import com.iefp.controle_escolar.utils.CriptografiaUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceimpl implements UsuarioService {

    private final UsuarioRepository repository;
    private final UserMapper userMapper;
    private final RoleService roleService;

    @Override
    public List<UserDTO> listarTodos () {

        List<UserEntity> userEntities = repository.findAll();
        return userMapper.toDTOList(userEntities);
    }

    @Override
    public List<UserDTO> listarPorNome(String nome) {

        List<UserEntity> userEntities = repository.findByNomeContainingIgnoreCase(nome);
        return userMapper.toDTOList(userEntities);
    }

    @Override
    public List<UserDTO> listarProfessores() {
        List<UserEntity> userEntities = repository.listarProfessores();
        return userMapper.toDTOList(userEntities);
    }

    @Override
    public Optional<UserEntity> buscarPorUsuario(String usuario) {
        return repository.findByUsuario(usuario);
    }

    @Override
    public UserDTO buscarPorId(Long id) {
        return userMapper.toDTO(repository.findById(id).orElseThrow());
    }

    @Override
    public void salvar(UserDTO user) {

        RoleDTO role = roleService.buscarPorId(user.getProfileId());
        user.setProfiles(List.of(role));

        UserEntity userEntity = userMapper.toEntity(user);
        userEntity.setPassword(CriptografiaUtil.criptografarSenha("12345"));
        userEntity.setDataCriacao(LocalDateTime.now());

        repository.save(userEntity);
    }

    @Override
    public void excluirById(Long id) {
        repository.deleteById(id);
    }
}
