package com.iefp.controle_escolar.mappers;

import com.iefp.controle_escolar.dtos.TurmaDTO;
import com.iefp.controle_escolar.entities.TurmaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TurmaMapper {

    public TurmaDTO toDTO(TurmaEntity turma) {

        if (turma == null) return null;

        return TurmaDTO.builder()
                .id(turma.getId())
                .nome(turma.getNome())
                .periodo(turma.getPeriodo())
                .build();
    }

    public TurmaEntity toEntity(TurmaDTO dto) {
        if (dto == null) return null;

        TurmaEntity turma = new TurmaEntity();
        turma.setId(dto.getId());
        turma.setNome(dto.getNome());
        turma.setPeriodo(dto.getPeriodo());

        return turma;
    }

    public List<TurmaDTO> toDTOList(List<TurmaEntity> turmas) {
        return turmas.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}