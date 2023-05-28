package ProjetoAED2LP2;

import java.util.ArrayList;

public class Autocarro extends Transporte {
  public int id_autocarro;
  public static float custo_autocarro = 0.2f;
  public static float tempo_autocarro = 2.0f;

  //CONSTRUTOR AUTOCARRO
  public Autocarro(int id_transporte, String name_transporte, float custo_transporte, float tempo_transporte) {
    super(id_transporte, name_transporte, custo_transporte, tempo_transporte);
  }

  //GETS E SETS AUTOCARRO
  public int getId_autocarro() {
    return id_autocarro;
  }
  public void setId_autocarro(int id_autocarro) {
    this.id_autocarro = id_autocarro;
  }
  public static float getCusto_autocarro() {
    return custo_autocarro;
  }
  public static void setCusto_autocarro(float custo_autocarro) {
    Autocarro.custo_autocarro = custo_autocarro;
  }
  public static float getTempo_autocarro() {
    return tempo_autocarro;
  }
  public static void setTempo_autocarro(float tempo_autocarro) {
    Autocarro.tempo_autocarro = tempo_autocarro;
  }
}