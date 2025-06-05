package com.iefp.controle_escolar.services;

import java.util.List;

import com.iefp.controle_escolar.dtos.DisciplinaDTO;
import com.iefp.controle_escolar.entities.Disciplina;

public interface DisciplinaService {
    public List<DisciplinaDTO> findAllDisciplinas();
    public DisciplinaDTO findDisciplinaById(Long id);
    public Disciplina saveDisciplina(Disciplina disciplina);
    public DisciplinaDTO updateDisciplina(DisciplinaDTO disciplinaDto);
}
