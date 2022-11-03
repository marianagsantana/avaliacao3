import java.util.ArrayList;

public class Moto extends Veiculos {
    private NumeroGeneric<String, Integer> placa;
    private String cilindradas;

    public static ArrayList<Moto> motos = new ArrayList<Moto>();

    public Moto(int id, String nome, NumeroGeneric<String, Integer> placa, String cilindradas) {
        super(id, nome);
        try{
            if(motos.isEmpty()){        
                this.placa = placa;
                this.cilindradas = cilindradas;
        
                motos.add(this);
            }else if(!motos.isEmpty())
                for(Moto moto : motos){
                    if(moto.getPlaca().equals(placa)){
                        throw new Exception("Placa já cadastrada");
                    }else{
                        this.placa = placa;
                        this.cilindradas = cilindradas;
                
                        motos.add(this);
                    }
            }else{
                throw new Exception("Moto já cadastrada");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public NumeroGeneric<String,Integer> getPlaca() {
        return placa;
    }

    public void setPlaca(NumeroGeneric<String, Integer> placa) {
        this.placa = placa;
    }

    public String getCilindradas() {
        return cilindradas;
    }

    public Boolean verificaPlaca(NumeroGeneric<String, Integer> placa){
        for(Moto moto: motos){
            if( moto.getPlaca().equals(placa) == true){
                return true;
            }
        }
        return false;
    }

    public void setCilindradas(String cilindradas) {
        this.cilindradas = cilindradas;
    }

    @Override
    public String toString() {
        return super.toString() + "Placa" + this.placa + "| Cilindradas" + this.cilindradas;
    }
}