import java.util.Scanner;

public class exem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Carro carro1 = new Carro();

        System.out.println("informe o modelo do carro");
        carro1.modelo = sc.next();
        System.out.println("informe o marca do carro");
        carro1.marca = sc.next();
        System.out.println("informe o cor do carro");
        carro1.cor = sc.next();
        System.out.println("informe o ANO do carro");
        carro1.ano = sc.nextInt();

        System.out.println("modelo" + carro1.modelo);
        System.out.println("marca" + carro1.marca);
        System.out.println("cor" + carro1.cor);
        System.out.println("ano" + carro1.ano);

        int anoAtual = 2024;


        String isentoIpva = carro1.ehIsentoIPVA(anoAtual) ? "é isento" : "não isento";
        System.out.println("O " + carro1.modelo + " " + isentoIpva + "do ipva" );

    }
}
