package com.meuamistoso.controller;

import com.meuamistoso.dao.UsuarioDAO;
import com.meuamistoso.model.Usuario;
import com.meuamistoso.model.UsuarioService;

public class RegistroController {   
    //Registra um novo Usuario com os dados enviados
    public String registrarNoSistema(String nome, String email, String senha) {
        //Pega os dados inseridos na View
        Usuario usuario = new Usuario(0, email, senha, nome);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        UsuarioService usuarioService = new UsuarioService(usuarioDAO);

        return usuarioService.insert(usuario);
    }
}
