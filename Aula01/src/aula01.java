import java.util.Scanner;

public class aula01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello World");

        System.out.println("Digite seu nome ?");
        String nome = sc.nextLine();
        System.out.println("Seu nome é: " + nome);

        sc.close();
    }



}
