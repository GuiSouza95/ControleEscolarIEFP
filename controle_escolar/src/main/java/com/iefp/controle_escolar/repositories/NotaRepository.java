package com.iefp.controle_escolar.repositories;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iefp.controle_escolar.entities.Nota;


public interface NotaRepository extends JpaRepository<Nota, Long>{
    Optional<Nota> findByMedia(BigDecimal media);
}
