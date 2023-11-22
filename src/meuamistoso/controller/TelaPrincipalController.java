package meuamistoso.controller;

import meuamistoso.view.CriarJogo;
import meuamistoso.view.ListaJogos;
import meuamistoso.view.TelaPrincipal;

/**
 *
 * @author Henrique
 */
public class TelaPrincipalController {
    
    private final TelaPrincipal view;

    public TelaPrincipalController(TelaPrincipal view) {
        this.view = view;
    }
    // Funcao para abrir guia CriarJogo
    public void navegarParaCriarJogo() {
        CriarJogo criarJogo = new CriarJogo();
        criarJogo.setVisible(true);
    }
    // Funcao para abrir guia Lista de Jogos
    public void navegarParaListaJogos() {
        ListaJogos listaJogos = new ListaJogos();
        listaJogos.setVisible(true);
    }
}
