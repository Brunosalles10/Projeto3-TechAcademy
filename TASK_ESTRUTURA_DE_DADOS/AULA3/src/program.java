import java.util.Scanner;

public class program {
    public static void main(String[] args) {


    Scanner sc = new Scanner(System.in);
    usuarios usuarios1 = new usuarios();

        System.out.println("informe seu nome ? ");
        usuarios1.setName(sc.next());
        System.out.println("informe seu sobrenome ? ");
        usuarios1.sobrenome = sc.next();
        System.out.println("informe seu salario? ");
        usuarios1.salarios = sc.nextInt();

        System.out.println("seu nome " + usuarios1.getName() + " "+ usuarios1.sobrenome+ " salario R$"+ usuarios1.salarios);
    }
}


