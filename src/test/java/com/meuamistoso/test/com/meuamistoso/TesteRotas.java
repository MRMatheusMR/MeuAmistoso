package com.meuamistoso.test.com.meuamistoso;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meuamistoso.model.Jogos;
import com.meuamistoso.model.Usuario;

@SpringBootTest
@AutoConfigureMockMvc
public class TesteRotas {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testCriaJogoEndpoint() throws Exception {
        // Cria um objeto Jogo para enviar no corpo da solicitação
        Date minhaData = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String minhaDataFormatada = formato.format(minhaData);
        Jogos jogo = new Jogos(8, "Organizador Teste", "Local Testeee", minhaDataFormatada, 11, "Descrição do Jogo");

        // Converte o objeto Jogo para uma string JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(jogo);

        // Realiza uma solicitação POST para o endpoint /criarjogo
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/criarjogo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andReturn();

        // Verifica se a resposta contém a mensagem esperada
        assertEquals("Jogo criado com sucesso!", result.getResponse().getContentAsString());
    }

    @Test
    public void testCriaJogoMesmoLocalEndpoint() throws Exception {
        // Cria um objeto Jogo para enviar no corpo da solicitação
        Jogos jogo = new Jogos(7, "Organizador Teste", "Quadra Anhembi Mooca", "08/07/2022", 11);

        // Converte o objeto Jogo para uma string JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(jogo);

        // Realiza uma solicitação POST para o endpoint /criarjogo
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/criarjogo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andReturn();

        // Verifica se a resposta contém a mensagem esperada
        assertEquals("Ja existe um jogo no mesmo local e data.", result.getResponse().getContentAsString());
    }

    @Test
    public void testListarJogosEndpoint() throws Exception {
        // Chama o endpoint /listarjogos
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/listarjogos")).andReturn();

        // Verifica o status da resposta (deve ser 200 OK)
        assertEquals(200, result.getResponse().getStatus());

          // Verifica se a resposta não está vazia
        String content = result.getResponse().getContentAsString();
        assertNotNull(content);
    }

    @Test
    public void testLoginEndpoint() throws Exception {
        // Cria um objeto Usuario para enviar no corpo da solicitação
        Usuario usuario = new Usuario(0,"email@teste.teste", "Senha@123");

        // Converte o objeto Usuario para uma string JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(usuario);

        System.out.println("Corpo da solicitação: " + requestBody);

        // Realiza uma solicitação POST para o endpoint /login
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andReturn();

        // Verifica se a resposta contém a mensagem esperada
        assertEquals("Usuario foi logado no sistema", result.getResponse().getContentAsString());
    }


    @Test
    public void testLoginEndpointUsuarioNaoCadastrado() throws Exception {
        // Cria um objeto Usuario para enviar no corpo da solicitação
        Usuario usuario = new Usuario(0,"usuarioNaoCadastrado@teste.com", "senha123");

        // Converte o objeto Usuario para uma string JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(usuario);

        // Realiza uma solicitação POST para o endpoint /login
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andReturn();

        // Verifica se a resposta contém a mensagem indicando que o login falhou
        assertEquals("Usuario nao autenticado", result.getResponse().getContentAsString());
    }

    @Test
    public void testRegistrarEndpoint() throws Exception {
        // Cria um objeto Usuario para enviar no corpo da solicitação
        Usuario usuario = new Usuario(0,"email@testeee.teste", "Senha@123", "NomeUsuario");

        // Converte o objeto Usuario para uma string JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(usuario);

        // Realiza uma solicitação POST para o endpoint /registrar
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/registrar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andReturn();

        // Verifica se a resposta contém a mensagem esperada
        assertEquals("Usuario registrado", result.getResponse().getContentAsString());
    }

    @Test
    public void testRegistrarMesmoUsernameEndpoint() throws Exception {
        // Cria um objeto Usuario para enviar no corpo da solicitação
        Usuario usuario = new Usuario(0,"email@testee.teste", "Senha@1234", "Teste"); // Teste é um username ja criado

        // Converte o objeto Usuario para uma string JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(usuario);

        // Realiza uma solicitação POST para o endpoint /registrar
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/registrar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andReturn();

        // Verifica se a resposta contém a mensagem esperada
        assertEquals("Usuario nao registrado", result.getResponse().getContentAsString());
    }

    @Test
    public void testRegistrarMesmoEmailEndpoint() throws Exception {
        // Cria um objeto Usuario para enviar no corpo da solicitação
        Usuario usuario = new Usuario(0,"email@teste.teste", "Senha@1234", "Testee"); // email@teste.teste é um username ja criado

        // Converte o objeto Usuario para uma string JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(usuario);

        // Realiza uma solicitação POST para o endpoint /registrar
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/registrar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andReturn();

        // Verifica se a resposta contém a mensagem esperada
        assertEquals("Usuario nao registrado", result.getResponse().getContentAsString());
    }

}
