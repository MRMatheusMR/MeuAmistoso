package main.java.com.meuamistoso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class JogoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JogoApplication.class, "--server.port=40125");
    }

    @PostMapping("/criajogo")
    public String criaJogo(@RequestBody String requestBody) {
        System.out.println("Endpoint: /criajogo");
        System.out.println("Parâmetros recebidos: " + requestBody);
        return "Jogo criado com sucesso!";
    }

    @PostMapping("/login")
    public String login(@RequestBody String requestBody) {
        System.out.println("Endpoint: /login");
        System.out.println("Parâmetros recebidos: " + requestBody);
        return "Login realizado com sucesso!";
    }

    @GetMapping("/listarjogos")
    public String listarJogos() {
        System.out.println("Endpoint: /listarjogos");
        return "Lista de jogos";
    }

    @PostMapping("/registrar")
    public String registrar(@RequestBody String requestBody) {
        System.out.println("Endpoint: /registrar");
        System.out.println("Parâmetros recebidos: " + requestBody);
        return "Registro realizado com sucesso!";
    }
}
