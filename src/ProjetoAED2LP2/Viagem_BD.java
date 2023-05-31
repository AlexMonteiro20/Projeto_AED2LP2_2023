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

    //GETS E SETS VIAGENS_BD
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


    //METODO PARA ADICIONAR TEXTO RELATIVO AS VIAGENS AO FICHEIRO
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

    //METODO PARA INSERIR VIAGEM
    @Override
    public void inserir_viagem(Viagem viagem) {
        viagem.setId_Viagem(num_viagens);
        bst_viagens.put(num_viagens,viagem);
        num_viagens++;
        String toViagens = "Foi adicionada uma viagem com ID: " + viagem.getId_Viagem();
        addText_viagens(toViagens, data, "C:\\Users\\Alex\\Documents\\JavaProjects\\Projeto_AED2LP2\\src\\Data\\Info");
    }

    //METODO PARA REMOVER UMA VIAGEM
    @Override
    public void remove_viagem(Integer idViagem){ //throws Viagem_Exception {
        if(bst_viagens.contains(idViagem)){
            bst_viagens.delete(idViagem);
            String toViagens =  "Foi removida a viagem com ID: " + idViagem;
            addText_viagens(toViagens, data,"C:\\Users\\Alex\\Documents\\JavaProjects\\Projeto_AED2LP2\\src\\Data\\Info");
        }
//        throw new Viagem_Exception("A Viagem nao existe!\n");
    }

    //METODO PARA VERIFICAR A EXISTENCIA DE UMA VIAGEM
    @Override
    public boolean verificar_viagem(Integer idViagem) {
        return bst_viagens.contains(idViagem);
    }

    //METODO PARA EDITAR UMA DETERMINADA VIAGEM
    @Override
    public boolean editar_viagem(int id_viagem,Local local_partida) {
        if (bst_viagens.get(id_viagem)!=null){
            bst_viagens.get(id_viagem).setLocal_partida(local_partida);
            return true;
        }
        return false;
    }

    @Override
    public Viagem encontrarViagemPorId(Integer idViagem){
        return bst_viagens.get(idViagem);
    }

    //METODO PARA GUARDAR TODAS AS VIAGENS NUM FICHEIRO
    @Override
    public void guardar_viagens(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Alex\\Documents\\JavaProjects\\Projeto_AED2LP2\\src\\Data\\Viagens"))) {
            Collection<Viagem> viagens  = bst_viagens.values();
            for (Viagem viagem : viagens) {
                String linha = "ID_VIAGEM: " + viagem.getId_Viagem() + "LOCAL_PARTIDA: " + viagem.getLocal_partida().getLocal_name() + ", ID_LOCAL_PARTIDA: " + viagem.getLocal_partida().getId_local() + "LOCAL_DESTINO: " + viagem.getLocal_destino().getLocal_name() + "ID_LOCAL_DESTINO: " + viagem.getLocal_destino().getId_local()
                + "DATA_VIAGEM: " + viagem.getData_viagem().getYear() + ", " + viagem.getData_viagem().getMonth() + ", " + viagem.getData_viagem().getDay() + "HORA_INICIO: " + viagem.getHora_inicio().getHora() + ", " + viagem.getHora_inicio().getMinutos()+ "HORA_FIM: " + viagem.getHora_fim().getHora() + ", " + viagem.getHora_fim().getMinutos();
                writer.write(linha);
                writer.newLine();
            }
            System.out.println("Viagens salvas no arquivo com sucesso.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar as viagens no arquivo: " + e.getMessage());
        }
    }

    //METODO PARA LISTAR TODAS AS ROTAS DO FICHEIRO
    @Override
    public void listar_viagens() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Alex\\Documents\\JavaProjects\\Projeto_AED2LP2\\src\\Data\\Viagens"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] campos = linha.split(", ");
                if (campos.length == 15) {
                    int idViagem = Integer.parseInt(campos[0].substring(10));
                    int idLocalPartida = Integer.parseInt(campos[1].substring(16));
                    int idLocalDestino = Integer.parseInt(campos[3].substring(15));
                    int anoData = Integer.parseInt(campos[5].substring(13));
                    int mesData = Integer.parseInt(campos[6]);
                    int diaData = Integer.parseInt(campos[7]);
                    int hora_inicio_hora = Integer.parseInt(campos[9].substring(13));
                    int hora_inicio_minutos = Integer.parseInt(campos[10]);
                    int hora_fim_hora = Integer.parseInt(campos[12].substring(11));
                    int hora_fim_minutos = Integer.parseInt(campos[13]);
                    Date dataViagem = new Date(anoData, mesData, diaData);
                    Local_BD local_bd = new Local_BD();
                    Local localPartida = local_bd.encontrarLocalPorId(idLocalPartida);
                    Local localDestino = local_bd.encontrarLocalPorId(idLocalDestino);
                    Horario hora_inicio = new Horario(hora_inicio_hora, hora_inicio_minutos);
                    Horario hora_fim = new Horario(hora_fim_hora, hora_fim_minutos);
                    Rota_BD rota_bd = new Rota_BD();
                    ArrayList<Rota> rotas = (ArrayList<Rota>) rota_bd.getBst_rotas().values();
                    Viagem viagem = new Viagem(idViagem, localPartida, localDestino, dataViagem, hora_inicio, hora_fim, rotas);
                    bst_viagens.put(idViagem, viagem);
                }
            }
            System.out.println("Viagens carregadas do arquivo com sucesso.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler as viagens do arquivo: " + e.getMessage());
        }
    }
}
