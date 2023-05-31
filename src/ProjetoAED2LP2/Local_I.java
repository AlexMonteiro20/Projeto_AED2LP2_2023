package ProjetoAED2LP2;


public interface Local_I {
    boolean inserir_local(Local local);
    boolean remover_local(Integer id_local) throws Local_Exception;
    boolean verificar_local(Integer id_local);
    boolean editar_local(Integer id_local, String nome_local, int x_local, int y_local);
    void guardarLocaisEmArquivo();
    void listarLocaisDeArquivo();


}
