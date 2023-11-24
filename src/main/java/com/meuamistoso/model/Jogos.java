/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.meuamistoso.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 *
 * @author Henrique
 */
public class Jogos {
    private int id;
    public String nomeDoOrganizador;
    public String localDoJogo;
    @JsonFormat(pattern = "dd/MM/yyyy")
    public String dataDoJogo;
    public int numeroDeJogadores;
    public String descricao;

    // Construtor padrão vazio exigido por Jackson
    public Jogos() {}

    //Cria construtor com todos os parametros, mas sem descricao
    public Jogos(int id, String nomeDoOrganizador, String localDoJogo, String dataDoJogo, int numeroDeJogadores ) {
        this.id = id;
        this.nomeDoOrganizador = nomeDoOrganizador;
        this.localDoJogo = localDoJogo;
        this.dataDoJogo = dataDoJogo;
        this.numeroDeJogadores = numeroDeJogadores;   
        this.descricao = "Nenhuma";
    }

    //Cria construtor com todos os parametros e a descricao
    public Jogos(int id, String nomeDoOrganizador, String localDoJogo, String dataDoJogo2, int numeroDeJogadores, String descricao) {
        this.id = id;
        this.nomeDoOrganizador = nomeDoOrganizador;
        this.localDoJogo = localDoJogo;
        this.dataDoJogo = dataDoJogo2;
        this.numeroDeJogadores = numeroDeJogadores;
        this.descricao = descricao;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeDoOrganizador() {
        return nomeDoOrganizador;
    }

    public void setNomeDoOrganizador(String nomeDoOrganizador) {
        this.nomeDoOrganizador = nomeDoOrganizador;
    }

    public String getLocalDoJogo() {
        return localDoJogo;
    }

    public void setLocalDoJogo(String localDoJogo) {
        this.localDoJogo = localDoJogo;
    }

    public String getDataDoJogo() {
        return dataDoJogo;
    }

    public void setDataDoJogo(String dataDoJogo) {
        this.dataDoJogo = dataDoJogo;
    }

    public int getNumeroDeJogadores() {
        return numeroDeJogadores;
    }

    public void setNumeroDeJogadores(int numeroDeJogadores) {
        this.numeroDeJogadores = numeroDeJogadores;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
 
}
