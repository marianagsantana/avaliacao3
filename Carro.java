import java.util.ArrayList;

public class Carro extends Veiculos {
    private NumeroGeneric<String, Integer> placa;
    private String cor;

    public static ArrayList<Carro> carros = new ArrayList<Carro>();

    public Carro(int id, String nome, NumeroGeneric<String, Integer> placa, String cor) {
        super(id, nome);
        try{
            if(carros.isEmpty()){        
                this.placa = placa;
                this.cor = cor;
        
                carros.add(this);
            }else if(!carros.isEmpty())
                for(Carro carro : carros){
                    if(carro.getPlaca().equals(placa)){
                        throw new Exception("Placa já cadastrada");
                    }else{
                        this.placa = placa;
                        this.cor = cor;
                
                        carros.add(this);
                    }
            }else{
                throw new Exception("Carro já cadastrado");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    public NumeroGeneric<String, Integer> getPlaca() {
        return placa;
    }

    public void setPlaca(NumeroGeneric<String, Integer> placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Boolean verificaPlaca(NumeroGeneric<String, Integer> placa){
        for(Carro carro: carros){
            if( carro.getPlaca().equals(placa) == true){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + "Placa: " + this.placa + "| Cor: " + this.cor;
    }
}