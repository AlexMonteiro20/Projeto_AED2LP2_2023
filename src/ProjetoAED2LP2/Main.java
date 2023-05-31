package ProjetoAED2LP2;

import ProjetoAED2LP2.*;
import edu.princeton.cs.algs4.Digraph;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Main {

    static void clientTest(User_BD user_bd, Viagem_BD viagem_bd,Rota_BD rota_bd, Ligacao_BD ligacao_bd, Estacao_BD estacao_bd, Local_BD local_bd, Mapa_BD mapa_bd, Transporte_BD transporte_bd)
            throws User_Exception, Viagem_Exception, Rota_Exception, Ligacao_Exception, Estacao_Exception, Local_Exception, Mapa_Exception, Transporte_Exception {

        Date data1 = new Date(2022,3,10);
        Date data2 = new Date(2022,7,23);
        Date data3 = new Date(2023,2,4);

  
        //CRIAR USERS
        User Alex = new User(1,"Alex");
        User Joao = new User(2,"Joao");
        User Alex2 = new User(3,"Alex2");
        User Joao2 = new User(4,"Joao2");


        //CRIAR MAPAS (A VER)
        ArrayList<Estacao> estacoes = new ArrayList<>();
        ArrayList<Ligacao> ligacoes = new ArrayList<>();
        Digraph digraph_mapa = new Digraph(10);
        Mapa Mapa_Portugal = new Mapa(1,estacoes,ligacoes,digraph_mapa);

        //CRIAR LOCAIS
        Local Porto = new Local(1,"Porto",1,11,Mapa_Portugal);
        Local Aveiro = new Local(2,"Aveiro",10,9,Mapa_Portugal);
        Local Coimbra = new Local(3,"Coimbra",10,4,Mapa_Portugal);
        Local Lisboa = new Local(4,"Lisboa",1,2,Mapa_Portugal);


        //CRIAR VIAGENS
        ArrayList<Rota> rotas_viagem = new ArrayList<>();
        Horario hora_inicio1 = new Horario(10,30);
        Horario hora_inicio2 = new Horario(11,30);
        Horario hora_inicio3 = new Horario(12,30);
        Horario hora_fim1 = new Horario(0,0);
        Horario hora_fim2 = new Horario(0,0);
        Horario hora_fim3 = new Horario(0,0);
        Viagem Porto_Lisboa = new Viagem(1,Porto,Lisboa,data1,hora_inicio1,hora_fim1,rotas_viagem);
        Viagem Aveiro_Lisboa = new Viagem (2,Aveiro,Lisboa,data2,hora_inicio2,hora_fim2,rotas_viagem);
        Viagem Coimbra_Porto = new Viagem(3,Coimbra,Porto,data3,hora_inicio3,hora_fim3,rotas_viagem);

        //CRIAR ESTACOES
        ArrayList<Transporte> estacao_transportes = new ArrayList<>();
        Estacao Estacao_Porto = new Estacao(1,"Estacao Porto",1,11,estacao_transportes);
        Estacao Estacao_Aveiro = new Estacao(2,"Estacao_Aveiro",10,9,estacao_transportes);
        Estacao Estacao_Coimbra = new Estacao(3,"Estacao_Coimbra",10,4,estacao_transportes);
        Estacao Estacao_Lisboa = new Estacao(4,"Estacao Lisboa",1,2,estacao_transportes);

        //CRIAR ROTAS
        /*Rota rota1 = new Rota(1);
        Rota rota2 = new Rota();
        Rota rota3 = new Rota();
        */

        //CRIAR TRANSPORTES
        Transporte autocarro = new Transporte(1,"Autocarro");
        Transporte aviao = new Transporte(2,"Aviao");
        Transporte barco = new Transporte(3,"Barco");
        Transporte comboio = new Transporte(4,"Comboio");
        Transporte metro = new Transporte(5,"Metro");
        Transporte tvde = new Transporte(6,"Tvde");

        //CRIAR LIGACOES
        Ligacao ligacao_porto_aveiro = new Ligacao(1,Estacao_Porto,Estacao_Aveiro,autocarro);
        Ligacao ligacao_porto_coimbra = new Ligacao(2,Estacao_Porto,Estacao_Coimbra,comboio);
        Ligacao ligacao_porto_lisboa = new Ligacao(3,Estacao_Porto,Estacao_Lisboa,aviao);
        Ligacao ligacao_aveiro_porto = new Ligacao(4,Estacao_Aveiro,Estacao_Porto,tvde);
        Ligacao ligacao_aveiro_coimbra = new Ligacao(5,Estacao_Aveiro,Estacao_Coimbra,autocarro);
        Ligacao ligacao_aveiro_lisboa = new Ligacao(6,Estacao_Aveiro,Estacao_Coimbra,comboio);
        Ligacao ligacao_coimbra_aveiro = new Ligacao(7,Estacao_Coimbra,Estacao_Aveiro,metro);
        Ligacao ligacao_coimbra_porto = new Ligacao(8,Estacao_Coimbra,Estacao_Porto,tvde);
        Ligacao ligacao_coimbra_lisboa = new Ligacao(9,Estacao_Coimbra,Estacao_Lisboa,tvde);
        Ligacao ligacao_lisboa_coimbra = new Ligacao(10,Estacao_Lisboa,Estacao_Coimbra,autocarro);
        Ligacao ligacao_lisboa_aveiro = new Ligacao(11,Estacao_Lisboa,Estacao_Coimbra,comboio);
        Ligacao ligacao_lisboa_porto = new Ligacao(12,Estacao_Lisboa,Estacao_Porto,barco);


        System.out.println("USERS");
        user_bd.inserir_user(Alex);
        user_bd.inserir_user(Joao);
        user_bd.inserir_user(Alex2);
        user_bd.inserir_user(Joao2);
        user_bd.remove_user(2);
        user_bd.remove_user(3);
        user_bd.guardar_user();
        user_bd.verificar_user(2);
        user_bd.verificar_user(1);
        user_bd.editar_user(4,"Joao");
        user_bd.listar_users();
        System.out.println("\n");


        System.out.println("LOCAIS");
        local_bd.inserir_local(Porto);
        local_bd.inserir_local(Aveiro);
        local_bd.inserir_local(Coimbra);
        local_bd.inserir_local(Lisboa);
        local_bd.remover_local(3);
        local_bd.editar_local(2,"Guarda", 1,9);
        local_bd.guardarLocaisEmArquivo();
        local_bd.verificar_local(1);
        local_bd.verificar_local(3);
        local_bd.listarLocaisDeArquivo();
        System.out.println("\n");


        System.out.println("VIAGENS");
        viagem_bd.inserir_viagem(Porto_Lisboa);
        viagem_bd.inserir_viagem(Aveiro_Lisboa);
        viagem_bd.inserir_viagem(Coimbra_Porto);
        viagem_bd.remove_viagem(1);
        viagem_bd.verificar_viagem(1);
        viagem_bd.verificar_viagem(2);
        viagem_bd.editar_viagem(1,Coimbra); //TERMINAR BD
        viagem_bd.guardar_viagens();
        viagem_bd.listar_viagens();
        System.out.println("\n");


        /*System.out.println("ESTACOES");
        estacao_bd.inserir_estacao(Estacao_Porto);
        estacao_bd.inserir_estacao(Estacao_Aveiro);
        estacao_bd.inserir_estacao(Estacao_Coimbra);
        estacao_bd.inserir_estacao(Estacao_Lisboa);
        estacao_bd.remove_estacao(3);
        estacao_bd.verificar_estacao(2);
        estacao_bd.verificar_estacao(3);
        estacao_bd.editar_estacao(2,"Estacao_Guarda",1,9);
        estacao_bd.guardar_estacao();
        estacao_bd.listar_estacoes();
        System.out.println("\n");

        System.out.println("LIGACOES");
        ligacao_bd.inserir_ligacao(ligacao_porto_aveiro);
        ligacao_bd.inserir_ligacao(ligacao_porto_coimbra);
        ligacao_bd.inserir_ligacao(ligacao_porto_lisboa);
        ligacao_bd.inserir_ligacao(ligacao_aveiro_porto);
        ligacao_bd.inserir_ligacao(ligacao_aveiro_coimbra);
        ligacao_bd.inserir_ligacao(ligacao_aveiro_lisboa);
        ligacao_bd.inserir_ligacao(ligacao_coimbra_aveiro);
        ligacao_bd.inserir_ligacao(ligacao_coimbra_porto);
        ligacao_bd.inserir_ligacao(ligacao_coimbra_lisboa);
        ligacao_bd.inserir_ligacao(ligacao_lisboa_coimbra);
        ligacao_bd.inserir_ligacao(ligacao_lisboa_aveiro);
        ligacao_bd.inserir_ligacao(ligacao_lisboa_porto);
        ligacao_bd.remove_ligacao(2);
        ligacao_bd.verificar_ligacao(2);
        ligacao_bd.verificar_ligacao(1);
        ligacao_bd.editar_ligacao(1,);
        ligacao_bd.guardar_ligacao();
        ligacao_bd.listar_ligacoes();
        System.out.println("\n");


        System.out.println("TRANSPORTES");
        transporte_bd.inserir_transporte(autocarro);
        transporte_bd.inserir_transporte(aviao);
        transporte_bd.inserir_transporte(barco);
        transporte_bd.inserir_transporte(comboio);
        transporte_bd.inserir_transporte(metro);
        transporte_bd.inserir_transporte(tvde);
        transporte_bd.remove_transporte(2);
        transporte_bd.verificar_transporte(2);
        transporte_bd.verificar_transporte(1);
        transporte_bd.editar_transporte(4,"Autocarro");
        transporte_bd.guardar_transportes();
        transporte_bd.listar_transportes();
        System.out.println("\n");

      */
    }

    public static void main(String[] args) throws User_Exception, Viagem_Exception, Rota_Exception, Ligacao_Exception, Estacao_Exception, Local_Exception, Mapa_Exception, Transporte_Exception {
        User_BD user_bd = new User_BD();
        Viagem_BD viagem_bd = new Viagem_BD();
        Rota_BD rota_bd = new Rota_BD();
        Ligacao_BD ligacao_bd = new Ligacao_BD();
        Estacao_BD estacao_bd = new Estacao_BD();
        Local_BD local_bd = new Local_BD();
        Mapa_BD mapa_bd = new Mapa_BD();
        Transporte_BD transporte_bd = new Transporte_BD();

        clientTest(user_bd,viagem_bd,rota_bd,ligacao_bd,estacao_bd,local_bd,mapa_bd,transporte_bd) ;

    }
}