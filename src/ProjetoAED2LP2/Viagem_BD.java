package ProjetoAED2LP2;

import Implementacoes.BST_AED2;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Viagem_BD implements Viagem_I{
    private BST_AED2<Integer, Viagem> bst_viagens = new BST_AED2<>();
    private int num_viagens;
    private final Date data = new Date();

    //GETS E SETS
    public BST_AED2<Integer, Viagem> getBst_viagens() {
        return bst_viagens;
    }
    public void setBst_viagens(BST_AED2<Integer, Viagem> bst_viagens) {
        this.bst_viagens = bst_viagens;
    }
    public int getNum_viagens() {
        return num_viagens;
    }
    public void setNum_viagens(int num_viagens) {
        this.num_viagens = num_viagens;
    }

    public Date getData() {
        return data;
    }



    public void addText_viagens(String mensagem, Date data, String file) {

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
    public void inserir_viagem(Viagem viagem) {
        viagem.setId_Viagem(num_viagens);
        bst_viagens.put(num_viagens,viagem);
        num_viagens++;
        String toViagens = "Foi adicionada uma viagem com ID: " + viagem.getId_Viagem();
        addText_viagens(toViagens, data, "Data/Info");
    }

    //Método para remover um user recebido por parametro
    @Override
    public void remove_viagem(Integer idViagem) throws Viagem_Exception {
        if(bst_viagens.contains(idViagem)){
            bst_viagens.delete(idViagem);
            String toViagens =  "Foi removida a viagem com ID: " + idViagem;
            addText_viagens(toViagens, data,"Data/Info");
        }
        throw new Viagem_Exception("A Viagem nao existe!\n");
    }

    //Método para verificar se o user recebido por paramnetro existe ou nao
    @Override
    public boolean verificar_viagem(Integer idViagem) {
        return bst_viagens.contains(idViagem);
    }

    //Método para editar um determinado user
    @Override
    public boolean editar_viagem(int id_viagem, ) {
        if (bst_viagens.get(id_viagem)!=null){
            bst_viagens.get(id_viagem).setLocal_partida();
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
                String linha = "ID_ROTA: " + rota.getId_rota() + ", PRECO_ROTA: " + rota.getPreco() + ", TEMPO_ROTA_HORA: " + rota.getTempo().getHora() + ", TEMPO_ROTA_MINUTOS: " + rota.getTempo().getMinutos() + ", NUM_PARAGENS: " + rota.getParagens() + ", ID_VIAGEM_ASSOCIADA:  " + rota.getViagem().getId_Viagem();
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
    public void listar_rotas() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Data/Rotas.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] campos = linha.split(", ");
                if (campos.length == 12) {
                    int idRota = Integer.parseInt(campos[0].substring(4));
                    float preco_rota = Integer.parseInt(campos[2].substring(6));
                    int rota_horas = Integer.parseInt(campos[4].substring(13));
                    int rota_minutos = Integer.parseInt(campos[6].substring(13));
                    int num_paragens = Integer.parseInt(campos[8].substring(13));
                    int id_viagem = Integer.parseInt(campos[10].substring(13));
                    Horario horario_rota = new Horario(rota_horas,rota_minutos);
                    Viagem_BD viagemBd = new Viagem_BD();
                    Viagem viagem =  viagemBd.encontrarViagemPorId(id_viagem);
                    Rota rota = new Rota(idRota,preco_rota,horario_rota,num_paragens,viagem);
                    bst_rotas.put(idRota, rota);
                }
            }
            System.out.println("Rotas carregadas do arquivo com sucesso.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler as rotas do arquivo: " + e.getMessage());
        }
    }
}
