package com.meuamistoso.model;

import java.util.ArrayList;

import com.meuamistoso.dao.Banco;
import com.meuamistoso.dao.JogosDAO;

public class JogosService {

    private JogosDAO jogosDAO;

    public JogosService(JogosDAO jogosDAO) {
        this.jogosDAO = jogosDAO;
    }

    public String insert(Jogos jogos) {
        // Inicia banco de dados
        if (Banco.jogos == null) {
            Banco.inicia();
        }
        
        // Verifica se já existe um jogo no mesmo local e data
        System.out.println(jogoExistente(jogos));
        if (jogoExistente(jogos)) {
            // throw new IllegalArgumentException("Já existe um jogo no mesmo local e data.");
            return "Ja existe um jogo no mesmo local e data.";
        } else {
            // Verifica se o ID já existe, se sim, obtém o próximo ID disponível
            int novoId = obterProximoId();
            jogos.setId(novoId);
            
            jogosDAO.insert(jogos);

            return "Jogo criado com sucesso!";
        }
    }

    public ArrayList<Jogos> selectAll() {
        return jogosDAO.selectAll();
    }

    private int obterProximoId() {
        int maiorId = 0;
    
        for (Jogos jogo : Banco.jogos) {
            if (jogo.getId() > maiorId) {
                maiorId = jogo.getId();
            }
        }
    
        // Retorna o próximo ID disponível (maior ID + 1)
        return maiorId + 1;
    }

    /**
     * Verifica se já existe um jogo no mesmo local e data
     * @param novoJogo
     * @return true se já existe um jogo no mesmo local e data, false caso contrário
     */
    private boolean jogoExistente(Jogos novoJogo) {
        for (Jogos jogo : Banco.jogos) {
            if (jogo.getLocalDoJogo().equals(novoJogo.getLocalDoJogo()) && jogo.getDataDoJogo().equals(novoJogo.getDataDoJogo())) {
                return true;
            }
        }
        return false;
    }

}

