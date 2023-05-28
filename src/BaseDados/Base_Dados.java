package BaseDados;

import ProjetoAED2LP2.Local;


import ProjetoAED2LP2.User;
import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import Implementacoes.RedBlackTree;

import java.io.*;
import java.util.*;

//public class Base_Dados implements Base_Dados_I {
    //LOCAIS
   /*
    public void addText(String mensagem, Date data, String file){

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

    private HashMap<Integer, Local> map_local = new HashMap<>();
    private int ref_local  = 1;
    private final Base_Dados locais = new Base_Dados();
    private final Date data = new Date();
    //private final Date data = new Date();

    //Gets & Sets
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


    //Método para inserir um novo local
    @Override
    public boolean inserir_local(Local local) {
        local.setId_local(ref_local);
        map_local.put(ref_local,local);
        ref_local++;
        String toLocal = "Foi adicionado um novo Local: " + local.getId_local();
        locais.addText(toLocal, data, "Data/Info");
        return true;
    }

    //Método para remover um local
    @Override
    public boolean remover_local(Integer id_local) throws LocalNaoExiste {
        if(map_local.containsKey(id_local)){
            map_local.remove(id_local);
            String toLog = "Foi removido o ponto de interesse com id:" + id_poi;
            locais.addText(toLog, data, "Data/Info");
            return true;
        }
        throw new LocalNaoExiste("O Local que quer remover nao existe");
    }

    //Método para verificar se existe ou não um determinado local
    @Override
    public boolean verificar_local(Integer id_local) {
        return map_local.containsKey(id_local);
    }


    //Método para guardar todos os Locais existentes num ficheiro
    @Override
    private void guardarLocaisEmArquivo() {
        try (FileWriter writer = new FileWriter("Data/Locais.txt", false)) {
            for (Local local : map_local.values()) {
                String linha = "ID: " + local.getId_local() + "," + "NOME: " + local.getLocal_name() + ", COORDENADA X: " + local.getLocal_x() + ", COORDENADA Y: " + local.getLocal_y();
                writer.write(linha + "\n");
            }
            System.out.println("Locais salvos no arquivo com sucesso.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar os locais no arquivo: " + e.getMessage());
        }
    }

    //Método para listar os Locais do
    @Override
    public void listarLocaisDeArquivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Data/Locais.txt"))) {
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


    //USERS
    private RedBlackTree<Integer, User> rb_users = new RedBlackTree<>();
    private int num_users;
    private final Base_Dados users = new Base_Dados();
    //gets & sets
    public RedBlackTree<Integer, User> getUsers(){ return rb_users; }

    public void setUsers(RedBlackTree<Integer, User> users){ this.rb_users = rb_users; }


    //Método para inserir um user
    @Override
    public void inserir_user(User user) {
        user.setUser_id(num_users);
        rb_users.put(num_users,user);
        num_users++;
        String toUsers = "Foi adicionado: " + user;
        users.addText(toUsers, data, "Data/Info");
    }

    //Método para remover um user recebido por parametro
    @Override
    public void remove_user(Integer idUser) throws UserNaoExiste {
        if(rb_users.contains(idUser)){
            String nome = rb_users.get(idUser).getUser_name();
            rb_users.delete(idUser);
            String toUsers =  "Foi removido o user: " + nome + " com id: " + idUser;
            users.addText(toUsers, data,"Data/Info");
        }
        throw new UserNaoExiste("O user nao existe\n");
    }

    //Método para verificar se o user recebido por paramnetro existe ou nao
    @Override
    public boolean verificar_user(Integer idUser) {
        return rb_users.contains(idUser);
    }

    //Método para editar um determinado user
    @Override
    public boolean editar_user(Integer idUser, String nome) {
        if (rb_users.get(idUser)!=null){
            rb_users.get(idUser).setUser_name(nome);
            return true;
        }
        return false;
    }

    //Método para guardar todos os users num ficheiro
    @Override
    public void guardar_user(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Data/Users.txt"))) {
            Collection<User> users = rb_users.values();
            for (User user : users) {
                String linha = "ID: " + user.getUser_id() + ", NOME: " + user.getUser_name();
                writer.write(linha);
                writer.newLine();
            }
            System.out.println("Usuários salvos no arquivo com sucesso.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar os usuários no arquivo: " + e.getMessage());
        }
    }

    //Método para listar todos os users do ficheiro
    @Override
    public void listar_user() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Data/Users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Process each line and extract key-value pairs
                String[] fields = line.split(",");
                if (fields.length == 2) {
                    int id = Integer.parseInt(fields[0].trim());
                    String name = fields[1].trim();
                    User user = new User(id,name);
                    rb_users.put(id, user);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    //Método para imprimir todos os pontos de interesse ja visitados
    public void Estacoes_Visitadas(int user_id){
        for (int i=0; getUsers().get(user_id).getNumPoI_Visit().size() > i; i++){
            System.out.println(getUsers().get(user_id).getNumPoI_Nvisit().get(i).getId_poi());
        }
    }
}
    /*
    //Método que retorna todos os Users que visitaram determinado PoI
    public ArrayList<User> Users_Visit_PoI(PoI poi){
        ArrayList<User> usr = new ArrayList<>();
        for (int i=0; users.size()>= i;i++){
            int j=0;
            while (users.get(i).getNumPoI_Visit().size()>j){
                if (users.get(i).getNumPoI_Visit().get(j).getId_poi().equals(poi.id_poi)){
                    usr.add(users.get(i));
                }
                j++;
            }
        }
        return usr;
    }


    //Método para saber o top 5 de users com mais pontos de interesse visitados
    public void top5_Users(Date inicio, Date fim){
        ArrayList<User> usr = new ArrayList<>();
        ArrayList<Integer> poi_visit = new ArrayList<>();
        int aux=1;
        for (int i=0; getUsers().size()>=i; i++){
            if (getUsers().get(aux)!=null){
                int count_visit = PoI_Visitadas_1User(getUsers().get(aux).getUser_id());
                if (poi_visit.isEmpty()){
                    poi_visit.add(count_visit);
                    usr.add(getUsers().get(aux));
                }else { //se ja estiver algo no array vamos comparar cada posicao com o atual
                    for (int j=1; j<poi_visit.size(); i++){
                        if (poi_visit.get(j) < count_visit){

                            if (poi_visit.size() == j+1){
                                poi_visit.add(poi_visit.get(j));
                                usr.add(usr.get(j));
                            }else {
                                for (int k= poi_visit.size(); k<j; k--){
                                    if (k== poi_visit.size()){
                                        poi_visit.add(poi_visit.get(k-1));
                                        usr.add(usr.get(k-1));
                                    }else {
                                        poi_visit.set(k, poi_visit.get(k-1));
                                        usr.set(k, usr.get(k-1));
                                    }
                                }
                            }
                            usr.set(j, getUsers().get(aux));
                            poi_visit.set(j,count_visit);
                            j=poi_visit.size();
                        }
                        else if (j==poi_visit.size()-1){
                            poi_visit.add(count_visit);
                            usr.add(getUsers().get(aux));
                            j= poi_visit.size();
                        }
                    }
                }

            }
            aux++;
        }
        System.out.println("O top 5 de utilizadores com mais PoI's visitados sao");
        for (int l=0; l<5; l++){
            System.out.println(usr.get(l).getUser_nome() + " visitou no total : " + usr.get(l).getNumPoI_Visit() + " PoI's");
        }
    }

    //Método que nos diz o número total de PoI já visitados por um User
    public int PoI_Visitadas_1User(int id){
        if (users.get(id) != null){
            users.get(id).getNumPoI_Visit().printInOrder(users.get(id).getNumPoI_Visit().getRoot());
        }

        return id;
    }

    //Método para imprimir todos os pontos de interesse que ainda nao foram visitados por um User
    public void PoI_NaoVisitados_1User(Base_Dados pbd, int id){
        int count = 0, j=0;
        for (int i=0; pbd.getMap_poi().size()>= i; i++){
            while (users.get(id).getNumPoI_Visit().size()>j){
                if (pbd.getMap_poi().get(i).getId_poi().equals(users.get(id).getNumPoI_Visit().get(j).getId_poi()))
                    count++;
                j++;
            }
            if (count==0)
                System.out.println(pbd.getMap_poi().get(i).toString());
            count=0;
        }
    }

    //Método para ver todos os PoI nao visitados/
    public void Users_Nvisit_PoI(Base_Dados pbd, int id){
        int count = 0, j=0;
        for (int i=0; pbd.getMap_poi().size()>=i;i++){
            if (pbd.getMap_poi().get(i).getId_poi().equals(users.get(id).getNumPoI_Visit().get(j).getId_poi())){
                count++;
            }
            j++;
            if (count==0){
                System.out.println(pbd.getMap_poi().get(i).toString());
            }
            count=0;
        }
    }

    @Override
    public String toString() {
        return "Users_Base_Dados{" +
                "users=" + users +
                ", num_users=" + num_users +
                ", logs=" + logs +
                ", data=" + data +
                '}';
    }
}
}*/
