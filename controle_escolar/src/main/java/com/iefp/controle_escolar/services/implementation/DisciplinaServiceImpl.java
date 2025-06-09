package com.iefp.controle_escolar.services.implementation;

import java.util.List;

import com.iefp.controle_escolar.mappers.DisciplinaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.iefp.controle_escolar.dtos.DisciplinaDTO;
import com.iefp.controle_escolar.entities.DisciplinaEntity;
import com.iefp.controle_escolar.repositories.DisciplinaRepository;
import com.iefp.controle_escolar.services.DisciplinaService;

@Service
@RequiredArgsConstructor
public class DisciplinaServiceImpl implements DisciplinaService{
        
    private final DisciplinaRepository repository;
    private final DisciplinaMapper mapper;

    @Override
    public List<DisciplinaDTO> listarTodos() {

        List<DisciplinaEntity> disciplinas = repository.findAll();
        return mapper.toDTOList(disciplinas);
    }

    @Override
    public List<DisciplinaDTO> listarPorNome(String nome) {

        List<DisciplinaEntity> disciplinas = repository.findByNomeContainingIgnoreCase(nome);
        return mapper.toDTOList(disciplinas);
    }

    @Override
    public DisciplinaDTO buscarPorId(Long id) {

        DisciplinaEntity turma = repository.findById(id).orElseThrow();
        return mapper.toDTO(turma);
    }

    @Override
    public void salvar(DisciplinaDTO dto) {

        DisciplinaEntity disciplina = mapper.toEntity(dto);
        repository.save(disciplina);
    }

    @Override
    public void excluirById(Long id) {
        repository.deleteById(id);
    }
}
