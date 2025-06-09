package com.iefp.controle_escolar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iefp.controle_escolar.entities.TurmaEntity;

import java.util.List;

public interface TurmaRepository extends JpaRepository<TurmaEntity, Long>{

    List<TurmaEntity> findByNomeContainingIgnoreCase(String nome);
}