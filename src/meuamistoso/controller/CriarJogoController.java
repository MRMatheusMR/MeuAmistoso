package meuamistoso.controller;

import meuamistoso.dao.JogosDAO;
import meuamistoso.model.Jogos;
import meuamistoso.view.CriarJogo;



public class CriarJogoController {

    private final CriarJogo view;

    //Pega os aprametros da view Criar Jogo
    public CriarJogoController(CriarJogo view) {
        this.view = view;
    }

    public Jogos obterModelo() {
        // Importar texto dos campos
        String stringId = view.getIdJogo().getText();
        int idJogo = Integer.parseInt(stringId);
        String nomeDoOrganizador = view.getNomeDoOrganizador().getText();
        String localDoJogo = view.getLocalDoJogo().getText();
        String dataDoJogo = view.getDataDoJogo().getText();
        String stringNumeroDeJogadores = view.getNumeroDeJogadores().getText();
        int numeroDeJogadores = Integer.parseInt(stringNumeroDeJogadores);
        String descricao = view.getDescricao().getText();

        // Criar novo jogo
        Jogos jogos = new Jogos(idJogo, nomeDoOrganizador, localDoJogo, dataDoJogo, numeroDeJogadores, descricao);
        return jogos;
    }

    public void limparCampos() {
        view.getNomeDoOrganizador().setText("");
        view.getLocalDoJogo().setText("");
        view.getDataDoJogo().setText("");
        view.getNumeroDeJogadores().setText("");
        view.getDescricao().setText("");
    }

    public void criarJogo() {
        // Obtem objeto Jogos
        Jogos jogos = obterModelo();
        // Insere um novo jogo no banco de dados
        new JogosDAO().insert(jogos);
        limparCampos();
    }


}
