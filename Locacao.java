import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Locacao {
    private int id;
    private int idVeiculo;
    private LocalDate data;
    private LocalTime hora;

    public static ArrayList<Locacao> locacoes = new ArrayList<Locacao>();

    public Locacao(int id, LocalDate data, LocalTime hora, int idVeiculo) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.idVeiculo = idVeiculo;

        locacoes.add(this);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return this.data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return this.hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public int getIdVeiculo() {
        return this.idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    @Override
    public String toString() {
        return "Id: " + this.id + " | Data: " + this.data;
    }

    public static Locacao getLocarById(int id) {
        for (Locacao locacao : Locacao.locacoes) {
            if (locacao.id == id) {
                return locacao;
            }
        }

        return null;
    }

    public static Locacao deleteLocarById(int id) {
        for (Locacao locacao : Locacao.locacoes) {
            if (locacao.id == id) {
                Locacao.locacoes.remove(locacao);
                return locacao;
            }
        }

        return null;
    }
}