package com.meuamistoso.controller;

import com.meuamistoso.dao.UsuarioDAO;
import com.meuamistoso.model.Usuario;

public class RegistroController {   
    //Registra um novo Usuario com os dados da view
    public void registrarNoSistema(String nome, String email, String senha) {
        System.out.println("Usuario registrado");
        //Pega os dados inseridos na View
        Usuario usuario = new Usuario(0, email, senha, nome);
        new UsuarioDAO().insert(usuario);
    }
}
