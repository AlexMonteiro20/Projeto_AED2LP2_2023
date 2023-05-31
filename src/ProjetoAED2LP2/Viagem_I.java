package ProjetoAED2LP2;

public interface Viagem_I {
    void inserir_viagem(Viagem viagem);
    void remove_viagem(Integer idViagem) throws Viagem_Exception;
    boolean verificar_viagem(Integer idViagem);
    boolean editar_viagem(int id_viagem,Local local_partida);
    Viagem encontrarViagemPorId(Integer idViagem);
    void guardar_viagens();
    void listar_viagens();
}
