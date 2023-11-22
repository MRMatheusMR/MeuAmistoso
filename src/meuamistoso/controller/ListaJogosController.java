package meuamistoso.controller;

import meuamistoso.dao.JogosDAO;
import meuamistoso.model.Jogos;
import meuamistoso.view.ListaJogos;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;



public class ListaJogosController {
    
    private final ListaJogos view;
    
    public ListaJogosController(ListaJogos view) {
        this.view = view;
    }
     
    public void listarJogos(ArrayList<Jogos> jogos) {
        DefaultTableModel tablemodel = (DefaultTableModel) view.getTabelaJogos().getModel();
        tablemodel.setNumRows(0);

        //Preencher as listas com o table model
        for (Jogos jogo : jogos) {
            tablemodel.addRow(new Object[]{
                    jogo.getId(),
                    jogo.getNomeDoOrganizador(),
                    jogo.getLocalDoJogo(),
                    jogo.getDataFormatada(),
                    jogo.getNumeroDeJogadores(),
                    jogo.getDescricao()
            });
        }
    }
    
    public void atualizarTabela() {
        //Buscar Lista de Jogos no banco de dados
        JogosDAO jogosDAO = new JogosDAO();
        ArrayList<Jogos> jogos = jogosDAO.selectAll();
        listarJogos(jogos);
    }
    

}
