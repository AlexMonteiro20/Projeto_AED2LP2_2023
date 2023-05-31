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


  //CONSTRUTOR TRANSPORTE
  public Ligacao(int id_ligacao, Estacao estacao_a, Estacao estacao_b, Horario tempo_ligacao, float custo_ligacao, Transporte transporte_utilizado) {
    this.id_ligacao = id_ligacao;
    this.estacao_a = estacao_a;
    this.estacao_b = estacao_b;
    this.tempo_ligacao = tempo_ligacao;
    this.custo_ligacao = custo_ligacao;
    this.transporte_utilizado = transporte_utilizado;
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

  //FUNCOES LIGACOES
  public float getCustoLigacao(){
    float custoLigacao = distanciaEntreEstacoes_Ligacao(estacao_a,estacao_b) * transporte_utilizado.getCusto_transporte();
    return custoLigacao;
  }

  public Horario getTempoLigacao(){
    Horario tempoLigacao = new Horario(0,0);
    float value = distanciaEntreEstacoes_Ligacao(estacao_a,estacao_b) * transporte_utilizado.getTempo_transporte();
    if(value > 60){
      int horas = (int) value/60;
      int minutos =(int) value - horas * 60;
      tempoLigacao = new Horario(horas,minutos);
    }
    if(value < 60){
      int horas = 0;
      int minutos = (int)value;
      tempoLigacao = new Horario(horas,minutos);
    }
    return tempoLigacao;
  }

  public float distanciaEntreEstacoes_Ligacao(Estacao a, Estacao b){
    double distancia = Math.sqrt(Math.pow(b.getLocal_x() - a.getLocal_x(), 2) + Math.pow(b.getLocal_y() - a.getLocal_y(), 2));
    return (float)distancia;
  }

  public ArrayList<Estacao> getEstacoesLigacao(){
    ArrayList<Estacao> estacoesLigacao = new ArrayList<>();
    estacoesLigacao.add(estacao_a);
    estacoesLigacao.add(estacao_b);
    return estacoesLigacao;
  }

}