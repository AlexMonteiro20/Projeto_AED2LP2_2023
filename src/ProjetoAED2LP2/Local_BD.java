package ProjetoAED2LP2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Date;

public class Local_BD implements Local_I {
    private HashMap<Integer, Local> map_local = new HashMap<>();
    private int ref_local  = 1;
    private final Date data = new Date();

    //GETS E SETS LOCAL_BD
    public HashMap<Integer, Local> getMap_local() {
        return map_local;
    }
    public void setMap_local(HashMap<Integer, Local> map_local){this.map_local = map_local;}
    public int getRef_local() {
        return ref_local;
    }
    public void setRef_local(int ref_local) {
        this.ref_local = ref_local;
    }

    //METODO PARA ADICIONAR TEXTO RELATIVO AOS LOCAIS AO FICHEIRO
    public void addText_local(String mensagem, Date data, String file){

        int k=0;
        In Infile = new In(file);
        String[] allLines =  Infile.readAllLines();
        Out Outfile = new Out(file);


        while (allLines.length>k){
            Outfile.println(allLines[k]);
            k++;
        }
        Outfile.println(mensagem + ", na data de: " + data);
    }

    //METODO PARA INSERIR UM LOCAL
    @Override
    public boolean inserir_local(Local local) {
        local.setId_local(ref_local);
        map_local.put(ref_local,local);
        ref_local++;
        String toLocal = "Foi adicionado um novo Local: " + local.getId_local();
        addText_local(toLocal, data, "C:\\Users\\Alex\\Documents\\JavaProjects\\Projeto_AED2LP2\\src\\Data\\Info");
        return true;
    }

    //METODO PARA REMOVER UM LOCAL
    @Override
    public boolean remover_local(Integer id_local) throws Local_Exception {
        if(map_local.containsKey(id_local)){
            map_local.remove(id_local);
            String toLocal = "Foi removido o local com id:" + id_local;
            addText_local(toLocal, data, "C:\\Users\\Alex\\Documents\\JavaProjects\\Projeto_AED2LP2\\src\\Data\\Info");
            return true;
        }
        throw new Local_Exception("O Local que quer remover nao existe");
    }

    //METODO PARA VERIFICAR A EXISTENCIA DE UM LOCAL
    @Override
    public boolean verificar_local(Integer id_local) {
        return map_local.containsKey(id_local);
    }

    //METODO PARA EDITAR UM DETERMINADO LOCAL
    @Override
    public boolean editar_local(Integer id_local, String nome_local, int x_local, int y_local) {
        if (map_local.get(id_local) != null){
            map_local.get(id_local).setLocal_name(nome_local);
            map_local.get(id_local).setLocal_x(x_local);
            map_local.get(id_local).setLocal_y(y_local);
            return true;
        }
        return false;
    }

    public Local encontrarLocalPorId(int idLocal){
        return map_local.get(idLocal);
    }

    //METODO PARA GUARDAR TODOS OS LOCAIS NUM FICHEIRO
    @Override
    public void guardarLocaisEmArquivo() {
        try (FileWriter writer = new FileWriter("C:\\Users\\Alex\\Documents\\JavaProjects\\Projeto_AED2LP2\\src\\Data\\Locais", false)) {
            for (Local local : map_local.values()) {
                String linha = "ID: " + local.getId_local() + "," + "NOME: " + local.getLocal_name() + ", COORDENADA X: " + local.getLocal_x() + ", COORDENADA Y: " + local.getLocal_y();
                writer.write(linha + "\n");
            }
            System.out.println("Locais salvos no arquivo com sucesso.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar os locais no arquivo: " + e.getMessage());
        }
    }

    //METODO PARA LISTAR TODOS OS LOCAIS DO FICHEIRO
    @Override
    public void listarLocaisDeArquivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Alex\\Documents\\JavaProjects\\Projeto_AED2LP2\\src\\Data\\Locais"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] campos = linha.split(", ");
                if (campos.length == 8) {
                    int id_local = Integer.parseInt(campos[0].substring(4));
                    String nome_local = campos[2].substring(6);
                    int coordenadaX = Integer.parseInt(campos[4].substring(13));
                    int coordenadaY = Integer.parseInt(campos[6].substring(13));
                    Local local = new Local(id_local,nome_local,coordenadaX,coordenadaY);
                    map_local.put(id_local, local);
                }
            }
            System.out.println("Locais carregados do arquivo com sucesso.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler os locais do arquivo: " + e.getMessage());
        }
    }

}
