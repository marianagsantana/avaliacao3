import java.util.ArrayList;

public class Vaga {
    private int id;
    private NumeroGeneric<String, Integer> vaga;
    private String tipo;
    private String tamanho;
    private double preco;

    public static ArrayList<Vaga> vagas = new ArrayList<Vaga>();

    public Vaga(int id, NumeroGeneric<String, Integer> vaga, String tipo, String tamanho, double preco) {
        try{
            if(vagas.isEmpty()){        
                this.id = id;
                this.vaga = vaga;
                this.tipo = tipo;
                this.tamanho = tamanho;
                this.preco = preco;
        
                vagas.add(this);
            }else if(!vagas.isEmpty()){
                for(Vaga vg : vagas){
                    if(vg.getVaga().equals(vaga)){
                        throw new Exception("Vaga já cadastrada");
                    }else{
                        this.id = id;
                        this.vaga = vaga;
                        this.tipo = tipo;
                        this.tamanho = tamanho;
                        this.preco = preco;
                
                        vagas.add(this);
                    }
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NumeroGeneric<String, Integer>  getVaga() {
        return this.vaga;
    }

    public void setVaga(NumeroGeneric<String, Integer> vaga) {
        this.vaga = vaga;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTamanho() {
        return this.tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Id: " + this.id + " | Número: " + this.vaga + " | Tipo: " + this.tipo + " | Tamanho: "
                + this.tamanho + " | Preço: " + this.preco;
    }

    public static Vaga getVagaById(int id) {
        for (Vaga vaga : Vaga.vagas) {
            if (vaga.id == id) {
                return vaga;
            }
        }

        return null;
    }

    public Boolean verificaVaga(NumeroGeneric<String, Integer> vaga){
        for(Vaga vagaPesquisa: vagas){
            if( vagaPesquisa.getVaga().equals(vaga) == true){
                return true;
            }
        }
        return false;
    }

    public static Vaga deleteVagaById(int id) {
        for (Vaga vaga : Vaga.vagas) {
            if (vaga.id == id) {
                Vaga.vagas.remove(vaga);
                return vaga;
            }
        }

        return null;
    }
}