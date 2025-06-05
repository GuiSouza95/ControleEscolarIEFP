package com.iefp.controle_escolar.controllers;

import com.iefp.controle_escolar.entities.Usuario;
import com.iefp.controle_escolar.services.implementation.RoleServiceImpl;
import com.iefp.controle_escolar.services.implementation.UsuarioServiceimpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioServiceimpl usuarioService;

    private final RoleServiceImpl roleService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("usuarios", usuarioService.listarTodos());
        return "usuario/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("roles", roleService.listarTodos());
        return "usuario/formulario";
    }

    @PostMapping
    public String salvar(@ModelAttribute Usuario usuario) {
        usuario.setDataCriacao(LocalDateTime.now());
        usuario.setDataAlteracao(LocalDateTime.now());
        usuarioService.salvar(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado: " + id));
        model.addAttribute("usuario", usuario);
        model.addAttribute("roles", roleService.listarTodos());
        return "usuario/formulario";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        usuarioService.excluirUsuario(id);
        return "redirect:/usuarios";
    }
}