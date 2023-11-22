package main.java.com.meuamistoso.controller;

import main.java.com.meuamistoso.dao.JogosDAO;
import main.java.com.meuamistoso.model.Jogos;

public class CriarJogoController {
    public void criarJogo(String stringId, String nomeDoOrganizador, String localDoJogo, String dataDoJogo, String stringNumeroDeJogadores, String descricao) {
        // Importar texto dos campos
        int idJogo = Integer.parseInt(stringId);
        int numeroDeJogadores = Integer.parseInt(stringNumeroDeJogadores);

        // Criar novo jogo
        Jogos jogos = new Jogos(idJogo, nomeDoOrganizador, localDoJogo, dataDoJogo, numeroDeJogadores, descricao);
        // Insere um novo jogo no banco de dados
        new JogosDAO().insert(jogos);
    }
}
