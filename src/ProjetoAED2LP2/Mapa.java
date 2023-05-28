package ProjetoAED2LP2;

import java.util.ArrayList;
import java.util.List;


public class Mapa {
  public int mapa_id;
  public ArrayList<Estacao> estacoes_mapa;

  //CONSTRUTOR MAPA
  public Mapa(int mapa_id, ArrayList<Estacao> estacoes_mapa) {
    this.mapa_id = mapa_id;
    this.estacoes_mapa = estacoes_mapa;
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


  //FUNCOES A IMPLEMENTAR//

  /*
  public void addLocal(Local l) {
  }
  public Local deleteLocal(int l) {
  return null;
  }
  public ArrayList<Local> listaLocais() {
    return null;
  }
   */

}