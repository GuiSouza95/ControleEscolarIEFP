package com.iefp.controle_escolar.services.implementation;

import java.util.List;
import com.iefp.controle_escolar.mappers.TurmaMapper;
import lombok.RequiredArgsConstructor;

import com.iefp.controle_escolar.dtos.TurmaDTO;
import com.iefp.controle_escolar.entities.TurmaEntity;
import com.iefp.controle_escolar.repositories.TurmaRepository;
import com.iefp.controle_escolar.services.TurmaService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TurmaServiceImpl implements TurmaService {

    private final TurmaRepository repository;
    private final TurmaMapper mapper;

    @Override
    public List<TurmaDTO> listarTodos() {

        List<TurmaEntity> disciplinas = repository.findAll();
        return mapper.toDTOList(disciplinas);
    }

    @Override
    public List<TurmaDTO> listarPorNome(String nome) {

        List<TurmaEntity> turmas = repository.findByNomeContainingIgnoreCase(nome);
        return mapper.toDTOList(turmas);
    }

    @Override
    public TurmaDTO buscarPorId(Long id) {

        TurmaEntity turma = repository.findById(id).orElseThrow();
        return mapper.toDTO(turma);
    }

    @Override
    public void salvar(TurmaDTO dto) {

        TurmaEntity turma = mapper.toEntity(dto);
        repository.save(turma);
    }

    @Override
    public void excluirById(Long id) {
        repository.deleteById(id);
    }
}
