package ProjetoAED2LP2;

public interface Ligacao_I {
    void inserir_ligacao(Ligacao ligacao);
    void remove_ligacao(Integer idLigacao) throws Ligacao_Exception;
    boolean verificar_ligacao(Integer idLigacao);
    boolean editar_ligacao(int id_ligacao, Estacao estacao_a, Estacao estacao_b, Transporte transporte_utilizado);
    void guardar_ligacao();
    void listar_ligacoes();
}
