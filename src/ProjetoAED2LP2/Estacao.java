package ProjetoAED2LP2;

import java.util.ArrayList;

public class Estacao extends Local{
    //public int id_estacao;
    //public String name_estacao;
    ArrayList<Transporte> transportes;


    //CONSTRUTORES ESTACAO
    public Estacao(int id_local, String local_name, int local_x, int local_y, ArrayList<Transporte> transportes) {
        super(id_local, local_name, local_x, local_y);
        this.transportes = transportes;
    }

    public Estacao(int id_local, String local_name, int local_x, int local_y) {
        super(id_local, local_name, local_x, local_y);
    }

    //GETS E SETS ESTACAO
    public ArrayList<Transporte> getTransportes() {
        return transportes;
    }
    public void setTransportes(ArrayList<Transporte> transportes) {
        this.transportes = transportes;
    }

}
