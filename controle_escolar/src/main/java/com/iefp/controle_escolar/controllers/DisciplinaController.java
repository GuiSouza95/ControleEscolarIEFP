package com.iefp.controle_escolar.controllers;

import com.iefp.controle_escolar.dtos.DisciplinaDTO;
import com.iefp.controle_escolar.services.DisciplinaService;
import com.iefp.controle_escolar.services.SessionService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/disciplinas")
@RequiredArgsConstructor
public class DisciplinaController {

    private final SessionService sessionService;
    private final DisciplinaService disciplinaService;

    @GetMapping
    public String listar(HttpSession session, Model model, @RequestParam(required = false) String nome) {

        sessionService.session(session, model);
        List<DisciplinaDTO> disciplinas;

        if (nome != null && !nome.isEmpty()) {
            disciplinas =  disciplinaService.listarPorNome(nome);
        } else {
            disciplinas =  disciplinaService.listarTodos();
        }

        model.addAttribute("disciplinas", disciplinas);
        model.addAttribute("disciplina", new DisciplinaDTO());
        model.addAttribute("nome", nome);

        return "disciplina";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("disciplina") DisciplinaDTO disciplina) {

        disciplinaService.salvar(disciplina);
        return "redirect:/disciplinas";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        disciplinaService.excluirById(id);
        return "redirect:/disciplinas";
    }
}