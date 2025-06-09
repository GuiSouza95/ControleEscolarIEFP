package com.iefp.controle_escolar.services;

import com.iefp.controle_escolar.dtos.TurmaDisciplinaDTO;

import java.util.List;

public interface TurmaDisciplinaService {

    List<TurmaDisciplinaDTO> listarTodos();
    void salvar(TurmaDisciplinaDTO dto);
    void excluirById(Long id);
}
