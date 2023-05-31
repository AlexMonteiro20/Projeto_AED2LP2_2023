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

    //GETS E SETS ROTA_BD
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


     //METODO PARA ADICIONAR TEXTO RELATIVO AS ROTAS AO FICHEIRO
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

    //METODO PARA INSERIR UMA ROTA
    @Override
    public void inserir_rota(Rota rota) {
        rota.setId_rota(num_rotas);
        bst_rotas.put(num_rotas,rota);
        num_rotas++;
        String toRotas = "Foi adicionada uma rota com ID: " + rota.getId_rota();
        addText_rotas(toRotas, data, "Data/Info");
    }

    //METODO PARA REMOVER UMA ROTA
    @Override
    public void remove_rota(Integer idRota) throws Rota_Exception {
        if(bst_rotas.contains(idRota)){
            bst_rotas.delete(idRota);
            String toRotas =  "Foi removida a rota com ID: " + idRota;
            addText_rotas(toRotas, data,"Data/Info");
        }
        throw new Rota_Exception("A Rota nao existe!\n");
    }

    //METODO PARA VERIFICAR A EXISTENCIA DE UMA ROTA
    @Override
    public boolean verificar_rota(Integer idRota) {
        return bst_rotas.contains(idRota);
    }

    //METODO PARA EDITAR UMA DETERMINADA ROTA
    @Override
    public boolean editar_rota(int id_rota, ArrayList<Ligacao> ligacaos) {
        if (bst_rotas.get(id_rota)!=null){
            bst_rotas.get(id_rota).setLigacoes(ligacaos);
            return true;
        }
        return false;
    }


    //METODO PARA GUARDAR TODAS AS ROTAS NUM FICHEIRO
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

    //METODO PARA LISTAR TODAS AS ROTAS DO FICHEIRO
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
