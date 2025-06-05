package com.iefp.controle_escolar.services;

import java.util.List;

import com.iefp.controle_escolar.dtos.TurmaDTO;
import com.iefp.controle_escolar.entities.Turma;

public interface TurmaService {
    public List<TurmaDTO> findAllTurmas();
    public TurmaDTO findTurmaById(Long id);
    public Turma saveTurma(Turma turma);
    public TurmaDTO updateTurma(TurmaDTO turmaDto);
}
