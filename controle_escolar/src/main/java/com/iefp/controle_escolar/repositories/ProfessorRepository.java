package com.iefp.controle_escolar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iefp.controle_escolar.entities.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{
    com.iefp.controle_escolar.entities.Disciplina findByNome(String nome);
}