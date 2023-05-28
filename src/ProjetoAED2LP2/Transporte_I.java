package ProjetoAED2LP2;

public interface Transporte_I {
    void inserir_transporte(Transporte transporte);
    void remove_transporte(Integer idTransporte) throws Transporte_Exception;
    boolean verificar_transporte(Integer idTransporte);
    boolean editar_transporte(int id_transporte, String name_transporte);
    Transporte encontrarTransportePorId(int idTransporte);
    void guardar_transportes();
    void listar_transportes();
}
