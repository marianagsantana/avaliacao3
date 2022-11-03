import java.util.ArrayList;

public class Bicicleta extends Veiculos {
    private String marca;
    private String cor;

    public static ArrayList<Bicicleta> bicicletas = new ArrayList<Bicicleta>();

    public Bicicleta( int id, String nome, String marca, String cor) {
        super(id, nome);
        this.marca = marca;
        this.cor = cor;

        bicicletas.add(this);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return super.toString() + "Marca" + this.marca + "| Cor" + this.cor;
    } 

}