package ProjetoAED2LP2;

import java.util.ArrayList;

public class TVDE extends Transporte {
  public int id_tvde;
  public static float custo_tvde = 0.5f;
  public static float tempo_tvde = 1.0f;

  //CONSTRUTOR TVDE
  public TVDE(int id_transporte, String name_transporte, float custo_transporte, float tempo_transporte) {
    super(id_transporte, name_transporte, custo_transporte, tempo_transporte);
  }
  //GETS E SETS TVDE
  public int getId_tvde() {
    return id_tvde;
  }
  public void setId_tvde(int id_tvde) {
    this.id_tvde = id_tvde;
  }
  public static float getCusto_tvde() {
    return custo_tvde;
  }
  public static void setCusto_tvde(float custo_tvde) {
    TVDE.custo_tvde = custo_tvde;
  }
  public static float getTempo_tvde() {
    return tempo_tvde;
  }
  public static void setTempo_tvde(float tempo_tvde) {
    TVDE.tempo_tvde = tempo_tvde;
  }

}