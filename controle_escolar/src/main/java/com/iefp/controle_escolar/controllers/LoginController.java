package com.iefp.controle_escolar.controllers;

import com.iefp.controle_escolar.dtos.LoginRequestDTO;
import com.iefp.controle_escolar.dtos.LoginResponseDTO;
import com.iefp.controle_escolar.services.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class LoginController {

    @Autowired
    private LoginService service;

    @PostMapping ("/auth/login")
    public String login (@ModelAttribute("loginRequest") LoginRequestDTO loginRequest, Model model) {

        LoginResponseDTO response = service.loginValidation(loginRequest);

        if (response.isAuthenticated()) {
            model.addAttribute("aluno", response.getAluno());

            return response.getPerfil().equalsIgnoreCase("Professor")
                    ? "redirect:/dashboard_professor"
                    : "redirect:/dashboard_aluno";
        } else {
            model.addAttribute("error", response.getMessage());
            model.addAttribute("loginRequest", loginRequest);
            return "pages/login";
        }
    }

    @GetMapping("/auth/login")
    public String showLoginForm(Model model) {
        model.addAttribute("loginRequest", new LoginRequestDTO());
        return "pages/login";
    }
}
