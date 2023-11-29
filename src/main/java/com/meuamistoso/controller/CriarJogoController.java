package com.meuamistoso.controller;

import com.meuamistoso.dao.JogosDAO;
import com.meuamistoso.model.Jogos;
import com.meuamistoso.model.JogosService;

public class CriarJogoController {

    public static String criarJogo(int id, String nomeDoOrganizador, String localDoJogo, String dataDoJogo, int numeroDeJogadores, String descricao) {
        Jogos jogos = new Jogos(id, nomeDoOrganizador, localDoJogo, dataDoJogo, numeroDeJogadores, descricao);
        
        JogosDAO jogosDAO = new JogosDAO();
        
        JogosService jogosService = new JogosService(jogosDAO);
        
        // Insere um novo jogo no banco de dados
        return jogosService.insert(jogos);
    }

}
