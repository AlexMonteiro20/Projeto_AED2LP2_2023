package ProjetoAED2LP2;

import java.util.ArrayList;

public class Metro extends Transporte {

  public int id_metro;
  public static float custo_metro = 0.2f;
  public static float tempo_metro = 0.75f;

  //CONSTRUTOR METRO
  public Metro(int id_transporte, String name_transporte, float custo_transporte, float tempo_transporte) {
    super(id_transporte, name_transporte, custo_transporte, tempo_transporte);
  }

  //GETS E SETS
  public int getId_metro() {
    return id_metro;
  }
  public void setId_metro(int id_metro) {
    this.id_metro = id_metro;
  }
  public static float getCusto_metro() {
    return custo_metro;
  }
  public static void setCusto_metro(float custo_metro) {
    Metro.custo_metro = custo_metro;
  }
  public static float getTempo_metro() {
    return tempo_metro;
  }
  public static void setTempo_metro(float tempo_metro) {
    Metro.tempo_metro = tempo_metro;
  }
}