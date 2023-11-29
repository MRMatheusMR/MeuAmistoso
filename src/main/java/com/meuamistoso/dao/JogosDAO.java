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
