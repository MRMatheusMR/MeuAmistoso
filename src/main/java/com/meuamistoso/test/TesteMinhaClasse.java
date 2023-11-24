package com.meuamistoso.test;

import com.meuamistoso.controller.CriarJogoController;
import com.meuamistoso.dao.JogosDAO;
import com.meuamistoso.model.Jogos;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.mockito.Mockito.*;

public class TesteMinhaClasse {

    @Test
    public void testeCriarJogo() {
        System.out.println("CHAMAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        // Criação de objetos simulados (mocks)
        JogosDAO jogosDAO = mock(JogosDAO.class);
        CriarJogoController criarJogoController = new CriarJogoController();
        criarJogoController.JogosDAO(jogosDAO); // Injeta o mock de JogosDAO

        // Dados de exemplo
        int id = 1;
        String nomeDoOrganizador = "Organizador";
        String localDoJogo = "Campo de Futebol";
        Date dataDoJogo = new Date();
        int numeroDeJogadores = 10;
        String descricao = "Jogo amistoso";

        // Executa o método a ser testado
        criarJogoController.criarJogo(id, nomeDoOrganizador, localDoJogo, dataDoJogo, numeroDeJogadores, descricao);

        // Verifica se o método insert da JogosDAO foi chamado corretamente
        verify(jogosDAO, times(1)).insert(any(Jogos.class));
    }
}
