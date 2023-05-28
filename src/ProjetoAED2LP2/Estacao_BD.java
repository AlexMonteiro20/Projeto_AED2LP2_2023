package ProjetoAED2LP2;

import Implementacoes.RedBlackTree;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

import java.io.*;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

public class Estacao_BD implements Estacao_I {
    private HashMap<Integer, Estacao> hm_estacoes = new HashMap<>();
    private int num_estacao;
    private final Date data = new Date();

    //gets & sets
    public HashMap<Integer, Estacao> getEstacoes() {
        return hm_estacoes;
    }

    public void setEstacoes(HashMap<Integer, Estacao> hm_estacoes) {
        this.hm_estacoes = hm_estacoes;
    }

    public void addText_estacao(String mensagem, Date data, String file) {

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
    public void inserir_estacao(Estacao estacao) {
        estacao.setId_local(num_estacao);
        hm_estacoes.put(num_estacao, estacao);
        num_estacao++;
        String toEstacoes = "Foi adicionada uma estacao: " + estacao;
        addText_estacao(toEstacoes, data, "Data/Info");
    }

    //Método para remover um user recebido por parametro
    @Override
    public void remove_estacao(Integer idEstacao) throws Estacao_Exception {
        if(hm_estacoes.containsKey(idEstacao)){
            String nome = hm_estacoes.get(idEstacao).getLocal_name();
            hm_estacoes.remove(idEstacao);
            String toEstacoes =  "Foi removida a Estacao: " + nome + " com id: " + idEstacao;
            addText_estacao(toEstacoes, data,"Data/Info");
        }
        throw new Estacao_Exception("A Estacao nao existe!\n");
    }

    //Método para verificar se o user recebido por paramnetro existe ou nao
    @Override
    public boolean verificar_estacao(Integer idUser) {
        return hm_estacoes.containsKey(idUser);
    }

    //Método para editar um determinado user
   @Override
    public boolean editar_estacao(int id_local, String local_name, int local_x, int local_y) {
        if (hm_estacoes.get(id_local)!=null){
            hm_estacoes.get(id_local).setLocal_name(local_name);
            hm_estacoes.get(id_local).setLocal_x(local_x);
            hm_estacoes.get(id_local).setLocal_y(local_y);
            return true;
        }
        return false;
    }

    public Estacao encontrarEstacaoPorId(int id) {
        return hm_estacoes.get(id);
    }

    //Método para guardar todos os users num ficheiro
    @Override
    public void guardar_estacao(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Data/Estacoes.txt"))) {
            Collection<Estacao> estacoes  = hm_estacoes.values();
            for (Estacao estacao : estacoes) {
                String linha = "ID: " + estacao.getId_local() + ", NOME: " + estacao.getLocal_name() + ",COORDENADA_X: " + estacao.getLocal_x() + ",COORDENADA_Y: " + estacao.getLocal_y();
                writer.write(linha);
                writer.newLine();
            }
            System.out.println("Estacoes salvas no arquivo com sucesso.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar as estacoes no arquivo: " + e.getMessage());
        }
    }

    //Método para listar todos os users do ficheiro
    @Override
    public void listar_estacoes() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Data/Estacoes.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] campos = linha.split(", ");
                if (campos.length == 8) {
                    int id_local = Integer.parseInt(campos[0].substring(4));
                    String nome_local = campos[2].substring(6);
                    int coordenadaX = Integer.parseInt(campos[4].substring(13));
                    int coordenadaY = Integer.parseInt(campos[6].substring(13));
                    Estacao estacao = new Estacao(id_local,nome_local,coordenadaX,coordenadaY);
                    hm_estacoes.put(id_local, estacao);
                }
            }
            System.out.println("Locais carregados do arquivo com sucesso.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler os locais do arquivo: " + e.getMessage());
        }
    }
}