package com.meuamistoso.controller;

import com.meuamistoso.dao.UsuarioDAO;
import com.meuamistoso.model.Usuario;

public class RegistroController {   
    //Registra um novo Usuario com os dados da view
    public String registrarNoSistema(String nome, String email, String senha) {
        //Pega os dados inseridos na View
        Usuario usuario = new Usuario(0, email, senha, nome);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.insert(usuario);
    }
}
