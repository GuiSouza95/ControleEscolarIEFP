package com.iefp.controle_escolar.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iefp.controle_escolar.dtos.ProfessorDTO;
import com.iefp.controle_escolar.entities.Disciplina;
import com.iefp.controle_escolar.entities.Professor;
import com.iefp.controle_escolar.entities.Turma;
import com.iefp.controle_escolar.repositories.DisciplinaRepository;
import com.iefp.controle_escolar.repositories.ProfessorRepository;
import com.iefp.controle_escolar.repositories.TurmaRepository;
import com.iefp.controle_escolar.repositories.UsuarioRepository;
import com.iefp.controle_escolar.services.ProfessorService;

@Service
public class ProfessorServiceImpl implements ProfessorService{
    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Override
    public ProfessorDTO createProfessor(ProfessorDTO dto) {
        Professor professor = new Professor();
        professor.setNome(dto.getNome());
        professor.setUser(userRepository.findById(dto.getUserId()).orElseThrow());

        professor.setTurmas(turmaRepository.findAllById(dto.getTurmaIds()));
        professor.setDisciplinas(disciplinaRepository.findAllById(dto.getDisciplinaIds()));

        professor = professorRepository.save(professor);

        dto.setId(professor.getId());
        return dto;
    }

    @Override
    public ProfessorDTO getProfessorById(Long id) {
        Professor professor = professorRepository.findById(id).orElseThrow();

        ProfessorDTO dto = new ProfessorDTO();
        dto.setId(professor.getId());
        dto.setNome(professor.getNome());
        dto.setUserId(professor.getUser().getId());
        dto.setTurmaIds(professor.getTurmas().stream().map(Turma::getId).collect(Collectors.toList()));
        dto.setDisciplinaIds(professor.getDisciplinas().stream().map(Disciplina::getId).collect(Collectors.toList()));

        return dto;
    }

    @Override
    public List<ProfessorDTO> getAllProfessores() {
        return professorRepository.findAll().stream().map(professor -> {
            ProfessorDTO dto = new ProfessorDTO();
            dto.setId(professor.getId());
            dto.setNome(professor.getNome());
            dto.setUserId(professor.getUser().getId());
            dto.setTurmaIds(professor.getTurmas().stream().map(Turma::getId).collect(Collectors.toList()));
            dto.setDisciplinaIds(professor.getDisciplinas().stream().map(Disciplina::getId).collect(Collectors.toList()));
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void deleteProfessor(Long id) {
        professorRepository.deleteById(id);
    }
}
