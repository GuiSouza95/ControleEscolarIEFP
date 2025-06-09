package com.iefp.controle_escolar.services;

import java.util.List;

import com.iefp.controle_escolar.dtos.TurmaDTO;

public interface TurmaService {

    List<TurmaDTO> listarTodos();
    List<TurmaDTO> listarPorNome (String nome);
    TurmaDTO buscarPorId(Long id);
    void salvar(TurmaDTO dto);
    void excluirById(Long id);
}
