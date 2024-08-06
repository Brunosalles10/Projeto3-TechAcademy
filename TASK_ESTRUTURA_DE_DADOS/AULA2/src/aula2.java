import java.util.Scanner;

public class aula2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("informe um numero inteiro: ");
        int numero = sc.nextInt();

        boolean numeroPar = numero % 2 == 0;

        if (numeroPar) System.out.println("o numero " +  numero  + " e par");

        if (!numeroPar) System.out.println("o numero " + numero + "é " + numeroPar);
    }


}
