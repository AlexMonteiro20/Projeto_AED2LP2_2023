package ProjetoAED2LP2;

import java.util.ArrayList;
import java.util.List;


public class Transporte {

  public int id_transporte;
  public String name_transporte;
  public float custo_transporte;
  public float tempo_transporte;

  //CONSTRUTOR TRANSPORTE
  public Transporte(int id_transporte, String name_transporte, float custo_transporte, float tempo_transporte) {
    this.id_transporte = id_transporte;
    this.name_transporte = name_transporte;
    this.custo_transporte = custo_transporte;
    this.tempo_transporte = tempo_transporte;
  }
  public Transporte(int id_transporte, String name_transporte) {
    this.id_transporte = id_transporte;
    this.name_transporte = name_transporte;
  }


  //GETS E SETS TRANSPORTE
  public int getId_transporte() {
    return id_transporte;
  }
  public void setId_transporte(int id_transporte) {
    this.id_transporte = id_transporte;
  }
  public String getName_transporte() {
    return name_transporte;
  }
  public void setName_transporte(String name_transporte) {
    this.name_transporte = name_transporte;
  }
  public float getCusto_transporte() {
    return custo_transporte;
  }
  public void setCusto_transporte(float custo_transporte) {
    this.custo_transporte = custo_transporte;
  }
  public float getTempo_transporte() {
    return tempo_transporte;
  }
  public void setTempo_transporte(float tempo_transporte) {
    this.tempo_transporte = tempo_transporte;
  }

}

