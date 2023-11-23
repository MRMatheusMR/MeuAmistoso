package com.meuamistoso.controller;

import com.meuamistoso.dao.JogosDAO;
import com.meuamistoso.model.Jogos;
import java.util.ArrayList;



public class ListaJogosController {
    public ArrayList<Jogos> getJogos() {
        //Buscar Lista de Jogos no banco de dados
        JogosDAO jogosDAO = new JogosDAO();
        return jogosDAO.selectAll();
        // listarJogos(jogos);
    }
}
