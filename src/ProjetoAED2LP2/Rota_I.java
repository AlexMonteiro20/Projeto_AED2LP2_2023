package ProjetoAED2LP2;

import java.util.ArrayList;

public interface Rota_I {
    void inserir_rota(Rota rota);
    void remove_rota(Integer idRota) throws Rota_Exception;
    boolean verificar_rota(Integer idRota);
    boolean editar_rota(int id_rota, ArrayList<Ligacao> ligacaos);
    void guardar_rota();
    void listar_rotas();
}
