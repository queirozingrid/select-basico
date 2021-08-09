import java.util.InputMismatchException;
import java.util.Scanner;

public class Validacao {

    public boolean validaIdade(Pessoa pessoa){
        int idade;
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite a idade");
        try{
            idade = scan.nextInt();
            if(idade<0){
                return false;
            }
            else{
                pessoa.setIdade(idade);
                return true;
            }
        } catch (InputMismatchException e){
            System.out.println("Digite apenas números");
            return false;
        }

    }

    public boolean validaEstado(String estado){
        int contNum = 0;

        if(estado.length()!= 2){
            System.out.println("DIGITE APENAS A SIGLA (DOIS DIGITOS)");
            return false;
        }
        for (int i = 0; i < estado.length(); i++) {
            if(Character.isDigit(estado.charAt(i)) || !Character.isAlphabetic(estado.charAt(i))) {
                contNum++;
            }
        }
        if(contNum>0){
            System.out.println("Digite apenas letras!!");
            return false;
        }
        else {
            return true;
        }
    }

    public boolean validaNome(Pessoa pessoa){
        int i;
        int contNum = 0;
        Scanner scan2 = new Scanner(System.in);
        String nome;
        System.out.println("Digite o nome");
        nome = scan2.nextLine();

        if(nome.isEmpty() || nome.isBlank()){
            return false;
        }
        for (i = 0; i < nome.length(); i++) {
            if(Character.isDigit(nome.charAt(i)) || !Character.isAlphabetic(nome.charAt(i))) {
                contNum++;
            }
        }
        if(contNum>0){
            System.out.println("Digite apenas letras!!");
            return false;
        }
        else {
            pessoa.setNome(nome);
            return true;
        }


    }
}
