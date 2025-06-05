package com.iefp.controle_escolar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iefp.controle_escolar.entities.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long>{
    Turma findByNome(String nome);
}