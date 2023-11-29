package com.meuamistoso;

import java.util.ArrayList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.meuamistoso.model.Jogos;
import com.meuamistoso.model.Usuario;
// Listar jogos
import com.meuamistoso.controller.ListaJogosController;
import com.meuamistoso.controller.LoginController;
import com.meuamistoso.controller.RegistroController;
// Criar jogo
import com.meuamistoso.controller.CriarJogoController;

@SpringBootApplication
@RestController
public class JogoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JogoApplication.class, "--server.port=40125");
    }
    
    @PostMapping("/criarjogo")
    public String criaJogo(@RequestBody String requestBody) {
        try {
            System.out.println("Endpoint: /criarjogo");
            System.out.println("Parâmetros recebidos: " + requestBody);

            // Converte a string JSON em um objeto Jogo
            ObjectMapper objectMapper = new ObjectMapper();
            Jogos jogos = objectMapper.readValue(requestBody, Jogos.class);

            // Acessando os atributos do objeto Jogo
            Integer id = jogos.getId();
            String nomeDoOrganizador = jogos.getNomeDoOrganizador();
            String localDoJogo = jogos.getLocalDoJogo();
            String dataDoJogo = jogos.getDataDoJogo();
            Integer numeroDeJogadores = jogos.getNumeroDeJogadores();
            String descricao = jogos.getDescricao();

            return CriarJogoController.criarJogo(id, nomeDoOrganizador, localDoJogo, dataDoJogo, numeroDeJogadores, descricao);

        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao processar a solicitação.";
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody String requestBody) {
        try {
            System.out.println("Endpoint: /login");
            System.out.println("Parâmetros recebidos: " + requestBody);
    
            // Converte a string JSON em um objeto Jogo
            ObjectMapper objectMapper = new ObjectMapper();
            Usuario usuario = objectMapper.readValue(requestBody, Usuario.class);
    
            // Acessando os atributos do objeto Jogo
            String email = usuario.getEmail();
            String senha = usuario.getSenha();
            
            return LoginController.logarNoSistema(email, senha);
    
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao processar a solicitação.";
        }
    }

    @GetMapping("/listarjogos")
    public ArrayList<Jogos> listarJogos() {
        System.out.println("Endpoint: /listarjogos");   
        System.out.println(ListaJogosController.getJogos());
        return ListaJogosController.getJogos();
    }

    @PostMapping("/registrar")
    public String registrar(@RequestBody String requestBody) {
        try {
            System.out.println("Endpoint: /registrar");
            System.out.println("Parâmetros recebidos: " + requestBody);
    
            // Converte a string JSON em um objeto Jogo
            ObjectMapper objectMapper = new ObjectMapper();
            Usuario usuario = objectMapper.readValue(requestBody, Usuario.class);
    
            // Acessando os atributos do objeto Jogo
            String nome = usuario.getNome();
            String email = usuario.getEmail();
            String senha = usuario.getSenha();
    
            return RegistroController.registrarNoSistema(nome, email, senha);
    
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao processar a solicitação.";
        }
    }

}
