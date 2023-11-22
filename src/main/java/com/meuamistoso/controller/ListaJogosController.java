package main.java.com.meuamistoso.controller;

import main.java.com.meuamistoso.dao.JogosDAO;
import main.java.com.meuamistoso.model.Jogos;
import java.util.ArrayList;



public class ListaJogosController {
    public void atualizarTabela() {
        //Buscar Lista de Jogos no banco de dados
        JogosDAO jogosDAO = new JogosDAO();
        ArrayList<Jogos> jogos = jogosDAO.selectAll();
        System.out.println("Jogos listados com sucesso");
        // listarJogos(jogos);
    }
}
