package com.iefp.controle_escolar.controllers;

import com.iefp.controle_escolar.dtos.LoginRequestDTO;
import com.iefp.controle_escolar.dtos.LoginResponseDTO;
import com.iefp.controle_escolar.services.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class LoginController {

    private final LoginService service;

    @PostMapping("/auth/login")
    public String login (@ModelAttribute("loginRequest") LoginRequestDTO loginRequest, Model model) {

        LoginResponseDTO response = service.loginValidation(loginRequest);

        if (response.getAuthenticated()) {
            model.addAttribute("userAuthenticated", response);

            // Redireciona de acordo com o perfil
            if ("PROFESSOR".equalsIgnoreCase(response.getPerfil())) {
                return "redirect:/professorDashboard";
            } else {
                return "redirect:/alunoDashboard";
            }
        } else {
            model.addAttribute("error", response.getMessage());
            model.addAttribute("loginRequest", loginRequest);
            return "login";
        }
    }

    @GetMapping("/auth/login")
    public String showLoginForm(Model model) {
        model.addAttribute("loginRequest", new LoginRequestDTO());
        return "login";
    }
}
