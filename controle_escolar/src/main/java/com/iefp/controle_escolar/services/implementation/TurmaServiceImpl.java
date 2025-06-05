package com.iefp.controle_escolar.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.iefp.controle_escolar.DTO.TurmaDTO;
import com.iefp.controle_escolar.entities.Turma;
import com.iefp.controle_escolar.repositories.TurmaRepository;
import com.iefp.controle_escolar.services.TurmaService;

public class TurmaServiceImpl implements TurmaService{
    TurmaRepository turmaRepo;

    @Autowired
    public TurmaServiceImpl(TurmaRepository turmaRepo){
        this.turmaRepo = turmaRepo;
    }

    @Override
    public List<TurmaDTO> findAllTurmas(){
        List<Turma> turmas = turmaRepo.findAll();
        
        return turmas.stream().map(this::turmaToTurmaDto).collect(Collectors.toList());
    }

    private TurmaDTO turmaToTurmaDto(Turma turma){
        TurmaDTO turmaDTO = TurmaDTO.builder()
            .id(turma.getId())
            .nome(turma.getNome())
            .periodo(turma.getPeriodo())
            .createTime(turma.getCreateTime())
            .updateTime(turma.getUpdateTime())
            .build();

        return turmaDTO;
    }


    private Turma turmaDtoToTurma(TurmaDTO turmaDto){
        Turma turma = Turma.builder()
            .id(turmaDto.getId())
            .nome(turmaDto.getNome())
            .periodo(turmaDto.getPeriodo())
            .createTime(turmaDto.getCreateTime())
            .updateTime(turmaDto.getUpdateTime())
            .build();

        return turma;
    }

    @Override
    public Turma saveTurma(Turma turma){
        if (turma.getNome().isEmpty()) {
            return null;
        }

        return turmaRepo.save(turma);
    }

    @Override
    public TurmaDTO findTurmaById(Long id){
        Turma turma = turmaRepo.findById(id).orElse(null);

        if (turma == null) {
            return null;            
        }

        return turmaToTurmaDto(turma);
    }

    @Override
    public TurmaDTO updateTurma(TurmaDTO turmaDto){
        Turma turma = turmaDtoToTurma(turmaDto);
            
        return turmaToTurmaDto(this.saveTurma(turma));
    }
}
