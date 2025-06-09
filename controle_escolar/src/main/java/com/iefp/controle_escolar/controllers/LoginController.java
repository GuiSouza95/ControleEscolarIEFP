package com.iefp.controle_escolar.controllers;

import com.iefp.controle_escolar.dtos.LoginRequestDTO;
import com.iefp.controle_escolar.dtos.LoginResponseDTO;
import com.iefp.controle_escolar.services.LoginService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService service;

    @GetMapping("/")
    public String index(Model model) {
        return "redirect:/auth/login";
    }

    @GetMapping("/auth/login")
    public String login(Model model) {
        model.addAttribute("loginRequest", new LoginRequestDTO());
        return "login";
    }

    @PostMapping ("/auth/login")
    public String login(HttpSession session,
                        Model model,
                        @ModelAttribute("loginRequest") LoginRequestDTO loginRequest) {

        LoginResponseDTO response = service.loginValidation(loginRequest);

        if (response.isAuthenticated()) {
            session.setAttribute("userAuthenticated", response);

            if ("Administrador".equalsIgnoreCase(response.getProfile())) {
                return "redirect:/profile_administrator";
            } else if ("Professor".equalsIgnoreCase(response.getProfile())) {
                return "redirect:/profile_teacher";
            }

            return "redirect:/profile_student";
        }

        model.addAttribute("error", response.getMessage());
        model.addAttribute("loginRequest", loginRequest);
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.setAttribute("userAuthenticated", null);
        return "redirect:/auth/login";
    }
}
