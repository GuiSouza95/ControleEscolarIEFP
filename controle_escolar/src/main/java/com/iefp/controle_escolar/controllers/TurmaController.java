package com.iefp.controle_escolar.controllers;

import com.iefp.controle_escolar.dtos.TurmaDTO;
import com.iefp.controle_escolar.services.SessionService;
import com.iefp.controle_escolar.services.TurmaService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/turmas")
@RequiredArgsConstructor
public class TurmaController {

    private final SessionService sessionService;
    private final TurmaService turmaService;

    @GetMapping
    public String listar(HttpSession session, Model model, @RequestParam(required = false) String nome) {

        sessionService.session(session, model);
        List<TurmaDTO> turmas;

        if (nome != null && !nome.isEmpty()) {
            turmas =  turmaService.listarPorNome(nome);
        } else {
            turmas =  turmaService.listarTodos();
        }

        model.addAttribute("turmas", turmas);
        model.addAttribute("turma", new TurmaDTO());
        model.addAttribute("nome", nome);

        return "turma";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("turma") TurmaDTO turma) {

        turmaService.salvar(turma);
        return "redirect:/turmas";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        turmaService.excluirById(id);
        return "redirect:/turmas";
    }
}