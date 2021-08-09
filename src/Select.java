import java.util.List;
import java.util.Scanner;

public class Select {
    public void selectByState(List<Pessoa> pessoas){
        Scanner scan = new Scanner(System.in);
        Validacao validacao = new Validacao();

        System.out.println("Escolha o estado");
        String estado = scan.nextLine();
        estado = estado.toUpperCase();

        if(validacao.validaEstado(estado)){
            System.out.println("***** PESSOAS DESSE ESTADO *****");

            for (Pessoa p : pessoas) {
                if(p.getEstado().equals(estado)){
                    System.out.println(p.getNome());
                }
            }
        }

    }
}
