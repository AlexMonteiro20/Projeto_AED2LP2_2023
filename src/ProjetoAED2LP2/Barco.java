package ProjetoAED2LP2;

import java.util.ArrayList;

public class Barco extends Transporte {

  public int id_barco;
  public static float custo_barco = 0.5f;
  public static float tempo_barco = 0.5f;

  //CONSTRUTOR BARCO
  public Barco(int id_transporte, String name_transporte, float custo_transporte, float tempo_transporte) {
    super(id_transporte, name_transporte, custo_transporte, tempo_transporte);
  }

  //GETS E SETS BARCO
  public int getId_barco() {
    return id_barco;
  }
  public void setId_barco(int id_barco) {
    this.id_barco = id_barco;
  }
  public static float getCusto_barco() {
    return custo_barco;
  }
  public static void setCusto_barco(float custo_barco) {
    Barco.custo_barco = custo_barco;
  }
  public static float getTempo_barco() {
    return tempo_barco;
  }
  public static void setTempo_barco(float tempo_barco) {
    Barco.tempo_barco = tempo_barco;
  }

}