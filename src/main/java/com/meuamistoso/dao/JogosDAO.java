package com.meuamistoso.dao;

import com.meuamistoso.model.Jogos;
import java.util.ArrayList;

/**
 *
 * @author Henrique
 */
public class JogosDAO {
    
    
    /**
     * Insere um novo jogo dentro do banco de dados
     * @param jogos exige que seja passado um objeto do tipo jogos
     */
    public void insert(Jogos jogos) {
        // Inicia banco de dados
        if (Banco.jogos == null) {
            Banco.inicia();
        }
    
        Banco.jogos.add(jogos);
    
    }
    
    
    /**
     * Atualiza um Objeto no banco de dados
     * @param jogos
     * @param i
     * @param jogos
     * @return 
     */
    public boolean update(int i, Jogos jogos){
        Banco.jogos.set(i, jogos);
        return true;
    }
    
    /**
     * Deleta um objeto do banco de dados pelo id do jogo passado
     * @param jogos
     * @return 
     */
    public boolean delete(Jogos jogoslista){
        Banco.jogos.remove(jogoslista);
        return true;
    }
    
    /**
     * Retorna um arraylist com todos os jogos do banco de dados
     * @return uma lista com todos os registros do banco
     */
    public ArrayList<Jogos> selectAll(){
        
        // Inicia banco de dados
        if (Banco.jogos == null) {
            Banco.inicia();
        }
        
        return Banco.jogos;
    }

    public Jogos findById(int id) {
        for (Jogos jogo : Banco.jogos) {
            if (jogo.getId() == id) {
                return jogo;
            }
        }
        return null; // Retorna null se o jogo com o ID fornecido não for encontrado
    }
    
    
}
