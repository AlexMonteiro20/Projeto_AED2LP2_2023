package ProjetoAED2LP2;

public interface Viagem_I {
    void inserir_viagem(Viagem viagem);
    void remove_viagem(Integer idViagem) throws Viagem_Exception;
    boolean verificar_viagem(Integer idViagem);
}
