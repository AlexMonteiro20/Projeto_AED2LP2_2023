package ProjetoAED2LP2;

import java.util.ArrayList;

public class Estacao extends Local{
    //public int id_estacao;
    //public String name_estacao;
    ArrayList<Transporte> transportes;
    ArrayList<Ligacao> ligacoes;

    //CONSTRUTOR ESTACAO
    public Estacao(int id_local, String local_name, int local_x, int local_y,ArrayList<Transporte> transportes, ArrayList<Ligacao> ligacoes ) {
        super(id_local, local_name, local_x, local_y);
        this.transportes = transportes;
        this.ligacoes = ligacoes;
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
    public ArrayList<Ligacao> getLigacoes() {
        return ligacoes;
    }
    public void setLigacoes(ArrayList<Ligacao> ligacoes) {
        this.ligacoes = ligacoes;
    }
}
