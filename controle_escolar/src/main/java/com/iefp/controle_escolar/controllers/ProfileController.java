package com.iefp.controle_escolar.controllers;

import com.iefp.controle_escolar.services.SessionService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ProfileController {

    private final SessionService sessionService;

    @GetMapping("/profile_administrator")
    public String dashboardAdmin(HttpSession session, Model model) {

        sessionService.session(session, model);
        return "profile_administrator";
    }

    @GetMapping("/profile_student")
    public String dashboardAluno (HttpSession session, Model model) {

        sessionService.session(session, model);
        return "profile_student";
    }

    @GetMapping("/profile_teacher")
    public String dashboardProfessor (HttpSession session, Model model) {

        sessionService.session(session, model);
        return "profile_teacher";
    }
}