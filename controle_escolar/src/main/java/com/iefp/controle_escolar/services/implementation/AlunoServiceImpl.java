package com.iefp.controle_escolar.services.implementation;


import com.iefp.controle_escolar.repositories.AlunoRepository;
import com.iefp.controle_escolar.entities.Aluno;
import com.iefp.controle_escolar.services.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlunoServiceImpl implements AlunoService {

    private final AlunoRepository repository;

    @Override
    public List<Aluno> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Aluno salvar(Aluno aluno) {
        return repository.save(aluno);
    }

    @Override
    public Optional<Aluno> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
