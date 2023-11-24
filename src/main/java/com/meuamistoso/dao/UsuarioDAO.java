package com.meuamistoso.dao;

import com.meuamistoso.model.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Henrique
 */
public class UsuarioDAO {
    
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

        Banco.usuario.add(usuario);
        
        return "Usuario registrado";
    }
    
    /**
     * Atualiza um Objeto no banco de dados
     * @param usuario
     * @return 
     */
    public boolean update(int i, Usuario usuario){

        Banco.usuario.set(i, usuario);
        return true;

    }
    
    /**
     * Deleta um objeto do banco de dados pelo id do usuario passado
     * @param usuario
     * @return 
     */
    public boolean delete(Usuario usuarioLista){

        Banco.usuario.remove(usuarioLista);
        return true;

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
    
}
