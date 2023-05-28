package ProjetoAED2LP2;

import java.util.ArrayList;

public class Comboio extends Transporte {

  public int id_comboio;
  public static float custo_comboio = 0.3f;
  public static float tempo_comboio = 0.5f;

  //CONSTRUTOR COMBOIO
  public Comboio(int id_transporte, String name_transporte, float custo_transporte, float tempo_transporte) {
    super(id_transporte, name_transporte, custo_transporte, tempo_transporte);
  }

  //GETS E SETS COMBOIO
  public int getId_comboio() {
    return id_comboio;
  }
  public void setId_comboio(int id_comboio) {
    this.id_comboio = id_comboio;
  }
  public static float getCusto_comboio() {
    return custo_comboio;
  }
  public static void setCusto_comboio(float custo_comboio) {
    Comboio.custo_comboio = custo_comboio;
  }
  public static float getTempo_comboio() {
    return tempo_comboio;
  }
  public static void setTempo_comboio(float tempo_comboio) {
    Comboio.tempo_comboio = tempo_comboio;
  }
}