package com.iefp.controle_escolar.services.implementation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iefp.controle_escolar.DTO.NotaDTO;
import com.iefp.controle_escolar.entities.Nota;
import com.iefp.controle_escolar.repositories.AlunoRepository;
import com.iefp.controle_escolar.repositories.DisciplinaRepository;
import com.iefp.controle_escolar.repositories.NotaRepository;
import com.iefp.controle_escolar.services.NotaService;

@Service
public class NotaServiceImpl implements NotaService{
    @Autowired
    private NotaRepository notaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Override
    public NotaDTO createNota(NotaDTO dto) {
        Nota nota = new Nota();

        nota.setAluno(alunoRepository.findById(dto.getAlunoId()).orElseThrow());
        nota.setDisciplina(disciplinaRepository.findById(dto.getDisciplinaId()).orElseThrow());

        nota.setNota1(dto.getNota1());
        nota.setNota2(dto.getNota2());

        BigDecimal media = dto.getNota1()
            .add(dto.getNota2())
            .divide(BigDecimal.valueOf(2), 2, RoundingMode.HALF_UP);
        nota.setMedia(media);

        nota.setSituacao(dto.getSituacao() != null ? dto.getSituacao() : (media.doubleValue() >= 6.0 ? "Aprovado" : "Reprovado"));

        nota = notaRepository.save(nota);

        dto.setId(nota.getId());
        dto.setMedia(media);
        if (dto.getSituacao() == null) dto.setSituacao(nota.getSituacao());

        return dto;
    }

    @Override
    public NotaDTO getNotaById(Long id) {
        Nota nota = notaRepository.findById(id).orElseThrow();

        NotaDTO dto = new NotaDTO();
        dto.setId(nota.getId());
        dto.setAlunoId(nota.getAluno().getId());
        dto.setDisciplinaId(nota.getDisciplina().getId());
        dto.setNota1(nota.getNota1());
        dto.setNota2(nota.getNota2());
        dto.setMedia(nota.getMedia());
        dto.setSituacao(nota.getSituacao());

        return dto;
    }

    @Override
    public List<NotaDTO> getAllNotas() {
        return notaRepository.findAll().stream().map(nota -> {
            NotaDTO dto = new NotaDTO();
            dto.setId(nota.getId());
            dto.setAlunoId(nota.getAluno().getId());
            dto.setDisciplinaId(nota.getDisciplina().getId());
            dto.setNota1(nota.getNota1());
            dto.setNota2(nota.getNota2());
            dto.setMedia(nota.getMedia());
            dto.setSituacao(nota.getSituacao());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void deleteNota(Long id) {
        notaRepository.deleteById(id);
    }
}
