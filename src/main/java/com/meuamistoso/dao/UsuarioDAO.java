package com.meuamistoso.dao;

import com.meuamistoso.model.Jogos;
import com.meuamistoso.model.Usuario;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Henrique
 */
public class UsuarioDAO {
    
    /**
     * Insere um usuario dentro do banco de dados
     * @param usuario exige que seja passado um objeto do tipo usuario
     */
    public void insert(Usuario usuario){

        // Inicia banco de dados
        if (Banco.usuario == null) {
            Banco.inicia();
        }

        // Verifica se a senha atende aos critérios
        if (!validarSenha(usuario.getSenha())) {
            System.out.println("A senha não atende aos critérios de segurança.");
            return;
        }

        // Verifica se já existe um usuario com mesmo username
        if (usernameExistente(usuario)) {
            System.out.println("Já existe um jogo no mesmo local e data.");
            return;
        }

        Banco.usuario.add(usuario);
    }
    
    /**
     * Atualiza um Objeto no banco de dados
     * @param usuario
     * @return 
     */
    public boolean update(Usuario usuario){

        for (int i = 0; i < Banco.usuario.size(); i++) {
            if(idSaoIguais(Banco.usuario.get(i),usuario)){
                Banco.usuario.set(i, usuario);
                return true;
            }
        }
        return false;      

    }
    
    /**
     * Deleta um objeto do banco de dados pelo id do usuario passado
     * @param usuario
     * @return 
     */
    public boolean delete(Usuario usuario){
        for (Usuario usuarioLista : Banco.usuario) {
            if(idSaoIguais(usuarioLista,usuario)){
                Banco.usuario.remove(usuarioLista);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Retorna um arraylist com todos os usuarios do banco de dados
     * @return uma lista com todos os registros do banco
     */
    public ArrayList<Usuario> selectAll(){
        // Inicia banco de dados
        if (Banco.jogos == null) {
            Banco.inicia();
        }

        return Banco.usuario;
    }
    
    /**
     * Retorna um Objeto do tipo usuario se a funcao encontrar o usuario passado como parâmetro no banco, para considerar sao usado nome e senha
     * @param usuario
     * @return Usuario encontrado no banco de dados
     */
    public Usuario selectPorEmailESenha(Usuario usuario){

        // Inicia banco de dados
        if (Banco.usuario == null) {
            Banco.inicia();
        }

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
     * Compara se dois objetos tem a propriedade id igual
     * @param usuario
     * @param usuarioAComparar
     * @return verdadeiro caso os id forem iguais e falso se nao forem
     */
    private boolean idSaoIguais(Usuario usuario, Usuario usuarioAComparar) {
        return usuario.getId() ==  usuarioAComparar.getId();
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
