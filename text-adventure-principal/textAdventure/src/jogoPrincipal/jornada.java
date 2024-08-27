package jogoPrincipal;

import java.util.Scanner;

public class jornada {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        comandos cm = new comandos();

        System.out.println("Ola Digite um comando destes para  começar! ");
        System.out.println("• HELP: exbibe o menu de ajuda do jogo \n" +
                "• USE ITEM: interage com o item da cena\n" +
                "• CHECK : mostra a descrição do objeto na cena\n" +
                "• GET :  Adiciona o item ao inventário\n" +
                "• INVENTÁRIO: mostra os itens que estão no inventário\n" +
                "• USE : Realiza a ação utilizando um item do inventário \n" +
                "• SAVE: salva o jogo\n" +
                "• LOAD: carrega um jogo salvo\n" +
                "• RESTART: reinicia o jogo");
        cm.setComando_1(sc.next());
        System.out.println(cm.inicio());

        sc.close();
    }


}
