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

    public boolean update(Jogos jogos) {
        for (int i = 0; i < Banco.jogos.size(); i++) {
            if(idIguais(Banco.jogos.get(i),jogos)){
                jogosDAO.update(i,jogos);
                return true;
            }
        }
        return false;    
    }

    public boolean delete(Jogos jogos) {

        // Inicia banco de dados
        if (Banco.jogos == null) {
            Banco.inicia();
        }

        for (Jogos jogosLista : Banco.jogos) {
            if(idIguais(jogosLista,jogos)){
                jogosDAO.delete(jogosLista);
            }
        }
        return false;
    }

    public ArrayList<Jogos> selectAll() {
        return jogosDAO.selectAll();
    }

    public Jogos findById(int id) {
        return jogosDAO.findById(id);
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
     * Compara se dois objetos tem a propriedade id igual
     * @param jogos
     * @param jogosAMarcar
     * @return verdadeiro caso os id forem iguais e falso se nao forem
     */
    private boolean idIguais(Jogos jogos, Jogos jogosAMarcar) {
        return jogos.getId() ==  jogosAMarcar.getId();
    }

    /**
     * Verifica se já existe um jogo no mesmo local e data
     * @param novoJogo
     * @return true se já existe um jogo no mesmo local e data, false caso contrário
     */
    private boolean jogoExistente(Jogos novoJogo) {
        for (Jogos jogos : Banco.jogos) {
            if (jogos.getLocalDoJogo().equals(novoJogo.getLocalDoJogo()) && jogos.getDataDoJogo().equals(novoJogo.getDataDoJogo())) {
                return true;
            }
        }
        return false;
    }
}

