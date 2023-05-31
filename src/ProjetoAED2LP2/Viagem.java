package ProjetoAED2LP2;

import java.util.ArrayList;
import java.util.*;

public class Viagem {
  public int id_Viagem;
  public Local Local_partida;
  public Local Local_destino;
  public Date data_viagem;
  public Horario Hora_inicio;
  public Horario Hora_fim;
  public ArrayList<Rota> rotas;
  public Rota rota_user;


//CONSTRUTOR VIAGEM
public Viagem(int id_Viagem, Local local_partida, Local local_destino, Date data_viagem, Horario hora_inicio, Horario hora_fim, ArrayList<Rota> rotas) {
  this.id_Viagem = id_Viagem;
  Local_partida = local_partida;
  Local_destino = local_destino;
  this.data_viagem = data_viagem;
  Hora_inicio = hora_inicio;
  Hora_fim = hora_fim;
  this.rotas = rotas;
}


  //GETS E SETS VIAGEM
  public Local getLocal_partida() {
    return Local_partida;
  }
  public void setLocal_partida(Local local_partida) {
    Local_partida = local_partida;
  }
  public Local getLocal_destino() {
    return Local_destino;
  }
  public void setLocal_destino(Local local_destino) {
    Local_destino = local_destino;
  }
  public Date getData_viagem() {
    return data_viagem;
  }
  public void setData_viagem(Date data_viagem) {
    this.data_viagem = data_viagem;
  }
  public Horario getHora_inicio() {
    return Hora_inicio;
  }
  public void setHora_inicio(Horario hora_inicio) {
    Hora_inicio = hora_inicio;
  }
  public Horario getHora_fim() {
    Horario tempo = new Horario(0,0);
    tempo = rota_user.getTempo();
    Hora_fim = tempo.somarHorarios(tempo,Hora_inicio);
    return Hora_fim;
  }
  public void setHora_fim(Horario hora_fim) {
    Hora_fim = hora_fim;
  }
  public int getId_Viagem() {
    return id_Viagem;
  }
  public void setId_Viagem(int id_Viagem) {
    this.id_Viagem = id_Viagem;
  }
  public ArrayList<Rota> getRota() {
    return rotas;
  }
  public void setRota(ArrayList<Rota> rotas) {
    this.rotas = rotas;
  }


  //FUNCOES A IMPLEMENTAR
  /*
  public void addRota(Rota r) {
  }
  public Rota deleteRota(int r) {
    return null;
  }
  public ArrayList<Rota> listarRotas() {
    return null;
  }
  */
}