package com.iefp.controle_escolar.controllers;

import com.iefp.controle_escolar.entities.Role;
import com.iefp.controle_escolar.services.implementation.RoleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleServiceImpl roleService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("roles", roleService.listarTodos());
        return "role/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("role", new Role());
        return "role/formulario";
    }

    @PostMapping
    public String salvar(@ModelAttribute Role role) {
        roleService.salvar(role);
        return "redirect:/roles";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("role", roleService.buscarPorId(id).orElseThrow());
        return "role/formulario";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        roleService.excluir(id);
        return "redirect:/roles";
    }
}
