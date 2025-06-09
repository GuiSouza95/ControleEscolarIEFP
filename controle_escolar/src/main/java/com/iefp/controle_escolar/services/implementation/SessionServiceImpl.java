package com.iefp.controle_escolar.services.implementation;

import com.iefp.controle_escolar.dtos.LoginResponseDTO;
import com.iefp.controle_escolar.services.SessionService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {

    @Override
    public void session(HttpSession session, Model model) {

        LoginResponseDTO userAuthenticated = (LoginResponseDTO) session.getAttribute("userAuthenticated");
        model.addAttribute("menuItems", userAuthenticated.getMenuItems());
        model.addAttribute("profile", userAuthenticated.getProfile());
        model.addAttribute("nickname", userAuthenticated.getNickname());
    }
}