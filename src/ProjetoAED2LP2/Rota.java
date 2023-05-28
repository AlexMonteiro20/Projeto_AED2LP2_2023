package ProjetoAED2LP2;

import java.util.ArrayList;
import java.util.List;

public class Rota {

  public int id_rota;
  public float preco;
  public Horario tempo;
  public int paragens;
  public Viagem viagem;
  public ArrayList<Ligacao> ligacoes;

  //CONSTRUTOR ROTA
  public Rota(int id_rota, float preco, Horario tempo, int paragens, Viagem viagem, ArrayList<Ligacao> ligacoes) {
    this.id_rota = id_rota;
    this.preco = preco;
    this.tempo = tempo;
    this.paragens = paragens;
    this.viagem = viagem;
    this.ligacoes = ligacoes;
  }

  //GETS E SETS ROTA
  public int getId_rota() {
    return id_rota;
  }
  public void setId_rota(int id_rota) {
    this.id_rota = id_rota;
  }
  public float getPreco() {
    return preco;
  }
  public void setPreco(float preco) {
    this.preco = preco;
  }
  public Horario getTempo() {
    return tempo;
  }
  public void setTempo(Horario tempo) {
    this.tempo = tempo;
  }
  public int getParagens() {
    return paragens;
  }
  public void setParagens(int paragens) {
    this.paragens = paragens;
  }
  public Viagem getViagem() {
    return viagem;
  }
  public void setViagem(Viagem viagem) {
    this.viagem = viagem;
  }
  public ArrayList<Ligacao> getLigacoes() {
    return ligacoes;
  }
  public void setLigacoes(ArrayList<Ligacao> ligacoes) {
    this.ligacoes = ligacoes;
  }

  //FUNCOES A IMPLEMENTAR
  /*
  public ArrayList<Ligacao> listaLigacoes() {
    return null;
  }

  public void addLigacao(Ligacao l) {
  }

  public Ligacao deleteLigacao(int l) {
  return null;
  }
   */
}