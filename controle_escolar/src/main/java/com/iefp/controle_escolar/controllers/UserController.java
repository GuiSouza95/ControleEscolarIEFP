package com.iefp.controle_escolar.controllers;

import com.iefp.controle_escolar.dtos.RoleDTO;
import com.iefp.controle_escolar.dtos.UserDTO;
import com.iefp.controle_escolar.services.RoleService;
import com.iefp.controle_escolar.services.SessionService;
import com.iefp.controle_escolar.services.UsuarioService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UserController {

    private final SessionService sessionService;
    private final UsuarioService userService;
    private final RoleService roleService;

    @GetMapping
    public String listar(HttpSession session, Model model, @RequestParam(required = false) String nome) {

        sessionService.session(session, model);
        List<UserDTO> users;

        if (nome != null && !nome.isEmpty()) {
            users =  userService.listarPorNome(nome);
        } else {
            users =  userService.listarTodos();
        }

        List<RoleDTO> profiles = roleService.listarTodos();

        model.addAttribute("usuarios", users);
        model.addAttribute("usuario", new UserDTO());
        model.addAttribute("nome", nome);
        model.addAttribute("profiles", profiles);

        return "usuario";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("usuario") UserDTO user) {

        userService.salvar(user);
        return "redirect:/usuarios";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        userService.excluirById(id);
        return "redirect:/usuarios";
    }
}