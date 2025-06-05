package com.iefp.controle_escolar.services.implementation;

import com.iefp.controle_escolar.entities.Usuario;
import com.iefp.controle_escolar.repositories.UsuarioRepository;
import com.iefp.controle_escolar.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceimpl implements UsuarioService {

    private final UsuarioRepository repository;

    @Override
    public List<Usuario> listarTodos () {

        List<Usuario> usuarios;
        usuarios = repository.findAll();
        return usuarios;
    }

    @Override
    public Optional<Usuario> buscarPorUsername(String username) {
        return repository.findByUserName(username);
    }

    @Override
    public Optional<Usuario> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Usuario salvar(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    public void registrarTentativaFalha(String username) {
        Optional<Usuario> opt = repository.findByUserName(username);
        opt.ifPresent(usuario -> {
            int tentativas = usuario.getTentativas() + 1;
            usuario.setTentativas(tentativas);
            if (tentativas >= 5) {
                usuario.setStatus("BLOQUEADO");
            }
            repository.save(usuario);
        });
    }

    @Override
    public void resetarTentativas(Usuario usuario) {
        usuario.setTentativas(0);
        usuario.setStatus("ATIVO");
        repository.save(usuario);
    }

    @Override
    public void excluirUsuario (Long id) {

        repository.deleteById(id);

    }
}
