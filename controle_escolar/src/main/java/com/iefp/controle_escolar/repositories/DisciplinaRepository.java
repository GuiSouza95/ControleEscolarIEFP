package com.iefp.controle_escolar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iefp.controle_escolar.entities.DisciplinaEntity;

import java.util.List;

public interface DisciplinaRepository extends JpaRepository<DisciplinaEntity, Long>{

    List<DisciplinaEntity> findByNomeContainingIgnoreCase(String nome);
}