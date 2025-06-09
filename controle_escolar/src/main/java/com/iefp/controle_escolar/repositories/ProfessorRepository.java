package com.iefp.controle_escolar.repositories;

import com.iefp.controle_escolar.entities.DisciplinaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import com.iefp.controle_escolar.entities.Professor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{
    DisciplinaEntity findByNome(String nome);
    Optional<Professor> findByUsuarioId(Long userId);
}