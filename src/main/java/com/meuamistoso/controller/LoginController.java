package com.meuamistoso.controller;

import com.meuamistoso.dao.UsuarioDAO;
import com.meuamistoso.model.Usuario;

public class LoginController {
    //Valida o Login
     public void logarNoSistema(String email, String senha) {
        Usuario usuario = new Usuario(0, email, senha);
        //Verifica no Banco de Dados
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioAutenticado = usuarioDAO.selectPorEmailESenha(usuario);
        
        //Direcionar para a Tela Principal caso esteja cadastrado
        if (usuarioAutenticado != null) {
            System.out.print("Usuario foi logado no sistema");
        } else {
            System.out.println("Usuario nao autenticado");
        }
    }

}
