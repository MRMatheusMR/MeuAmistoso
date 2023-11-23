package com.meuamistoso;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import com.meuamistoso.model.Jogos;

// Listar jogos
import com.meuamistoso.controller.ListaJogosController;

// Criar jogo
import com.meuamistoso.controller.CriarJogoController;

@SpringBootApplication
@RestController
public class JogoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JogoApplication.class, "--server.port=40125");
    }
    
    @PostMapping("/criarjogo")
    public String criaJogo(@RequestBody Jogos jogoRequest) {
        System.out.println("Endpoint: /criarjogo");
        System.out.println("Parâmetros recebidos: " + jogoRequest);

        
        
        return "Jogo criado com sucesso!";
    }

    @PostMapping("/login")
    public String login(@RequestBody String requestBody) {
        System.out.println("Endpoint: /login");
        System.out.println("Parâmetros recebidos: " + requestBody);
        return "Login realizado com sucesso!";
    }

    @GetMapping("/listarjogos")
    public ArrayList<Jogos> listarJogos() {
        ListaJogosController listajogos = new ListaJogosController();
        System.out.println("Endpoint: /listarjogos");   
        System.out.println(listajogos.getJogos());
        return listajogos.getJogos();
    }

    @PostMapping("/registrar")
    public String registrar(@RequestBody String requestBody) {
        System.out.println("Endpoint: /registrar");
        System.out.println("Parâmetros recebidos: " + requestBody);
        return "Registro realizado com sucesso!";
    }
}
