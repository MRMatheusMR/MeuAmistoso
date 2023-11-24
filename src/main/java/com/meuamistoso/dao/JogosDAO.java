package com.meuamistoso.dao;

import com.meuamistoso.model.Jogos;
import java.util.ArrayList;

/**
 *
 * @author Henrique
 */
public class JogosDAO {
    
    
    /**
     * Insere um novo jogo dentro do banco de dados
     * @param jogos exige que seja passado um objeto do tipo jogos
     */
    public void insert(Jogos jogos) {
        // Inicia banco de dados
        if (Banco.jogos == null) {
            Banco.inicia();
        }
    
        // Verifica se já existe um jogo no mesmo local e data
        if (jogoExistente(jogos)) {
            System.out.println("Já existe um jogo no mesmo local e data.");
            return;
        }
    
        // Verifica se o ID já existe, se sim, obtém o próximo ID disponível
        int novoId = obterProximoId();
        jogos.setId(novoId);
    
        Banco.jogos.add(jogos);
    }
    
    // Método para obter o próximo ID disponível
    private int obterProximoId() {
        int maiorId = 0;
    
        for (Jogos jogo : Banco.jogos) {
            if (jogo.getId() > maiorId) {
                maiorId = jogo.getId();
            }
        }
    
        // Retorna o próximo ID disponível (maior ID + 1)
        return maiorId + 1;
    }
    
    
    /**
     * Atualiza um Objeto no banco de dados
     * @param jogos
     * @return 
     */
    public boolean update(Jogos jogos){
        
        for (int i = 0; i < Banco.jogos.size(); i++) {
            if(idIguais(Banco.jogos.get(i),jogos)){
                Banco.jogos.set(i, jogos);
                return true;
            }
        }
        return false;      

    }
    
    /**
     * Deleta um objeto do banco de dados pelo id do jogo passado
     * @param jogos
     * @return 
     */
    public boolean delete(Jogos jogos){
        for (Jogos jogosLista : Banco.jogos) {
            if(idIguais(jogosLista,jogos)){
                Banco.jogos.remove(jogosLista);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Retorna um arraylist com todos os jogos do banco de dados
     * @return uma lista com todos os registros do banco
     */
    public ArrayList<Jogos> selectAll(){
        
        // Inicia banco de dados
        if (Banco.jogos == null) {
            Banco.inicia();
        }
        
        return Banco.jogos;
    }
    
    /**
     * Compara se dois objetos tem a propriedade id igual
     * @param jogos
     * @param jogosAMarcar
     * @return verdadeiro caso os id forem iguais e falso se nao forem
     */
    private boolean idIguais(Jogos jogos, Jogos jogosAMarcar) {
        return jogos.getId() ==  jogosAMarcar.getId();
    }

    /**
     * Verifica se já existe um jogo no mesmo local e data
     * @param novoJogo
     * @return true se já existe um jogo no mesmo local e data, false caso contrário
     */
    private boolean jogoExistente(Jogos novoJogo) {
        for (Jogos jogo : Banco.jogos) {
            if (jogo.getLocalDoJogo().equals(novoJogo.getLocalDoJogo()) && jogo.getDataDoJogo().equals(novoJogo.getDataDoJogo())) {
                return true;
            }
        }
        return false;
    }

    public Jogos findById(int id) {
        for (Jogos jogo : Banco.jogos) {
            if (jogo.getId() == id) {
                return jogo;
            }
        }
        return null; // Retorna null se o jogo com o ID fornecido não for encontrado
    }
    
    
}
