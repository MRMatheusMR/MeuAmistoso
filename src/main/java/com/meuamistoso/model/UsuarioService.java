package com.meuamistoso.model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.meuamistoso.dao.Banco;
import com.meuamistoso.dao.UsuarioDAO;

public class UsuarioService {

    private UsuarioDAO usuarioDAO;

    public UsuarioService(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    /**
     * Insere um usuario dentro do banco de dados
     * @param usuario exige que seja passado um objeto do tipo usuario
     * @return 
     */
    public String insert(Usuario usuario){

        // Inicia banco de dados
        if (Banco.usuario == null) {
            Banco.inicia();
        }

        // Verifica se a senha atende aos critérios
        if (!validarSenha(usuario.getSenha())) {
            System.out.println("A senha não atende aos critérios de segurança.");
            return "Usuario nao registrado";
        }

        // Verifica se já existe um usuario com mesmo username
        if (usernameExistente(usuario)) {
            System.out.println("Já existe um usuario com esse Username.");
            return "Usuario nao registrado";
        }

        // Verifica se já existe um usuario com mesmo email
        if (emailExistente(usuario)) {
            System.out.println("Já existe um usuario com esse Email.");
            return "Usuario nao registrado";
        }
        
        usuarioDAO.insert(usuario);

        return "Usuario registrado";
    }

    /**
     * Retorna um Objeto do tipo usuario se a funcao encontrar o usuario passado como parâmetro no banco, para considerar sao usado nome e senha
     * @param usuario
     * @return Usuario encontrado no banco de dados
     */
    public Usuario selectPorEmailESenha(Usuario usuario){

        for (Usuario usuarioLista : Banco.usuario) {
            if(emailESenhaSaoIguais(usuarioLista,usuario)){
                return usuarioLista;
            }
        }
        
        return null;
    }

        /**
     * Recebe dois objetos e verifica se são iguais verificando o nome e senha
     * @param usuario
     * @param usuarioAPesquisar
     * @return verdadeiro caso sejam iguais e falso caso nao forem iguais
     */
    private boolean emailESenhaSaoIguais(Usuario usuario, Usuario usuarioAPesquisar) {
        return usuario.getEmail().equals(usuarioAPesquisar.getEmail()) && usuario.getSenha().equals(usuarioAPesquisar.getSenha());
    }

    /**
     * Verifica se já existe um usuario com mesmo username
     * @param novoUsuario
     * @return true se já existe um usuario com mesmo username, false caso contrário
     */
    private boolean usernameExistente(Usuario novoUsuario) {
        for (Usuario usuario : Banco.usuario) {
            if (usuario.getNome().equals(novoUsuario.getNome())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica se já existe um usuario com mesmo email
     * @param novoUsuario
     * @return true se já existe um usuario com mesmo email, false caso contrário
     */
    private boolean emailExistente(Usuario novoUsuario) {
        for (Usuario usuario : Banco.usuario) {
            if (usuario.getEmail().equals(novoUsuario.getEmail())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Valida se a senha atende aos critérios especificados:
     * - Pelo menos 1 caractere especial
     * - Pelo menos 1 letra maiúscula
     * - Pelo menos 1 número
     * - Mínimo de 6 e máximo de 10 caracteres
     * @param senha A senha a ser validada
     * @return true se a senha for válida, false caso contrário
     */
    public boolean validarSenha(String senha) {
        String regex = "^(?=.*[!@#$%^&*(),.?\":{}|<>])(?=.*[A-Z])(?=.*[0-9]).{6,10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(senha);
        return matcher.matches();
    }

    public Usuario findByEmail(String email) {
        for (Usuario usuario : Banco.usuario) {
            if (usuario.getEmail() == email) {
                return usuario;
            }
        }
        return null; // Retorna null se o usuario com o Email fornecido não for encontrado
    }
}
