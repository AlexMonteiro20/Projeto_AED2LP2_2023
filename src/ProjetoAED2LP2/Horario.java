package ProjetoAED2LP2;

public class Horario {
    private int hora;
    private int minutos;

    //CONSTRUTOR HORARIO
    public Horario(int hora, int minutos) {
            this.hora = hora;
            this.minutos = minutos;
    }

    //GETS E SETS HORARIO
    public int getHora() {
            return hora;
        }
    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinutos() {
            return minutos;
        }

    public void setMinutos(int minutos) {
            this.minutos = minutos;
        }

    @Override
    public String toString() {
            return String.format("%02d:%02d", hora, minutos);
        }

    public Horario somarHorarios(Horario horario1, Horario horario2) {
        int horas = horario1.getHora() + horario2.getHora();
        int minutos = horario1.getMinutos() + horario2.getMinutos();

        // Ajustar os minutos caso ultrapassem 60
        if (minutos >= 60) {
            horas += minutos / 60;
            minutos %= 60;
        }

        return new Horario(horas, minutos);
    }


  /*  public static void main(String[] args) {
        // Cria dois horários
        LocalTime horario1 = LocalTime.of(9, 30); // 09:30
        LocalTime horario2 = LocalTime.of(14, 45); // 14:45

        // Calcula a diferença entre os horários
        Duration diferenca = Duration.between(horario1, horario2);

        // Obtém a diferença em horas e minutos
        long horas = diferenca.toHours();
        long minutos = diferenca.toMinutes() % 60;

        // Exibe a diferença de horas e minutos
        System.out.println("Diferença de horas: " + horas);
        System.out.println("Diferença de minutos: " + minutos);
    }
   */
}
