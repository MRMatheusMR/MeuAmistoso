package com.meuamistoso.test;

import com.meuamistoso.controller.CriarJogoController;
import com.meuamistoso.dao.JogosDAO;
import com.meuamistoso.model.Jogos;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class TesteMinhaClasse {

   @Test
    public void testCriarJogo() {
        // Cria uma instância do CriarJogoController
        CriarJogoController criarJogoController = new CriarJogoController();

        // Define valores de teste
        int id = 1;
        String nomeDoOrganizador = "Organizador Teste";
        String localDoJogo = "Local Teste";
        Date dataDoJogo = new Date(); // Pode ajustar conforme necessário
        int numeroDeJogadores = 11;
        String descricao = "Descrição do Jogo de Teste";

        // Chama o método criarJogo
        criarJogoController.criarJogo(id, nomeDoOrganizador, localDoJogo, dataDoJogo, numeroDeJogadores, descricao);

        // Agora você pode realizar as asserções para verificar se o jogo foi inserido corretamente
        // por exemplo, pode criar um método de leitura na JogosDAO e verificar se o jogo está no banco de dados

        // Exemplo de asserções
        Jogos jogoCriado = new JogosDAO().findById(id);
        assertNotNull(jogoCriado);
        assertEquals(nomeDoOrganizador, jogoCriado.getNomeDoOrganizador());
        assertEquals(localDoJogo, jogoCriado.getLocalDoJogo());
        assertEquals(dataDoJogo, jogoCriado.getDataDoJogo());
        assertEquals(numeroDeJogadores, jogoCriado.getNumeroDeJogadores());
        assertEquals(descricao, jogoCriado.getDescricao());
    }
}
