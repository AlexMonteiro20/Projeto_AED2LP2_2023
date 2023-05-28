package ProjetoAED2LP2;

import java.util.ArrayList;
import java.util.List;


public class User {

  private int user_id;
  private String user_name;
  private ArrayList<Viagem> viagens;
  public Viagem nova_viagem;
  public Mapa mapa;

  //CONSTRUTOR USER
  public User(int user_id, String user_name, ArrayList<Viagem> viagens, Viagem nova_viagem, Mapa mapa) {
    this.user_id = user_id;
    this.user_name = user_name;
    this.viagens = viagens;
    this.nova_viagem = nova_viagem;
    this.mapa = mapa;
  }

  public User(int user_id, String user_name) {
    this.user_id = user_id;
    this.user_name = user_name;
  }

  //GETS E SETS USER
  public int getUser_id() {
    return user_id;
  }
  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }
  public String getUser_name() {
    return user_name;
  }
  public void setUser_name(String user_name) {
    this.user_name = user_name;
  }
  public ArrayList<Viagem> getViagens() {
    return viagens;
  }
  public void setViagens(ArrayList<Viagem> viagens) {
    this.viagens = viagens;
  }
  public Viagem getNova_viagem() {
    return nova_viagem;
  }
  public void setNova_viagem(Viagem nova_viagem) {
    this.nova_viagem = nova_viagem;
  }
  public Mapa getMapa() {
    return mapa;
  }
  public void setMapa(Mapa mapa) {
    this.mapa = mapa;
  }


/* FUNCOES A IMPLEMENTAR

    public void addViagem(Viagem v) {
  }
  public Viagem deleteViagem(int v) {
  return null;
  }
  public ArrayList<Viagem> listaViagens() {
  return null;
  }
   */
}