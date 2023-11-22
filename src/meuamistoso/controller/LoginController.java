package meuamistoso.controller;

import meuamistoso.dao.UsuarioDAO;
import meuamistoso.model.Usuario;
import meuamistoso.view.Login;
import meuamistoso.view.Registro;
import meuamistoso.view.TelaPrincipal;



public class LoginController {

    private final Login view;

    // Cria o controller da view Login
    public LoginController(Login view){
        this.view = view;
    }
    
    public Usuario obterModelo(){
    //Pegar os dados da View
        String email = view.getCampoEmail().getText();
        String senha = view.getCampoSenha().getText();
        return new Usuario(0, email, senha);
    }
    
     public void setModelo(Usuario modelo) {
        String email = modelo.getEmail();
        String senha = modelo.getSenha();
        view.getCampoEmail().setText(email);
        view.getCampoSenha().setText(senha);
    }
     
     // Limpa os Campos
    public void clear(){
        view.getCampoEmail().setText("");
        view.getCampoSenha().setText("");
    }
    
    //Valida o Login
     public void logarNoSistema() {
        Usuario usuario = obterModelo();   
        //Verifica no Banco de Dados
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioAutenticado = usuarioDAO.selectPorEmailESenha(usuario);
        
        //Direcionar para a Tela Principal caso esteja cadastrado
        if (usuarioAutenticado != null) {
            TelaPrincipal menu = new TelaPrincipal();
            menu.setVisible(true);
            view.dispose();
        } else {
            view.exibirMensagem("Usuário ou Senha Incorretos!");
        }
    }
    
     public void abrirRegistro() {
        Registro registro = new Registro();
        registro.setVisible(true);
    }
    
    

}
