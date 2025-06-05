package com.iefp.controle_escolar.services;

import java.util.List;

import com.iefp.controle_escolar.DTO.NotaDTO;

public interface NotaService {
    NotaDTO createNota(NotaDTO notaDTO);
    NotaDTO getNotaById(Long id);
    List<NotaDTO> getAllNotas();
    void deleteNota(Long id);
}