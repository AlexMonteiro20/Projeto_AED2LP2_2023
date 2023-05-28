package ProjetoAED2LP2;

import java.util.ArrayList;
import java.util.Date;

public interface User_I {
    void inserir_user(User user);
    void remove_user(Integer idUser) throws User_Exception;
    boolean verificar_user(Integer idUser);
    boolean editar_user(Integer idUser, String nome);
    void guardar_user();
    void listar_users();
    ArrayList<Rota> Rotas_NumDadoPeriodo(int user_id, Date dataInicial, Date dataFinal);
    ArrayList<Estacao> Estacoes_NaoVisitadas(int user_id, Date dataInicial, Date dataFinal);
    ArrayList<User> usuariosComRotasPorEstacoesPeriodo(ArrayList<Estacao> estacoes, Date dataInicial, Date dataFinal);
    ArrayList<User> Top3UsersMaiorNumStationsPeriodo(ArrayList<Estacao> estacoes, Date dataInicial, Date dataFinal);
    ArrayList<Horario> Horarios_Ligacao_Terminais(Viagem viagem);
}
