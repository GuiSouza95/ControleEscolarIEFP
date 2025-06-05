package com.iefp.controle_escolar.services;

import com.iefp.controle_escolar.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<Usuario> listarTodos ();
    Optional<Usuario> buscarPorUsername(String username);
    Optional<Usuario> buscarPorId(Long id);
    Usuario salvar(Usuario usuario);
    void registrarTentativaFalha(String username);
    void resetarTentativas(Usuario usuario);
    void excluirUsuario (Long id);
}
