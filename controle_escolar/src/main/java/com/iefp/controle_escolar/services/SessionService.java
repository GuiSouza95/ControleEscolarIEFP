package com.iefp.controle_escolar.services;

import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;

public interface SessionService {

    void session(HttpSession session, Model model);
}