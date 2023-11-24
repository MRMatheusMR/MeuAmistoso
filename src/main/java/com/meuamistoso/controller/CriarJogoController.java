package com.meuamistoso.controller;

import java.util.Date;

import com.meuamistoso.dao.JogosDAO;
import com.meuamistoso.model.Jogos;

public class CriarJogoController {

    public String criarJogo(int id, String nomeDoOrganizador, String localDoJogo, String dataDoJogo, int numeroDeJogadores, String descricao) {
        Jogos jogos = new Jogos(id, nomeDoOrganizador, localDoJogo, dataDoJogo, numeroDeJogadores, descricao);

        // Insere um novo jogo no banco de dados
        JogosDAO jogosDAO = new JogosDAO();

        System.out.println(jogos);

        return jogosDAO.insert(jogos);
    }

}
