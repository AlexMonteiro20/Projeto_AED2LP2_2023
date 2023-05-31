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

  public Rota(int id_rota, float preco, Horario tempo, int paragens, Viagem viagem) {
    this.id_rota = id_rota;
    this.preco = preco;
    this.tempo = tempo;
    this.paragens = paragens;
    this.viagem = viagem;
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


  //FUNCOES ROTA
  public float getPrecoRota(){
    float preco_rota = 0.0f;
    for(Ligacao ligacao : ligacoes){
     preco_rota += ligacao.getCusto_ligacao();
    }
    return preco_rota;
  }

  public Horario getTempoRota(){
    Horario tempoRota = new Horario(0,0);
    for(Ligacao ligacao : ligacoes){
      Horario tempoLigacao = ligacao.getTempo_ligacao();
      tempoRota = tempoRota.somarHorarios(tempoRota,tempoLigacao);
    }
    return tempoRota;
  }

  public int getParagensRota(){
    int paragensRota = 1;
    for(Ligacao ligacao : ligacoes){
      paragensRota +=1;
    }
    return paragensRota;
  }

}