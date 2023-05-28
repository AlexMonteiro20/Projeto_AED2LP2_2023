package ProjetoAED2LP2;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Ligacao {

  public int id_ligacao;
  public Estacao estacao_a;
  public Estacao estacao_b;
  public Horario tempo_ligacao;
  public float custo_ligacao;
  public Transporte transporte_utilizado;
  public ArrayList<Estacao> estacao;


  //CONSTRUTOR TRANSPORTE
  public Ligacao(int id_ligacao, Estacao estacao_a, Estacao estacao_b, Horario tempo_ligacao, float custo_ligacao, Transporte transporte_utilizado, ArrayList<Estacao> estacao) {
    this.id_ligacao = id_ligacao;
    this.estacao_a = estacao_a;
    this.estacao_b = estacao_b;
    this.tempo_ligacao = tempo_ligacao;
    this.custo_ligacao = custo_ligacao;
    this.transporte_utilizado = transporte_utilizado;
    this.estacao = estacao;
  }

  public Ligacao(int id_ligacao, Estacao estacao_a, Estacao estacao_b, Transporte transporte_utilizado) {
    this.id_ligacao = id_ligacao;
    this.estacao_a = estacao_a;
    this.estacao_b = estacao_b;
    this.transporte_utilizado = transporte_utilizado;
  }


  //GETS E SETS TRANSPORTE
  public int getId_ligacao() {
    return id_ligacao;
  }
  public void setId_ligacao(int id_ligacao) {
    this.id_ligacao = id_ligacao;
  }
  public Estacao getEstacao_a() {
    return estacao_a;
  }
  public void setEstacao_a(Estacao estacao_a) {
    this.estacao_a = estacao_a;
  }
  public Estacao getEstacao_b() {
    return estacao_b;
  }
  public void setEstacao_b(Estacao estacao_b) {
    this.estacao_b = estacao_b;
  }
  public Horario getTempo_ligacao() {
    return tempo_ligacao;
  }
  public void setTempo_ligacao(Horario tempo_ligacao) {
    this.tempo_ligacao = tempo_ligacao;
  }
  public float getCusto_ligacao() {
    return custo_ligacao;
  }
  public void setCusto_ligacao(float custo_ligacao) {
    this.custo_ligacao = custo_ligacao;
  }
  public Transporte getTransporte_utilizado() {
    return transporte_utilizado;
  }
  public void setTransporte_utilizado(Transporte transporte_utilizado) {
    this.transporte_utilizado = transporte_utilizado;
  }
  public ArrayList<Estacao> getEstacao() {
    return estacao;
  }
  public void setEstacao(ArrayList<Estacao> estacao) {
    this.estacao = estacao;
  }

//FUNCOES A IMPLEMENTAR//

  /*
  public void addTransporte(Transporte t) {
  }
  public Transporte deleteTransporte(int t) {
  return null;
  }
  public ArrayList<Transporte> listaTransportes() {
  return null;
  }
   */

}