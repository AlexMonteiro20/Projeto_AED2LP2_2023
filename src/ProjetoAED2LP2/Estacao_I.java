package ProjetoAED2LP2;

public interface Estacao_I {
    void inserir_estacao(Estacao estacao);
    void remove_estacao(Integer idEstacao) throws Estacao_Exception;
    boolean verificar_estacao(Integer idUser);
    boolean editar_estacao(int id_local, String local_name, int local_x, int local_y);
    void guardar_estacao();
    void listar_estacoes();
}
