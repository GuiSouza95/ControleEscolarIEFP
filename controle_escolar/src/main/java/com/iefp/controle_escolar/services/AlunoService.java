package com.iefp.controle_escolar.services;

import com.iefp.controle_escolar.entities.Aluno;

import java.util.List;
import java.util.Optional;

public interface AlunoService {

    List<Aluno> listarTodos();
    Aluno salvar(Aluno aluno);
    Optional<Aluno> buscarPorId(Long id);
    void excluir(Long id);
}
