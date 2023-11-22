package meuamistoso.controller;

import meuamistoso.dao.UsuarioDAO;
import meuamistoso.model.Usuario;
import meuamistoso.view.Registro;



public class RegistroController {   
    private final Registro view;
    
    // Cria o controller da view Registro
    public RegistroController(Registro view) {
    this.view = view;    
    }
    
    public Usuario obterDados() {
        String nome = view.getCampoNomeRegistro().getText();
        String email = view.getCampoEmailRegistro().getText();
        String senha = view.getCampoSenhaRegistro().getText();
        return new Usuario(0, email, senha, nome);
    }

     public void setDados(Usuario modelo) {
        String nome = modelo.getNome();
        String email = modelo.getEmail();
        String senha = modelo.getSenha();
        view.getCampoNomeRegistro().setText(nome);
        view.getCampoEmailRegistro().setText(email);
        view.getCampoSenhaRegistro().setText(senha);
    }
     
     //Registra um novo Usuario com os dados da view
      public void registrarNoSistema() {
        //Pega os dados inseridos na View
        Usuario usuario = obterDados();
        new UsuarioDAO().insert(usuario);
    }
    
   
}
