package ProjetoAED2LP2;

import java.util.Date;

public interface Local_I {
    void addText(String mensagem, Date data, String file);
    boolean inserir_local(Local local);
    boolean remover_local(Integer id_local) throws Local_Exception;
    boolean verificar_local(Integer id_local);
    void guardarLocaisEmArquivo();
    void listarLocaisDeArquivo();
    boolean editar_local(Integer id_local, String nome_local, int x_local, int y_local);

}
