package com.meuamistoso.controller;

import com.meuamistoso.dao.UsuarioDAO;
import com.meuamistoso.model.Usuario;
import com.meuamistoso.model.UsuarioService;

public class LoginController {
    //Valida o Login
     public String logarNoSistema(String email, String senha) {
        Usuario usuario = new Usuario(0, email, senha);
        //Verifica no Banco de Dados
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        UsuarioService usuarioService = new UsuarioService(usuarioDAO);
        Usuario usuarioAutenticado = usuarioService.selectPorEmailESenha(usuario);
        
        //Direcionar para a Tela Principal caso esteja cadastrado
        if (usuarioAutenticado != null) {
            return "Usuario foi logado no sistema";
        } else {
            return "Usuario nao autenticado";
        }
    }

}
