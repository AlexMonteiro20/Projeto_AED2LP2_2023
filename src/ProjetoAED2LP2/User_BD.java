package ProjetoAED2LP2;

import ProjetoAED2LP2.Local;


import ProjetoAED2LP2.User;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import Implementacoes.RedBlackTree;

import java.io.*;
import java.util.*;
import java.util.Map;
import java.util.Map.Entry;

public class User_BD implements User_I {

    private RedBlackTree<Integer, User> rb_users = new RedBlackTree<>();
    private int num_users;
    private final Date data = new Date();

    //GETS E SETS USER_BD
    public RedBlackTree<Integer, User> getUsers(){ return rb_users; }

    public void setUsers(RedBlackTree<Integer, User> users){ this.rb_users = rb_users; }

    //METODO PARA ADICIONAR TEXTO RELATIVO AOS USERS AO FICHEIRO
    public void addText_user(String mensagem, Date data, String file){

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

    //METODO PARA INSERIR UM USER
    @Override
    public void inserir_user(User user) {
        user.setUser_id(num_users);
        rb_users.put(num_users,user);
        num_users++;
        String toUsers = "Foi adicionado um User com ID: " + user.getUser_id() + " e NOME: " + user.getUser_name();
        addText_user(toUsers, data, "C:\\Users\\Alex\\Documents\\JavaProjects\\Projeto_AED2LP2\\src\\Data\\Info");
    }

    //METODO PARA REMOVER UM USER
    //throws User_Exception
    //throw new User_Exception("O user nao existe\n")
    @Override
    public void remove_user(Integer idUser) {
        if(rb_users.contains(idUser)){
            String nome = rb_users.get(idUser).getUser_name();
            rb_users.delete(idUser);
            String toUsers =  "Foi removido o user: " + nome + " com id: " + idUser;
            addText_user(toUsers, data,"C:\\Users\\Alex\\Documents\\JavaProjects\\Projeto_AED2LP2\\src\\Data\\Info");
        }
    }

    //METODO PARA VERIFICAR A EXISTENCIA DE UM USER
    @Override
    public boolean verificar_user(Integer idUser) {
        return rb_users.contains(idUser);
    }

    //METODO PARA EDITAR UM DETERMINADO USER
    @Override
    public boolean editar_user(Integer idUser, String nome) {
        if (rb_users.get(idUser)!=null){
            rb_users.get(idUser).setUser_name(nome);
            return true;
        }
        return false;
    }

    //METODO PARA GUARDAR TODOS OS USERS NUM FICHEIRO
    @Override
    public void guardar_user(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Alex\\Documents\\JavaProjects\\Projeto_AED2LP2\\src\\Data\\Users"))) {
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

    //METODO PARA LISTAR TODOS OS USERS DO FICHEIRO
    @Override
    public void listar_users() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Alex\\Documents\\JavaProjects\\Projeto_AED2LP2\\src\\Data\\Users"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Process each line and extract key-value pairs
                String[] fields = line.split(",");
                if (fields.length == 2) {
                    String idString = fields[0].trim().split(": ")[1]; // Extrai o valor numérico do campo "ID"
                    int id = Integer.parseInt(idString);
                    String name = fields[1].trim();
                    User user = new User(id, name);
                    rb_users.put(id, user);
            }
        }
            System.out.println("Users carregados do arquivo com sucesso.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    //METODO QUE RETORNA TODAS AS ROTAS PLANEADAS E USADAS POR UM USER NUM DADO PERIODO
    @Override
    public ArrayList<Rota> Rotas_NumDadoPeriodo(int user_id, Date dataInicial, Date dataFinal){
        ArrayList<Viagem> viagens = getUsers().get(user_id).getViagens();
        ArrayList<Rota> rotasNoPeriodo = new ArrayList<>();

        for (Viagem viagem : viagens) {
            Date data = viagem.getData_viagem();
            if (data.compareTo(dataInicial) >= 0 && data.compareTo(dataFinal) <= 0) {
                ArrayList<Rota> rotasViagem = viagem.getRota();
                rotasNoPeriodo.addAll(rotasViagem);
            }
        }
        return rotasNoPeriodo;
    }

    //METODO QUE RETORNA TODAS AS ESTACOES NAO VISITADAS POR USERS NUM DADO PERIODO
    @Override
    public ArrayList<Estacao> Estacoes_NaoVisitadas(int user_id, Date dataInicial, Date dataFinal) {
        ArrayList<Viagem> viagens = getUsers().get(user_id).getViagens();
        ArrayList<Estacao> estacoesVisitadas = new ArrayList<>();
        ArrayList<Rota> rotas = new ArrayList<>();

        // Obter todas as rotas visitadas/usadas pelos usuários no período
        for (Viagem viagem : viagens) {
            Date data = viagem.getData_viagem();
            if (data.compareTo(dataInicial) >= 0 && data.compareTo(dataFinal) <= 0) {
                ArrayList<Rota> rotasViagem = viagem.getRota();
                rotas.addAll(rotasViagem);
            }
        }

        // Obter todas as estações visitadas/usadas pelas rotas
        for (Rota rota : rotas) {
            ArrayList<Ligacao> ligacoes = rota.getLigacoes();
                for (Ligacao ligacao : ligacoes) {
                    ArrayList<Estacao> estacoes = ligacao.getEstacoesLigacao();
                    estacoesVisitadas.addAll(estacoes);
                }
        }

        ArrayList<Estacao> estacoesNaoVisitadas = new ArrayList<>();

        Estacao_BD estacao_bd = new Estacao_BD();
        ArrayList<Estacao> Estacoes = (ArrayList<Estacao>) estacao_bd.getEstacoes().values();
        // Obter todas as estações disponíveis que não foram visitadas/usadas no período
        for (Estacao estacao : Estacoes) { // Supondo que exista um método getAllEstacoes() que retorna todas as estações disponíveis
            if (!estacoesVisitadas.contains(estacao)) {
                estacoesNaoVisitadas.add(estacao);
            }
        }
        return estacoesNaoVisitadas;
    }

    //METODO QUE RETORNA TODOS OS USERS QUE JA USARAM UMA ROTA QUE PASSA POR DETERMINADAS ESTACOES NUM DADO PERIODO
    @Override
    public ArrayList<User> usuariosComRotasPorEstacoesPeriodo(ArrayList<Estacao> estacoes, Date dataInicial, Date dataFinal) {
        ArrayList<User> usuarios = new ArrayList<>();
        Collection<User> users = rb_users.values();

        for (User user : users) {
            ArrayList<Viagem> viagens = user.getViagens();
            for (Viagem viagem : viagens) {
                Date data = viagem.getData_viagem();
                if (data.compareTo(dataInicial) >= 0 && data.compareTo(dataFinal) <= 0) {
                    ArrayList<Rota> rotas = viagem.getRota();
                    boolean rotaContemEstacoes = true;
                    for (Rota rota : rotas) {
                        for (Ligacao ligacao : rota.getLigacoes()) {
                            ArrayList<Estacao> estacoesLigacao = ligacao.getEstacoesLigacao();
                            for (Estacao estacao : estacoes) {
                                if (!estacoesLigacao.contains(estacao)) {
                                    rotaContemEstacoes = false;
                                    break;
                                }
                            }
                        }

                        if (rotaContemEstacoes) {
                            usuarios.add(user);
                            break;
                        }
                    }
                }
            }
        }

        return usuarios;
    }

    //METODO QUE RETORNA O TOP-3 DOS USERS QUE VISITARAM/USARAM O MAIOR NUMERO DE ESTACOES NUM DADO PERIODO
    @Override
    public ArrayList<User> Top3UsersMaiorNumStationsPeriodo(ArrayList<Estacao> estacoes, Date dataInicial, Date dataFinal) {
        ArrayList<User> usuarios = new ArrayList<>();
        Collection<User> users = rb_users.values();
        HashMap<User, Integer> Users_Contador = new HashMap<>();
        int visitCount = 0;

        for (User user : users) {
            ArrayList<Viagem> viagens = user.getViagens();
            for (Viagem viagem : viagens) {
                Date data = viagem.getData_viagem();
                if (data.compareTo(dataInicial) >= 0 && data.compareTo(dataFinal) <= 0) {
                    ArrayList<Rota> rotas = viagem.getRota();

                    for (Rota rota : rotas) {
                        for (Ligacao ligacao : rota.getLigacoes()) {
                            ArrayList<Estacao> estacoesLigacao = ligacao.getEstacoesLigacao();
                            for (Estacao estacao : estacoes) {
                                visitCount++;
                            }
                        }

                    }
                    Users_Contador.put(user,visitCount);
                }
            }
        }

        // Ordenar os usuários pelo número de visitas em ordem decrescente
        ArrayList<Entry<User, Integer>> sortedEntries = new ArrayList<>(Users_Contador.entrySet());
        sortedEntries.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Retornar os três users com o maior número de visitas
        int count = 0;
        for (Entry<User, Integer> entry : sortedEntries) {
            usuarios.add(entry.getKey());
            count++;
            if (count == 3) {
                break;
            }
        }

        return usuarios;
    }

    //METODO QUE RETORNA OS HORARIOS DE LIGACAO ENTRE DOIS TERMINAIS DE DUSAS LOCALIZACOES INDICADAS
    @Override
    public ArrayList<Horario> Horarios_Ligacao_Terminais(Viagem viagem){
        ArrayList<Horario> horarios_ligacao = new ArrayList<>();
        Horario horario_de_inicio = viagem.getHora_inicio();
        for(Rota rota : viagem.getRota()){
           for(Ligacao ligacao : rota.getLigacoes()){
               Horario tempo = ligacao.getTempo_ligacao();
               Horario horario_somado = horario_de_inicio.somarHorarios(horario_de_inicio, tempo);
               horarios_ligacao.add(horario_somado);
               horario_de_inicio = horario_somado;
           }
        }
        return horarios_ligacao;
    }
}


    /*

    @Override
    public String toString() {
        return "Users_Base_Dados{" +
                "users=" + users +
                ", num_users=" + num_users +
                ", logs=" + logs +
                ", data=" + data +
                '}';
    }
}*/
