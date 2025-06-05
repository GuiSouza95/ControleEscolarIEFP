package com.iefp.controle_escolar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iefp.controle_escolar.entities.Nota;


public interface NotaRepository extends JpaRepository<Nota, Long>{
    Nota findByMedia(String situacao);
}
