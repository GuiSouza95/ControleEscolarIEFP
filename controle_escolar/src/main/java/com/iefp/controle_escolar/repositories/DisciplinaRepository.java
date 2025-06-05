package com.iefp.controle_escolar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iefp.controle_escolar.entities.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{
    Disciplina findByNome(String nome);
}