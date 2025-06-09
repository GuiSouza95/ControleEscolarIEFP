package com.iefp.controle_escolar.controllers;

import com.iefp.controle_escolar.dtos.TurmaDisciplinaDTO;
import com.iefp.controle_escolar.services.*;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/turma-disciplinas")
@RequiredArgsConstructor
public class TurmaDisciplinaController {

    private final SessionService sessionService;
    private final TurmaDisciplinaService turmaDisciplinaService;
    private final TurmaService turmaService;
    private final DisciplinaService disciplinaService;
    private final UsuarioService usuarioService;

    @GetMapping
    public String listar(HttpSession session, Model model) {

        sessionService.session(session, model);

        model.addAttribute("lista", turmaDisciplinaService.listarTodos());
        model.addAttribute("turmas", turmaService.listarTodos());
        model.addAttribute("disciplinas", disciplinaService.listarTodos());
        model.addAttribute("professores", usuarioService.listarProfessores());

        return "turma_disciplina";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute TurmaDisciplinaDTO dto) {
        turmaDisciplinaService.salvar(dto);
        return "redirect:/turma-disciplinas";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        turmaDisciplinaService.excluirById(id);
        return "redirect:/turma-disciplinas";
    }
}