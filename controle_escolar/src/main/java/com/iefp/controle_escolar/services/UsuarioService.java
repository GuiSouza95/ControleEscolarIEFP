package com.iefp.controle_escolar.services;

import com.iefp.controle_escolar.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<Usuario> listarTodos ();
    Optional<Usuario> buscarPorUsuario(String usuario);
    Optional<Usuario> buscarPorId(Long id);
    Usuario salvar(Usuario usuario);
    void registrarTentativaFalha(String usuario);
    void resetarTentativas(Usuario usuario);
    void excluirUsuario (Long id);
}
