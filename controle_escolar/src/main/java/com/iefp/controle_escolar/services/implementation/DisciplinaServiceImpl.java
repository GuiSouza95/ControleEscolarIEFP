package com.iefp.controle_escolar.services.implementation;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iefp.controle_escolar.DTO.DisciplinaDTO;
import com.iefp.controle_escolar.entities.Disciplina;
import com.iefp.controle_escolar.entities.Turma;
import com.iefp.controle_escolar.repositories.DisciplinaRepository;
import com.iefp.controle_escolar.repositories.TurmaRepository;
import com.iefp.controle_escolar.services.DisciplinaService;

@Service
public class DisciplinaServiceImpl implements DisciplinaService{
        
    private final DisciplinaRepository disciplinaRepo;
    private final TurmaRepository turmaRepo;

    @Autowired
    public DisciplinaServiceImpl(DisciplinaRepository disciplinaRepo, TurmaRepository turmaRepo) {
        this.disciplinaRepo = disciplinaRepo;
        this.turmaRepo = turmaRepo;
    }

    @Override
    public List<DisciplinaDTO> findAllDisciplinas() {
        List<Disciplina> disciplinas = disciplinaRepo.findAll();

        return disciplinas.stream()
                .map(this::disciplinaToDisciplinaDto)
                .collect(Collectors.toList());
    }

    private DisciplinaDTO disciplinaToDisciplinaDto(Disciplina disciplina) {
        Set<Long> turmaIds = disciplina.getTurmas()
                .stream()
                .map(Turma::getId)
                .collect(Collectors.toSet());

        return DisciplinaDTO.builder()
                .id(disciplina.getId())
                .nome(disciplina.getNome())
                .turmaIds(turmaIds)
                .createTime(disciplina.getCreateTime())
                .updateTime(disciplina.getUpdateTime())
                .build();
    }

    private Disciplina disciplinaDtoToDisciplina(DisciplinaDTO dto) {
        Set<Turma> turmas = dto.getTurmaIds()
                .stream()
                .map(id -> turmaRepo.findById(id).orElse(null))
                .filter(t -> t != null)
                .collect(Collectors.toSet());

        return Disciplina.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .turmas(turmas)
                .createTime(dto.getCreateTime())
                .updateTime(dto.getUpdateTime())
                .build();
    }

    @Override
    public Disciplina saveDisciplina(Disciplina disciplina) {
        if (disciplina.getNome().isEmpty()) {
            return null;
        }

        return disciplinaRepo.save(disciplina);
    }

    @Override
    public DisciplinaDTO findDisciplinaById(Long id) {
        Disciplina disciplina = disciplinaRepo.findById(id).orElse(null);

        if (disciplina == null) {
            return null;
        }

        return disciplinaToDisciplinaDto(disciplina);
    }

    @Override
    public DisciplinaDTO updateDisciplina(DisciplinaDTO dto) {
        Disciplina disciplina = disciplinaDtoToDisciplina(dto);

        return disciplinaToDisciplinaDto(this.saveDisciplina(disciplina));
    }
}
