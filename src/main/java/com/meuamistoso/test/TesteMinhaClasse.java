package com.meuamistoso.test;

import com.meuamistoso.controller.CriarJogoController;
import com.meuamistoso.controller.ListaJogosController;
import com.meuamistoso.controller.LoginController;
import com.meuamistoso.controller.RegistroController;
import com.meuamistoso.dao.JogosDAO;
import com.meuamistoso.dao.UsuarioDAO;
import com.meuamistoso.model.Jogos;
import com.meuamistoso.model.Usuario;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class TesteMinhaClasse {

   @Test
    public void testCriarJogo() {
        // Cria uma instância do CriarJogoController
        CriarJogoController criarJogoController = new CriarJogoController();

        // Define valores de teste
        int id = 100;
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

    @Test
    public void testGetJogos() {
        // Cria uma instância do ListaJogosController
        ListaJogosController listaJogosController = new ListaJogosController();

        // Chama o método getJogos
        ArrayList<Jogos> jogos = listaJogosController.getJogos();

        // Verifica se a lista não é nula
        assertNotNull(jogos);

        // Adicione outras asserções conforme necessário, por exemplo, verifique se a lista não está vazia
        assertFalse(jogos.isEmpty());

        // Imprime os jogos (opcional)
        for (Jogos jogo : jogos) {
            System.out.println(jogo);
        }
    }

    @Test
    public void testLogarNoSistemaUsuarioAutenticado() {
        // Cria uma instância do LoginController
        LoginController loginController = new LoginController();

        // Define valores de teste
        String email = "usuario@teste.com";
        String senha = "senha123";

        // Chama o método logarNoSistema
        loginController.logarNoSistema(email, senha);

    }

    @Test
    public void testLogarNoSistemaUsuarioNaoAutenticado() {
        // Cria uma instância do LoginController
        LoginController loginController = new LoginController();

        // Define valores de teste para um usuário não autenticado
        String email = "usuario@naoautenticado.com";
        String senha = "senhaErrada";

        // Chama o método logarNoSistema
        loginController.logarNoSistema(email, senha);

    }

     @Test
    public void testRegistrarNoSistema() {
        // Cria uma instância do RegistroController
        RegistroController registroController = new RegistroController();

        // Define valores de teste
        String nome = "Novo Usuario";
        String email = "novo.usuario@teste.com";
        String senha = "senha123";

        // Chama o método registrarNoSistema
        registroController.registrarNoSistema(nome, email, senha);

        Usuario usuarioRegistrado = new UsuarioDAO().findByEmail(email);
        assertNotNull(usuarioRegistrado);
        assertEquals(nome, usuarioRegistrado.getNome());
        assertEquals(email, usuarioRegistrado.getEmail());
        assertEquals(senha, usuarioRegistrado.getSenha());
    }

}
