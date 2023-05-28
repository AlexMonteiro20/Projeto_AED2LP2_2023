package ProjetoAED2LP2;

import java.util.ArrayList;

public class Aviao extends Transporte {

  public int id_aviao;
  public static float custo_aviao = 0.8f;
  public static float tempo_aviao = 0.1f;

  //CONSTRUTOR AVIAO
  public Aviao(int id_transporte, String name_transporte, float custo_transporte, float tempo_transporte) {
    super(id_transporte, name_transporte, custo_transporte, tempo_transporte);
  }

  //GETS E SETS AVIAO
  public int getId_aviao() {
    return id_aviao;
  }
  public void setId_aviao(int id_aviao) {
    this.id_aviao = id_aviao;
  }
  public static float getCusto_aviao() {
    return custo_aviao;
  }
  public static void setCusto_aviao(float custo_aviao) {
    Aviao.custo_aviao = custo_aviao;
  }
  public static float getTempo_aviao() {
    return tempo_aviao;
  }
  public static void setTempo_aviao(float tempo_aviao) {
    Aviao.tempo_aviao = tempo_aviao;
  }
}