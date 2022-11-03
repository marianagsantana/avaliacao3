import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Scanner;
public class Estacionamento {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int op = 0;

        System.out.println("========== Estacionamento ===========");

        do {
            System.out.println("\n\n[01] - Cadastrar Carros");
            System.out.println("[02] - Cadastrar Motos");
            System.out.println("[03] - Cadastrar Bicicletas");
            System.out.println("[04] - Cadastrar Vagas");
            System.out.println("[05] - Cadastrar Locações");
            System.out.println("[06] - Listar Carros");
            System.out.println("[07] - Listar Motos");
            System.out.println("[08] - Listar Bicicletas");
            System.out.println("[09] - Listar Vagas");
            System.out.println("[10] - Listar Locações");
            System.out.println("[11] - Excluir Carros");
            System.out.println("[12] - Excluir Motos");
            System.out.println("[13] - Excluir Bicicletas");
            System.out.println("[14] - Excluir Vagas");
            System.out.println("[15] - Excluir Locações");
            System.out.println("[16] - Sair");
            op = sc.nextInt();

            switch (op) {
                case 1: {
                    CadastrarCarro(sc);
                    break;
                }

                case 2: {
                    CadastrarMoto(sc);
                    break;
                }

                case 3: {
                    CadastrarBicicleta(sc);
                    break;
                }

                case 4: {
                    CadastrarVagas(sc);
                    break;
                }

                case 5: {
                    CadastrarLocacao(sc);
                    break;
                }

                case 6: {
                    ListarCarros(sc);
                    break;
                }

                case 7: {
                    ListarMotos(sc);
                    break;
                }

                case 8: {
                    ListarBicicletas(sc);
                    break;
                }

                case 9:
                    ListarVagas(sc);
                break;

                case 10:
                    ListarLocacao(sc);
                break;

                case 11: {
                    ExcluirCarros(sc);
                    break;
                }

                case 12: {
                    ExcluirMotos(sc);
                    break;
                }

                case 13: {
                    ExcluirBicicletas(sc);
                    break;
                }

                case 14:
                    ExcluirVagas(sc);
                break;

                case 15:
                    ExcluirLocacao(sc);
                break;

                case 16: {
                    System.out.println("Saindo...");
                    break;
                }

                default: {
                    System.out.println("Opção inválida!");
                    break;
                }
            }

        } while (op != 16);
    }

    public static void CadastrarCarro(Scanner scanner) {
        Boolean placaVerificada = false;
        System.out.println("Cadastro de Carro");

        System.out.println("Informe o nome do carro: ");
        String nome = scanner.next();

        System.out.println("Informe as letras da placa do carro: ");
        String letra = scanner.next();

        System.out.println("Informe os números placa do carro: ");
        String numero = scanner.next();


        while(placaVerificada != true){
            if( letra.length() == 3 && numero.length() == 4) {
                placaVerificada = true;
            }else if(letra.length() != 3 && numero.length() ==4){
                System.out.println("Digite as letras da placa novamente: ");
                letra = scanner.next();
            }else if(letra.length() ==3 && numero.length() != 4){
                System.out.println("Digite os números da placa novamente ");
                numero = scanner.next();
            }else{
                System.out.println("Digite as letras da placa novamente");
                letra = scanner.next();
                System.out.println("Digite os numeros da placa novamente");
                numero = scanner.next();
            }
            
        }

        System.out.println("Informe a cor do carro: ");
        String cor = scanner.next();
        if(placaVerificada == true){
            NumeroGeneric<String,Integer> placa = new NumeroGeneric<String,Integer>(letra,Integer.parseInt(numero));
            try{
                Carro carro = new Carro(Veiculos.veiculos.size() + 1, nome, placa, cor);
                while(carro.getPlaca() == null){
                    int idCarro = carro.getId();
                    System.out.println("Já cadastrada");
                    System.out.println("Digite as letras da placa novamente");
                    letra = scanner.next();
                    System.out.println("Digite os numeros da placa novamente");
                    numero = scanner.next();   
                    placa = new NumeroGeneric<String,Integer>(letra,Integer.parseInt(numero));
                    for (Veiculos car : Veiculos.veiculos) {
                        if (car instanceof Carro && car.getId() == idCarro) {
                            Veiculos.veiculos.remove(car);
                            break;
                        }
                    }
                    carro = new Carro(idCarro, nome, placa, cor);
                }
                System.out.println("Carro cadastrado com sucesso!\n" + carro);
            }catch(Exception e){
                System.out.println("Erro ao cadastrar carro: " + e.getMessage());
            }
            
        }

    }

    public static void CadastrarMoto(Scanner scanner) {

        Boolean placaVerificada = false;
        System.out.println("Cadastro de Moto");

        System.out.println("Informe o nome da moto: ");
        String nome = scanner.next();

        System.out.println("Informe a quantidade de cilindradas: ");
        String cilindradas = scanner.next();
        
        System.out.println("Informe as letras da placa da moto: ");
        String letra = scanner.next();

        System.out.println("Informe os números da placa da moto");
        String numero = scanner.next();
        
        while(placaVerificada != true){
            if( letra.length() == 3 && numero.length() == 4) {
                placaVerificada = true;
            }else if(letra.length() != 3 && numero.length() ==4){
                System.out.println("Digite as letras da placa novamente: ");
                letra = scanner.next();
            }else if(letra.length() ==3 && numero.length() != 4){
                System.out.println("Digite os números da placa novamente ");
                numero = scanner.next();
            }else{
                System.out.println("Digite as letras da placa novamente");
                letra = scanner.next();
                System.out.println("Digite os numeros da placa novamente");
                numero = scanner.next();
            }
        }
        if(placaVerificada == true){
            NumeroGeneric<String,Integer> placa = new NumeroGeneric<String,Integer>(letra,Integer.parseInt(numero));
            try{
                Moto moto = new Moto(Veiculos.veiculos.size() + 1, nome, placa, cilindradas);

                while(moto.getPlaca() == null){
                    int idCarro = moto.getId();
                    System.out.println("Já cadastrada");
                    System.out.println("Digite as letras da placa novamente");
                    letra = scanner.next();
                    System.out.println("Digite os numeros da placa novamente");
                    numero = scanner.next();   
                    placa = new NumeroGeneric<String,Integer>(letra,Integer.parseInt(numero));
                    for (Veiculos mot : Veiculos.veiculos) {
                        if (mot instanceof Moto && mot.getId() == idCarro) {
                            Veiculos.veiculos.remove(mot);
                            break;
                        }
                    }
                    moto = new Moto(Veiculos.veiculos.size() + 1, nome, placa, cilindradas);

                }
                System.out.println("Moto cadastrado com sucesso!\n" + moto);
            }catch(Exception e){
                System.out.println("Erro ao cadastrar carro: " + e.getMessage());
            }
            
        }        
    }

    public static void CadastrarBicicleta(Scanner scanner) {
        System.out.println("Cadastro de Bicileta");

        System.out.println("Informe o nome da bicicleta: ");
        String nome = scanner.next();

        System.out.println("Informe a marca da bicicleta: ");
        String marca = scanner.next();

        System.out.println("Informe a cor da bicicleta: ");
        String cor = scanner.next();

        Veiculos bicicleta = new Bicicleta(Veiculos.veiculos.size() + 1, nome, marca, cor);

        System.out.println("Bicicleta cadastrada com sucesso!\n" + bicicleta);
    }

    public static void CadastrarVagas(Scanner scanner) {
        
        Boolean vagaVerificada = false;

        System.out.println("Cadastro de Vagas");

        System.out.println("Informe o tipo da vaga: [C]-Carro [M]-Moto [B]-Bicicleta");
        String tipo = scanner.next();
        
        System.out.println("Informe o tamanho da vaga: ");
        String tamanho = scanner.next();
        
        System.out.println("Informe o valor da vaga: ");
        double valor = scanner.nextDouble();
        
        System.out.println("Informe a letra da vaga: ");
        String letra = scanner.next();

        System.out.println("Informe os números da vaga: ");
        String numero = scanner.next();
        while(vagaVerificada != true){
            if( letra.length() == 1 && numero.length() == 3) {
                vagaVerificada = true;
            }else if(letra.length() != 1 && numero.length() ==3){
                System.out.println("Digite as letras da placa novamente: ");
                letra = scanner.next();
            }else if(letra.length() ==1 && numero.length() != 3){
                System.out.println("Digite os números da placa novamente ");
                numero = scanner.next();
            }else{
                System.out.println("Digite a letra da vaga novamente");
                letra = scanner.next();
                System.out.println("Digite os numeros da vaga novamente");
                numero = scanner.next();
            }
        }
        if(vagaVerificada == true){
            
            NumeroGeneric<String,Integer> numeroVaga = new NumeroGeneric<String,Integer>(letra,Integer.parseInt(numero));
            try{
                Vaga vaga = new Vaga(Vaga.vagas.size() + 1, numeroVaga, tipo, tamanho, valor);

                while(vaga.getVaga() == null){
                    int idVaga = vaga.getId();
                    System.out.println("Já cadastrada");
                    System.out.println("Digite a letra da vaga novamente");
                    letra = scanner.next();
                    System.out.println("Digite os numeros da vaga novamente");
                    numero = scanner.next();
                    numeroVaga = new NumeroGeneric<String,Integer>(letra,Integer.parseInt(numero));
                    for (Vaga vg : Vaga.vagas) {
                        if (vaga instanceof Vaga && vaga.getId() == idVaga) {
                            Veiculos.veiculos.remove(vg);
                            break;
                        }
                    }
                    vaga = new Vaga(Vaga.vagas.size() + 1, numeroVaga, tipo, tamanho, valor);

                }
                System.out.println("Vaga cadastrado com sucesso!\n" + vaga);
            }catch(Exception e){
                System.out.println("Erro ao cadastrar vaga: " + e.getMessage());
            }
        }
    }

    public static void CadastrarLocacao(Scanner sc) {
        System.out.println("Cadastro de Locação");

        System.out.println("----------------------------------");
        System.out.println("Veículos para Locação: ");
        for (Veiculos veiculo : Veiculos.veiculos) {
            if (veiculo instanceof Veiculos) {
                System.out.println(veiculo);
            }
        }
        System.out.println("----------------------------------");

        System.out.println("Informe o id do veículo: ");
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Calendar calendario = Calendar.getInstance();
        String data = dateFormat.format(calendario.getTime());
        System.out.println("Data e Horario : " + data);
        System.out.println(data.equals("27-10-2022 21:37"));

    }

    // Listagens
    public static void ListarCarros(Scanner sc) {
        System.out.println("Listagem de Carros");

        System.out.println("----------------------------------");

        for (Veiculos carro : Veiculos.veiculos) {
            if (carro instanceof Carro) {
                System.out.println(carro);
            }
        }
        System.out.println("----------------------------------");
    }

    public static void ListarMotos(Scanner sc) {
        System.out.println("Listagem de Motos");

        System.out.println("----------------------------------");

        for (Veiculos moto : Veiculos.veiculos) {
            if (moto instanceof Moto) {
                System.out.println(moto);
            }
        }
        System.out.println("----------------------------------");
    }

    public static void ListarBicicletas(Scanner sc) {
        System.out.println("Listagem de Biciicletas");

        System.out.println("----------------------------------");

        for (Veiculos bicicleta : Veiculos.veiculos) {
            if (bicicleta instanceof Bicicleta) {
                System.out.println(bicicleta);
            }
        }
        System.out.println("----------------------------------");
    }

    public static void ListarVagas(Scanner sc) {
        System.out.println("Listagem de Vagas");

        System.out.println("----------------------------------");

        for (Vaga vaga : Vaga.vagas) {
            if (vaga instanceof Vaga) {
                System.out.println(vaga);
            }
        }
        System.out.println("----------------------------------");
    }

    public static void ListarLocacao(Scanner sc) {
        System.out.println("Listagem de Locacao");

        System.out.println("----------------------------------");

        for (Locacao locar : Locacao.locacoes) {
            if (locar instanceof Locacao) {
                System.out.println(locar);
            }else{
                System.out.println("Nao foi possivel alocar");
            }
        }
        System.out.println("----------------------------------");
    }



    // Exclusões
    public static void ExcluirCarros(Scanner sc) {
        System.out.println("Exclusão de Carros");

        System.out.println("Informe o ID do carro: ");
        int id = sc.nextInt();

        for (Veiculos carro : Veiculos.veiculos) {
            if (carro instanceof Carro && carro.getId() == id) {
                Veiculos.veiculos.remove(carro);
                System.out.println("Carro excluído com sucesso!");
                break;
            }
        }
    }

    public static void ExcluirMotos(Scanner sc) {
        System.out.println("Exclusão de Motos");

        System.out.println("Informe o ID da moto: ");
        int id = sc.nextInt();

        for (Veiculos moto : Veiculos.veiculos) {
            if (moto instanceof Moto && moto.getId() == id) {
                Veiculos.veiculos.remove(moto);
                System.out.println("Moto excluída com sucesso!");
                break;
            }
        }
    }

    public static void ExcluirBicicletas(Scanner sc) {
        System.out.println("Exclusão de Bicicletas");

        System.out.println("Informe o ID da bicicleta: ");
        int id = sc.nextInt();

        for (Veiculos bicicleta : Veiculos.veiculos) {
            if (bicicleta instanceof Bicicleta && bicicleta.getId() == id) {
                Veiculos.veiculos.remove(bicicleta);
                System.out.println("Bicicleta excluída com sucesso!");
                break;
            }
        }
    }

    public static void ExcluirVagas(Scanner sc) {
        System.out.println("Exclusão de Vagas");

        System.out.println("Informe o ID da Vaga: ");
        int id = sc.nextInt();

        for (Vaga vaga : Vaga.vagas) {
            if (vaga instanceof Vaga && vaga.getId() == id) {
                Vaga.vagas.remove(vaga);
                System.out.println("vaga excluída com sucesso!");
                break;
            }
        }
    }

    public static void ExcluirLocacao(Scanner sc) {
        System.out.println("Exclusão de Locacao");

        System.out.println("Informe o ID da Locacao: ");
        int id = sc.nextInt();

        for (Locacao locacao : Locacao.locacoes) {
            if (locacao instanceof Locacao && locacao.getId() == id) {
                Locacao.locacoes.remove(locacao);
                System.out.println("Bicicleta excluída com sucesso!");
                break;
            }
        }
    }
}