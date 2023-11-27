package com.meuamistoso.test.com.meuamistoso;

import com.meuamistoso.controller.CriarJogoController;
import com.meuamistoso.controller.ListaJogosController;
import com.meuamistoso.controller.LoginController;
import com.meuamistoso.controller.RegistroController;
import com.meuamistoso.dao.JogosDAO;
import com.meuamistoso.dao.UsuarioDAO;
import com.meuamistoso.model.Jogos;
import com.meuamistoso.model.Usuario;
import com.meuamistoso.model.UsuarioService;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TesteControllers {

    @Test
    public void testCriarJogo() {
        // Cria uma instância do CriarJogoController
        CriarJogoController criarJogoController = new CriarJogoController();

        // Define valores de teste
        int id = 7; // colocar id valido 7 ou 8 - proximo id disponivel no banco de dados - id 7 criado no teste de rotas ao executar todos os testes
        String nomeDoOrganizador = "Organizador Teste";
        String localDoJogo = "Local Teste";
        Date minhaData = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String minhaDataFormatada = formato.format(minhaData);
        String dataDoJogo = minhaDataFormatada;
        int numeroDeJogadores = 11;
        String descricao = "Descrição do Jogo de Teste";

        // Chama o método criarJogo
        criarJogoController.criarJogo(id, nomeDoOrganizador, localDoJogo, dataDoJogo, numeroDeJogadores, descricao);

        // Verificações
        Jogos jogoCriado = new JogosDAO().findById(id);
        assertNotNull(jogoCriado);
        assertEquals(nomeDoOrganizador, jogoCriado.getNomeDoOrganizador());
        assertEquals(localDoJogo, jogoCriado.getLocalDoJogo());
        assertEquals(dataDoJogo, jogoCriado.getDataDoJogo());
        assertEquals(numeroDeJogadores, jogoCriado.getNumeroDeJogadores());
        assertEquals(descricao, jogoCriado.getDescricao());
    }

    @Test
    public void testCriarJogoMesmoLocal() {
        // Cria uma instância do CriarJogoController
        CriarJogoController criarJogoController = new CriarJogoController();

        // Define valores de teste
        int id = 7; // colocar id valido 7 ou 8 - proximo id disponivel no banco de dados - id 7 criado no teste de rotas ao executar todos os testes
        String nomeDoOrganizador = "Organizador Teste";
        String localDoJogo = "Quadra Anhembi Mooca";
        String minhaDataFormatada = "08/07/2022";
        String dataDoJogo = minhaDataFormatada;
        int numeroDeJogadores = 11;
        String descricao = "Descrição do Jogo de Teste";

        // Chama o método criarJogo
        String jogocriado = criarJogoController.criarJogo(id, nomeDoOrganizador, localDoJogo, dataDoJogo, numeroDeJogadores, descricao);
        assertEquals(jogocriado, "Ja existe um jogo no mesmo local e data.");
    }

    @Test
    public void testGetJogos() {
        // Cria uma instância do ListaJogosController
        ListaJogosController listaJogosController = new ListaJogosController();

        // Chama o método getJogos
        ArrayList<Jogos> jogos = listaJogosController.getJogos();

        // Verificações
        assertNotNull(jogos);
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
        String email = "email@teste.teste";
        String senha = "Senha@123";

        // Chama o método logarNoSistema
        String logado = loginController.logarNoSistema(email, senha);
        assertEquals(logado, "Usuario foi logado no sistema");
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
        String senha = "Senha@123";

        // Chama o método registrarNoSistema
        String registrado = registroController.registrarNoSistema(nome, email, senha);

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        Usuario usuarioRegistrado = new UsuarioService(usuarioDAO).findByEmail(email);

        // Verificações
        assertNotNull(usuarioRegistrado);
        assertEquals(nome, usuarioRegistrado.getNome());
        assertEquals(email, usuarioRegistrado.getEmail());
        assertEquals(senha, usuarioRegistrado.getSenha());
        assertEquals(registrado, "Usuario registrado");
    }

    @Test
    public void testRegistrarMesmoUsernameNoSistema() {
        // Cria uma instância do RegistroController
        RegistroController registroController = new RegistroController();

        // Define valores de teste
        String nome = "Teste";
        String email = "email@testee.teste";
        String senha = "Senha@123";

        // Chama o método registrarNoSistema
        String registrado = registroController.registrarNoSistema(nome, email, senha);


        // Verificações
        assertEquals(registrado, "Usuario nao registrado");
    }

    @Test
    public void testRegistrarMesmoEmailNoSistema() {
        // Cria uma instância do RegistroController
        RegistroController registroController = new RegistroController();

        // Define valores de teste
        String nome = "Testee";
        String email = "email@teste.teste";
        String senha = "Senha@123";

        // Chama o método registrarNoSistema
        String registrado = registroController.registrarNoSistema(nome, email, senha);

        // Verificações
        assertEquals(registrado, "Usuario nao registrado");
    }

}
