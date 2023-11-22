package com.meuamistoso.controller;

import com.meuamistoso.dao.JogosDAO;
import com.meuamistoso.model.Jogos;

public class CriarJogoController {

    public Jogos obterModelo() {
        // Importar texto dos campos
        // String stringId = 
        // int idJogo = Integer.parseInt(stringId);
        // String nomeDoOrganizador = view.getNomeDoOrganizador().getText();
        // String localDoJogo = view.getLocalDoJogo().getText();
        // String dataDoJogo = view.getDataDoJogo().getText();
        // String stringNumeroDeJogadores = view.getNumeroDeJogadores().getText();
        // int numeroDeJogadores = Integer.parseInt(stringNumeroDeJogadores);
        // String descricao = view.getDescricao().getText();

        // Criar novo jogo
        // Jogos jogos = new Jogos(idJogo, nomeDoOrganizador, localDoJogo, dataDoJogo, numeroDeJogadores, descricao);
        // return jogos;
    }

    public void criarJogo() {
        Jogos jogos = obterModelo();

        // Insere um novo jogo no banco de dados
        new JogosDAO().insert(jogos);
    }
}
