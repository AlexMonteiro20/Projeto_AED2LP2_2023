package ProjetoAED2LP2;

import edu.princeton.cs.algs4.Digraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Mapa {
  public int mapa_id;
  public ArrayList<Estacao> estacoes_mapa;
  public ArrayList<Ligacao> ligacoes_mapa;
  private Digraph graph_mapa;

  //CONSTRUTOR MAPA
  public Mapa(int mapa_id, ArrayList<Estacao> estacoes_mapa,ArrayList<Ligacao> ligacoes_mapa, Digraph graph_mapa) {
    this.mapa_id = mapa_id;
    this.estacoes_mapa = estacoes_mapa;
    this.ligacoes_mapa = ligacoes_mapa;
    this.graph_mapa = graph_mapa;
  }

//GETS E SETS MAPA

  public int getMapa_id() {
    return mapa_id;
  }
  public void setMapa_id(int mapa_id) {
    this.mapa_id = mapa_id;
  }
  public ArrayList<Estacao> getEstacoes_mapa() {
    return estacoes_mapa;
  }
  public void setEstacoes_mapa(ArrayList<Estacao> estacoes_mapa) {
    this.estacoes_mapa = estacoes_mapa;
  }
  public ArrayList<Ligacao> getLigacoes_mapa() {
    return ligacoes_mapa;
  }
  public void setLigacoes_mapa(ArrayList<Ligacao> ligacoes_mapa) {
    this.ligacoes_mapa = ligacoes_mapa;
  }
  public Digraph getGraph_mapa() {
    return graph_mapa;
  }
  public void setGraph_mapa(Digraph graph_mapa) {
    this.graph_mapa = graph_mapa;
  }

  //FUNCOES MAPA
  public void addEstacaoMapa(Estacao estacao) {
    estacoes_mapa.add(estacao);
    int vertexId = estacao.getId_local();
    graph_mapa.addEdge(vertexId, vertexId); // Adiciona uma aresta de um vértice para ele mesmo
  }

  public void addLigacaoMapa(Ligacao ligacao) {
    ligacoes_mapa.add(ligacao);
    graph_mapa.addEdge(ligacao.getEstacao_a().getId_local(), ligacao.getEstacao_b().getId_local());
  }

  public float distanciaEntreEstacoes_Mapa(Estacao a, Estacao b){
    double distancia = Math.sqrt(Math.pow(b.getLocal_x() - a.getLocal_x(), 2) + Math.pow(b.getLocal_y() - a.getLocal_y(), 2));
    return (float)distancia;
  }


}