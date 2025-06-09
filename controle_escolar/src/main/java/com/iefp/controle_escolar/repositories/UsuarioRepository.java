package com.iefp.controle_escolar.repositories;

import com.iefp.controle_escolar.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsuario(String usuario);
    List<UserEntity> findByNomeContainingIgnoreCase(String nome);

    @Query("SELECT u FROM UserEntity u JOIN u.role r WHERE UPPER(r.nome) = 'Professor'")
    List<UserEntity> listarProfessores();
}