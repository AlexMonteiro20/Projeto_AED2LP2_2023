package ProjetoAED2LP2;

import java.util.ArrayList;
import java.util.List;


public class Local {
  public int id_local;
  public String local_name;
  public int local_x;
  public int local_y;
  public Mapa mapa;

  //CONSTRUTOR LOCAL
  public Local(int id_local, String local_name, int local_x, int local_y, Mapa mapa) {
    this.id_local = id_local;
    this.local_name = local_name;
    this.local_x = local_x;
    this.local_y = local_y;
    this.mapa = mapa;
  }

  public Local(int id_local, String local_name, int local_x, int local_y) {
    this.id_local = id_local;
    this.local_name = local_name;
    this.local_x = local_x;
    this.local_y = local_y;
  }

  //GETS E SETS DE LOCAL

  public int getId_local() {
    return id_local;
  }
  public void setId_local(int id_local) {
    this.id_local = id_local;
  }
  public String getLocal_name() {
    return local_name;
  }
  public void setLocal_name(String local_name) {
    this.local_name = local_name;
  }
  public int getLocal_x() {
    return local_x;
  }
  public void setLocal_x(int local_x) {
    this.local_x = local_x;
  }
  public int getLocal_y() {
    return local_y;
  }
  public void setLocal_y(int local_y) {
    this.local_y = local_y;
  }
  public Mapa getMapa() {
    return mapa;
  }
  public void setMapa(Mapa mapa) {
    this.mapa = mapa;
  }

}