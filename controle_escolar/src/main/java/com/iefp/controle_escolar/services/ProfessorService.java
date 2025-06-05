package com.iefp.controle_escolar.services;

import java.util.List;

import com.iefp.controle_escolar.DTO.ProfessorDTO;

public interface ProfessorService {
    ProfessorDTO createProfessor(ProfessorDTO professorDTO);
    ProfessorDTO getProfessorById(Long id);
    List<ProfessorDTO> getAllProfessores();
    void deleteProfessor(Long id);
}
