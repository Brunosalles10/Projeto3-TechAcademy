package jogoPrincipal;

public class comandos {
    private String comando_1;

    public comandos() {
    }

    public comandos(String comando_1) {
        this.comando_1 = comando_1.toUpperCase();
    }

    public String getComando_1() {
        return comando_1;
    }

    public void setComando_1(String comando_1) {
        this.comando_1 = comando_1.toUpperCase();
    }

    public String inicio() {
        switch (comando_1){
            case "HELP":
                return "Voce pode usar os comandos";


            case "ITEM":
                return"Itens da cena";

            case "USE ITEM":
                return "item da cena";

            case "CHECK":
                return "descriçao de objetos";

            case "GET":
                return "adicionar intem ao invnetário";

            case "INVENTÁRIO":
                return "mostra inventário";

            case "USE":
                return "usa algum item do inventário";

            case "SAVE":
                return "salva o jogo";

            case "LOAD":
                return "carrega o jogo";

            case "RESTART":
                return "reinicia o jogo";

            default:
                return "Comando Inválido";


        }

    }
}
