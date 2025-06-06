package com.iefp.controle_escolar.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CriptografiaUtil {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String criptografarSenha(String senha) {
        return encoder.encode(senha);
    }

    public static boolean verificarSenha(String senha, String hash) {
        return encoder.matches(senha, hash);
    }
}
