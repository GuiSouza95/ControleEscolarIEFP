package com.iefp.controle_escolar.mappers;

import com.iefp.controle_escolar.dtos.TurmaDisciplinaDTO;
import com.iefp.controle_escolar.entities.TurmaDisciplinaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TurmaDisciplinaMapper {

    public TurmaDisciplinaDTO toDTO(TurmaDisciplinaEntity turmaDisciplina) {

        if (turmaDisciplina == null) return null;

        return TurmaDisciplinaDTO.builder()
                .id(turmaDisciplina.getId())
                .turmaId(turmaDisciplina.getTurmaId())
                .disciplinaId(turmaDisciplina.getDisciplinaId())
                .professorId(turmaDisciplina.getProfessorId())
                .cargaHoraria(turmaDisciplina.getCargaHoraria())
                .build();
    }

    public TurmaDisciplinaEntity toEntity(TurmaDisciplinaDTO dto) {
        if (dto == null) return null;

        TurmaDisciplinaEntity turmaDisciplina = new TurmaDisciplinaEntity();
        turmaDisciplina.setId(dto.getId());
        turmaDisciplina.setTurmaId(dto.getTurmaId());
        turmaDisciplina.setDisciplinaId(dto.getDisciplinaId());
        turmaDisciplina.setProfessorId(dto.getProfessorId());
        turmaDisciplina.setCargaHoraria(dto.getCargaHoraria());

        return turmaDisciplina;
    }

    public List<TurmaDisciplinaDTO> toDTOList(List<TurmaDisciplinaEntity> turmas) {
        return turmas.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}