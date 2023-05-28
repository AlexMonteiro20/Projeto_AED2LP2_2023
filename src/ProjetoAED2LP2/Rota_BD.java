package ProjetoAED2LP2;

import Implementacoes.BST_AED2;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Rota_BD implements Rota_I{
    private BST_AED2<Integer, Rota> bst_rotas = new BST_AED2<>();
    private int num_rotas;
    private final Date data = new Date();

    //GETS E SETS
    public BST_AED2<Integer, Rota> getBst_rotas() {
        return bst_rotas;
    }
    public void setBst_rotas(BST_AED2<Integer, Rota> bst_rotas) {
        this.bst_rotas = bst_rotas;
    }
    public int getNum_rotas() {
        return num_rotas;
    }
    public void setNum_rotas(int num_rotas) {
        this.num_rotas = num_rotas;
    }

    public Date getData() {
        return data;
    }



    public void addText_rotas(String mensagem, Date data, String file) {

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

    //Método para inserir um user
    @Override
    public void inserir_rota(Rota rota) {
        rota.setId_rota(num_rotas);
        bst_rotas.put(num_rotas,rota);
        num_rotas++;
        String toRotas = "Foi adicionada uma rota com ID: " + rota.getId_rota();
        addText_rotas(toRotas, data, "Data/Info");
    }

    //Método para remover um user recebido por parametro
    @Override
    public void remove_rota(Integer idRota) throws Rota_Exception {
        if(bst_rotas.contains(idRota)){
            bst_rotas.delete(idRota);
            String toRotas =  "Foi removida a rota com ID: " + idRota;
            addText_rotas(toRotas, data,"Data/Info");
        }
        throw new Rota_Exception("A Rota nao existe!\n");
    }

    //Método para verificar se o user recebido por paramnetro existe ou nao
    @Override
    public boolean verificar_rota(Integer idRota) {
        return bst_rotas.contains(idRota);
    }

    //Método para editar um determinado user
    @Override
    public boolean editar_rota(int id_rota, ArrayList<Ligacao> ligacaos) {
        if (bst_rotas.get(id_rota)!=null){
            bst_rotas.get(id_rota).setLigacoes(ligacaos);
            return true;
        }
        return false;
    }

    //Método para guardar todos os users num ficheiro
    @Override
    public void guardar_rota(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Data/Rotas.txt"))) {
            Collection<Rota> rotas  = bst_rotas.values();
            for (Rota rota : rotas) {
                String linha = "ID_ROTA: " + rota.getId_rota() ;
                writer.write(linha);
                writer.newLine();
            }
            System.out.println("Rotas salvas no arquivo com sucesso.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar as rotas no arquivo: " + e.getMessage());
        }
    }

    //Método para listar todos os users do ficheiro
    @Override
    public void listar_ligacoes() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Data/Rotas.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] campos = linha.split(", ");
                if (campos.length == 8) {
                    int idRota = Integer.parseInt(campos[0].substring(4));
                    //int id_estacao_a = Integer.parseInt(campos[2].substring(6));
                    //int id_estacao_b = Integer.parseInt(campos[4].substring(13));
                    //int id_transporte = Integer.parseInt(campos[6].substring(13));
                    //Estacao_BD estacao_bd = new Estacao_BD();
                    //Transporte_BD transporte_bd = new Transporte_BD();
                    //Estacao estacao_a = estacao_bd.encontrarEstacaoPorId(id_estacao_a);
                    //Estacao estacao_b = estacao_bd.encontrarEstacaoPorId(id_estacao_b);
                    //Transporte transporte_utilizado = transporte_bd.encontrarTransportePorId(id_transporte);
                    //Ligacao ligacao = new Ligacao(idLigacao,estacao_a,estacao_b,transporte_utilizado);
                    //bst_ligacoes.put(idLigacao, ligacao);
                }
            }
            System.out.println("Rotas carregadas do arquivo com sucesso.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler as rotas do arquivo: " + e.getMessage());
        }
    }
}
