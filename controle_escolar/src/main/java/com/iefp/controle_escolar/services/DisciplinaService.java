package com.iefp.controle_escolar.services;

import java.util.List;

import com.iefp.controle_escolar.dtos.DisciplinaDTO;

public interface DisciplinaService {

    List<DisciplinaDTO> listarTodos();
    List<DisciplinaDTO> listarPorNome (String nome);
    DisciplinaDTO buscarPorId(Long id);
    void salvar(DisciplinaDTO dto);
    void excluirById(Long id);
}
