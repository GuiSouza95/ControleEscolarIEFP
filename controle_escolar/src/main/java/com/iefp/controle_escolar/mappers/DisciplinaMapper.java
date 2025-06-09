package com.iefp.controle_escolar.mappers;

import com.iefp.controle_escolar.dtos.DisciplinaDTO;
import com.iefp.controle_escolar.entities.DisciplinaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DisciplinaMapper {

    public DisciplinaDTO toDTO(DisciplinaEntity disciplina) {

        if (disciplina == null) return null;

        return DisciplinaDTO.builder()
                .id(disciplina.getId())
                .nome(disciplina.getNome())
                .build();
    }

    public DisciplinaEntity toEntity(DisciplinaDTO dto) {
        if (dto == null) return null;

        DisciplinaEntity disciplina = new DisciplinaEntity();
        disciplina.setId(dto.getId());
        disciplina.setNome(dto.getNome());

        return disciplina;
    }

    public List<DisciplinaDTO> toDTOList(List<DisciplinaEntity> disciplinas) {
        return disciplinas.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}