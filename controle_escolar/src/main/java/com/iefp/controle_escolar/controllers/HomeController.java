package com.iefp.controle_escolar.controllers;

import com.iefp.controle_escolar.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @Autowired
    private UsuarioService Usuarioservice;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("pageTitle", "Controle Escolar IEFP - Home");
        
        return "index";
    }

    @GetMapping("/dashboard_professor")
    public String dashboard_professor () {
        
        return "pages/dashboard_professor";
    }

    @GetMapping("/dashboard_aluno")
    public String dashboard_aluno (Model model) {

        return "pages/dashboard_aluno";
    }

    @GetMapping("/dashboard_administrador")
    public String mostrarDashboardAdmin(Model model) {
        model.addAttribute("usuarios", Usuarioservice.listarTodos());
        return "pages/dashboard_administrador";
    }
}