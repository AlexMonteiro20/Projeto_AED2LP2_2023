package ProjetoAED2LP2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

import java.io.*;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

public class Transporte_BD implements Transporte_I {
    private HashMap<Integer, Transporte> hm_transportes = new HashMap<>();
    private int num_transporte;
    private final Date data = new Date();

    //gets & sets
    public HashMap<Integer, Transporte> getHm_transportes() {
        return hm_transportes;
    }
    public void setHm_transportes(HashMap<Integer, Transporte> hm_transportes) {
        this.hm_transportes = hm_transportes;
    }
    public int getNum_transporte() {
        return num_transporte;
    }
    public void setNum_transporte(int num_transporte) {
        this.num_transporte = num_transporte;
    }

    public Date getData() {
        return data;
    }

    public void addText_transporte(String mensagem, Date data, String file) {

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
    public void inserir_transporte(Transporte transporte) {
        transporte.setId_transporte(num_transporte);
        hm_transportes.put(num_transporte, transporte);
        num_transporte++;
        String toTransportes = "Foi adicionada um transporte: " + transporte;
        addText_transporte(toTransportes, data, "Data/Info");
    }

    //Método para remover um user recebido por parametro
    @Override
    public void remove_transporte(Integer idTransporte) throws Transporte_Exception {
        if(hm_transportes.containsKey(idTransporte)){
            String nome = hm_transportes.get(idTransporte).getName_transporte();
            hm_transportes.remove(idTransporte);
            String toTransportes =  "Foi removido o Transporte: " + nome + " com id: " + idTransporte;
            addText_transporte(toTransportes, data,"Data/Info");
        }
        throw new Transporte_Exception("O transporte nao existe!\n");
    }

    //Método para verificar se o user recebido por paramnetro existe ou nao
    @Override
    public boolean verificar_transporte(Integer idTransporte) {
        return hm_transportes.containsKey(idTransporte);
    }

    //Método para editar um determinado user
    @Override
    public boolean editar_transporte(int id_transporte, String name_transporte) {
        if (hm_transportes.get(id_transporte)!=null){
            hm_transportes.get(id_transporte).setName_transporte(name_transporte);
            return true;
        }
        return false;
    }

    @Override
    public Transporte encontrarTransportePorId(int idTransporte) {
        return hm_transportes.get(idTransporte);
    }

    //Método para guardar todos os users num ficheiro
    @Override
    public void guardar_transportes(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Data/Transportes.txt"))) {
            Collection<Transporte> transportes  = hm_transportes.values();
            for (Transporte transporte : transportes) {
                String linha = "ID: " + transporte.getId_transporte() + ", NOME: " + transporte.getName_transporte() + ", CUSTO_TRANSPORTE: " + transporte.getCusto_transporte() + ", TEMPO_TRANSPORTE: " + transporte.getTempo_transporte();
                writer.write(linha);
                writer.newLine();
            }
            System.out.println("Transportes salvos no arquivo com sucesso.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar os transportes no arquivo: " + e.getMessage());
        }
    }

    //Método para listar todos os users do ficheiro
    @Override
    public void listar_transportes() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Data/Transportes.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] campos = linha.split(", ");
                if (campos.length == 8) {
                    int id_transporte = Integer.parseInt(campos[0].substring(4));
                    String nome_transporte = campos[2].substring(6);
                    int custo_transporte = Integer.parseInt(campos[4].substring(13));
                    int tempo_transporte = Integer.parseInt(campos[6].substring(13));
                    Transporte transporte = new Transporte(id_transporte,nome_transporte,custo_transporte,tempo_transporte);
                    hm_transportes.put(id_transporte, transporte);
                }
            }
            System.out.println("Transportes carregados do arquivo com sucesso.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler os transportes do arquivo: " + e.getMessage());
        }
    }
}
