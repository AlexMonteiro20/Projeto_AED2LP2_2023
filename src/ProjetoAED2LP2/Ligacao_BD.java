package ProjetoAED2LP2;

import Implementacoes.BST_AED2;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;


import java.io.*;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

public class Ligacao_BD implements Ligacao_I{

    private BST_AED2<Integer, Ligacao> bst_ligacoes = new BST_AED2<>();
    private int num_ligacoes;
    private final Date data = new Date();

    //GETS E SETS LIGACAO_BD
    public BST_AED2<Integer, Ligacao> getBst_ligacoes() {
        return bst_ligacoes;
    }
    public void setBst_ligacoes(BST_AED2<Integer, Ligacao> bst_ligacoes) {
        this.bst_ligacoes = bst_ligacoes;
    }
    public int getNum_ligacoes() {
        return num_ligacoes;
    }

    public void setNum_ligacoes(int num_ligacoes) {
        this.num_ligacoes = num_ligacoes;
    }

    public Date getData() {
        return data;
    }

    //METODO PARA ADICIONAR TEXTO RELATIVO AS LIGACOES AO FICHEIRO
    public void addText_ligacoes(String mensagem, Date data, String file) {

        int k = 0;
        In Infile = new In(file);
        String[] allLines = Infile.readAllLines();
        Out Outfile = new Out(file);


        while (allLines.length > k) {
            Outfile.println(allLines[k]);
            k++;
        }
        Outfile.println(mensagem + ", na data de: " + data);
    }

    //METODO PARA INSERIR UMA LIGACAO
    @Override
    public void inserir_ligacao(Ligacao ligacao) {
        ligacao.setId_ligacao(num_ligacoes);
        bst_ligacoes.put(num_ligacoes, ligacao);
        num_ligacoes++;
        String toLigacoes = "Foi adicionada uma ligacao: " + ligacao;
        addText_ligacoes(toLigacoes, data, "Data/Info");
    }

    //METODO PARA REMOVER UMA LIGACAO
    @Override
    public void remove_ligacao(Integer idLigacao) throws Ligacao_Exception {
        if(bst_ligacoes.contains(idLigacao)){
            String estacao_a = bst_ligacoes.get(idLigacao).getEstacao_a().getLocal_name();
            String estacao_b = bst_ligacoes.get(idLigacao).getEstacao_b().getLocal_name();
            bst_ligacoes.delete(idLigacao);
            String toLigacoes =  "Foi removida a ligacao entre: " + estacao_a + " e " + estacao_b + ", com id: " + idLigacao;
            addText_ligacoes(toLigacoes, data,"Data/Info");
        }
        throw new Ligacao_Exception("A Ligacao nao existe!\n");
    }

    //METODO PARA VERIFICAR A EXISTENCIA DE UMA LIGACAO
    @Override
    public boolean verificar_ligacao(Integer idLigacao) {
        return bst_ligacoes.contains(idLigacao);
    }

    //METODO PARA EDITAR UMA DETERMINADA LIGACAO
    @Override
    public boolean editar_ligacao(int id_ligacao, Estacao estacao_a, Estacao estacao_b, Transporte transporte_utilizado) {
        if (bst_ligacoes.get(id_ligacao)!=null){
            bst_ligacoes.get(id_ligacao).setEstacao_a(estacao_a);
            bst_ligacoes.get(id_ligacao).setEstacao_b(estacao_b);
            bst_ligacoes.get(id_ligacao).setTransporte_utilizado(transporte_utilizado);
            return true;
        }
        return false;
    }

    //METODO PARA GUARDAR TODAS AS LIGACOES NUM FICHEIRO
    @Override
    public void guardar_ligacao(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Data/Ligacoes.txt"))) {
            Collection<Ligacao> ligacoes  = bst_ligacoes.values();
            for (Ligacao ligacao : ligacoes) {
                String linha = "ID_LIGACAO: " + ligacao.getId_ligacao() + ", ID_ESTACAO_A: " + ligacao.getEstacao_a().getId_local() + ", ID_ESTACAO_B: " + ligacao.getEstacao_b().getId_local() + ", ID_TRANSPORTE: " + ligacao.getTransporte_utilizado().getId_transporte();
                writer.write(linha);
                writer.newLine();
            }
            System.out.println("Ligacoes salvas no arquivo com sucesso.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar as ligacoes no arquivo: " + e.getMessage());
        }
    }

    //METODO PARA LISTAR TODAS AS LIGACOES DO FICHEIRO
    @Override
    public void listar_ligacoes() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Data/Ligacoes.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] campos = linha.split(", ");
                if (campos.length == 8) {
                    int idLigacao = Integer.parseInt(campos[0].substring(4));
                    int id_estacao_a = Integer.parseInt(campos[2].substring(6));
                    int id_estacao_b = Integer.parseInt(campos[4].substring(13));
                    int id_transporte = Integer.parseInt(campos[6].substring(13));
                    Estacao_BD estacao_bd = new Estacao_BD();
                    Transporte_BD transporte_bd = new Transporte_BD();
                    Estacao estacao_a = estacao_bd.encontrarEstacaoPorId(id_estacao_a);
                    Estacao estacao_b = estacao_bd.encontrarEstacaoPorId(id_estacao_b);
                    Transporte transporte_utilizado = transporte_bd.encontrarTransportePorId(id_transporte);
                    Ligacao ligacao = new Ligacao(idLigacao,estacao_a,estacao_b,transporte_utilizado);
                    bst_ligacoes.put(idLigacao, ligacao);
                }
            }
            System.out.println("Ligacoes carregadas do arquivo com sucesso.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler as ligacoes do arquivo: " + e.getMessage());
        }
    }

}
