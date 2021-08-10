import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        String estado;

        boolean sair = true;

        Validacao validacao = new Validacao();

        List<Pessoa> pessoas = new ArrayList<>();

        while (sair) {
            System.out.println("****************** MENU *******************");
            System.out.println("Escolha a opção que deseja realizar");
            System.out.println("1. Visualizar todas as pessoas cadastradas");
            System.out.println("2. Cadastrar pessoa");
            System.out.println("3. Filtrar por estado");
            System.out.println("4. Sair");

            int opcao = scan.nextInt();
            if(opcao == 1){
                if(pessoas.isEmpty()){
                    System.out.println("Ainda não há pessoas cadastradas");
                }
                for(int i = 0; i<pessoas.size(); i++){
                    System.out.println("Nome: " + pessoas.get(i).getNome());
                    System.out.println("Idade: " + pessoas.get(i).getIdade());
                    System.out.println("Estado: " + pessoas.get(i).getEstado());
                    System.out.println("***************************************\n");
                }
            }
            else if(opcao==2){
                Pessoa pessoa = new Pessoa();
                boolean valid;

                do{
                    valid = validacao.validaNome(pessoa);
                } while(!valid);

                do{
                    System.out.println("Digite a sigla do estado");
                    estado = scan2.nextLine();
                    valid = validacao.validaEstado(estado);
                } while (!valid);

                estado = estado.toUpperCase();
                pessoa.setEstado(estado);

                do{
                    valid = validacao.validaIdade(pessoa);
                } while (!valid);


                pessoas.add(pessoa);

            }
            else if(opcao==3){
                Select select = new Select();
                select.selectByState(pessoas);
            }
            else if(opcao==4){
                sair = false;
            }

            else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

    }
}
