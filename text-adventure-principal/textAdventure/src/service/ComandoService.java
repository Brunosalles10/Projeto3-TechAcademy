package service;
import jogoPrincipal.Console;
import jogoPrincipal.Save;
import repository.SaveDAO;


public class ComandoService {
    private final String[] comando;
    private final Console console;

    public ComandoService(String comandoBruto){
        Console console = new Console();
        this.console = console;
        this.comando = comandoBruto.split(" ");

    }

    public Console help() {
        console.setMensagem("HELP: exbibe o menu de ajuda do jogo \n" +
                "• USE: interage com o item da cena\n" +
                "• CHECK: mostra a descrição do objeto na cena\n" +
                "• GET : Se possível, adiciona o item ao inventário\n" +
                "• INVENTORY: mostra os itens que estão no inventário\n" +
                "• USE [INVENTORY_ITEM] WITH [SCENE_ITEM]: Realiza a ação utilizando um item do " +
                "inventário com um item da cena\n" +
                "• SAVE: salva o jogo\n" +
                "• LOAD: carrega um jogo salvo\n" +
                "• RESTART: reinicia o jogo");
        return console;
    }

    public Console start() {
        try {
            Save save = SaveDAO.novoJogo();
            console.setMensagem(save.getCenaAtual().getDescricao());
            console.setIdSave(save.getIdSave());
            return console;
        } catch (Exception e) {
            e.printStackTrace();
            console.setMensagem("Erro ao tentar iniciar o jogo");
            return console;
        }
    }

    public Console getResultadoConsole(){
        try {
            //A variável primeiroComando recebe a primeira posição
            //do array comando.
            String primeiroComando = comando[0].toLowerCase();

            //O comando switch irá testar o nome do primeiro comando.
            //se o valor da variável for igual ao da sentença case
            //iremos chamar o método para tratar sobre aquele comando.
            return switch (primeiroComando) {
                case "help" -> help();
                case "start" -> start();
                default -> {
                    console.setMensagem("Comando inválido");
                    yield console;
                }
            };
        } catch (Exception e) {
            console.setMensagem("Comando inválido");
            return console;
        }
    }

}
