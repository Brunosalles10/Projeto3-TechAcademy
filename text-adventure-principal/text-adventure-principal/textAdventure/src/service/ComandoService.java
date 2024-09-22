package service;

import jogoPrincipal.Cenario;
import jogoPrincipal.Console;
import jogoPrincipal.Item;
import jogoPrincipal.Save;
import repository.CenarioDAO;
import repository.ItemDAO;
import repository.SaveDAO;

import java.sql.SQLException;
import java.util.List;


public class ComandoService {
    private final String[] comando;
    private final Console console;

    public ComandoService(String comandoBruto) {
        Console console = new Console();
        this.console = console;
        this.comando = comandoBruto.split(" ");

    }


    public Console help() {
        console.setMensagem("HELP: exbibe os comandos possiveis do jogo \n" +
                "• START: Inicia o jogo\n" +
                "• USE: Usa algum dos  itens disponiveis\n" +
                "• CHECK: mostra a descrição do objeto na cena\n" +
                "• GET : Pega o item e adiciona ao inventário\n" +
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
            Cenario cenario = CenarioDAO.findCenaById(1);
            console.setMensagem(" " + cenario.getDescricao());

            return console;
        } catch (Exception e) {
            e.printStackTrace();
            console.setMensagem("Erro ao tentar iniciar o jogo");
            return console;
        }
    }

    public Console use() {

        try {


            if (comando.length < 2) {
                console.setMensagem("Especifique um item para usar.");


            } else if (comando[1].equalsIgnoreCase("chave")) {
                Cenario cenario = CenarioDAO.findCenaById(2);
                console.setMensagem(" " + cenario.getDescricao());


            } else if (comando[1].equalsIgnoreCase("laser")) {
                Cenario cenario = CenarioDAO.findCenaById(3);
                console.setMensagem(" " + cenario.getDescricao());
            } else if (comando[1].equalsIgnoreCase("laser-y")) {
                Cenario cenario = CenarioDAO.findCenaById(4);
                console.setMensagem(" " + cenario.getDescricao());
            } else if (comando[1].equalsIgnoreCase("chave-y")) {
                Cenario cenario = CenarioDAO.findCenaById(5);
                console.setMensagem(" " + cenario.getDescricao());
            } else if (comando[1].equalsIgnoreCase("download")) {
                Cenario cenario = CenarioDAO.findCenaById(6);
                console.setMensagem(" " + cenario.getDescricao());
            } else if (comando[1].equalsIgnoreCase("chave-eletronica")) {
                Cenario cenario = CenarioDAO.findCenaById(9);
                console.setMensagem(" " + cenario.getDescricao());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return console;
    }

    public Console check() {
        try {
            if (comando.length < 2) {
                console.setMensagem("Check: comando incompleto. Exemplo: CHECK");
                return console;
            }

            String itemName = comando[1];
            Item item = ItemDAO.findItemById(Integer.valueOf(itemName));

            if (item != null) {
                console.setMensagem("Descrição do item: " + item.getDescricaoPositiva());
            } else {
                console.setMensagem("Item não encontrado na cena.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            console.setMensagem("Erro ao tentar checar o item.");
        }
        return console;
    }

    public Console get()
    {
        try {
            if (comando.length < 2) {
                console.setMensagem("PEGAR ITEM!");
            } else if (comando[1].equalsIgnoreCase("laser-y")) {
                Cenario cenario = CenarioDAO.findCenaById(7);
                console.setMensagem(" " + cenario.getDescricao());
            } else if (comando[1].equalsIgnoreCase("chave-y")) {
                Cenario cenario = CenarioDAO.findCenaById(8);
                console.setMensagem(" " + cenario.getDescricao());
            } else if (comando[1].equalsIgnoreCase("chave-eletronica")) {
                Cenario cenario = CenarioDAO.findCenaById(9);
                console.setMensagem(" " + cenario.getDescricao());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return console;
    }

    public Console inventory() {
        console.setMensagem("Mostrando itens no inventário...");
        try {
            List<Item> itensInventario = ItemDAO.getItensInventario(); // Implementa a recuperação de itens do inventário do jogador
            if (itensInventario.isEmpty()) {
                console.setMensagem("Seu inventário está vazio.");
            } else {
                StringBuilder inventarioMensagem = new StringBuilder("Itens no seu inventário:\n");
                for (Item item : itensInventario) {
                    inventarioMensagem.append("- ").append(item.getNome()).append(": ").append(item.getDescricaoPositiva()).append("\n");
                }
                console.setMensagem(inventarioMensagem.toString());
            }
        } catch (Exception e) {
            console.setMensagem("Erro ao listar os itens do inventário.");
        }
        return console;
    }


    public Console save() {
        try {
            Save save = SaveDAO.novoJogo();
            console.setMensagem(save.getCenaAtual().getDescricao());
            console.setIdSave(save.getIdSave());
            console.setMensagem("Jogo salvo com sucesso");
            return console;
        } catch (Exception e) {
            e.printStackTrace();
            console.setMensagem("Erro ao salvar jogo");
            return console;
        }
    }

    public Console load() {
        try {

            console.setMensagem("Jogo carregado com sucesso!");
        } catch (Exception e) {
            console.setMensagem("Erro ao carregar o jogo.");
        }
        return console;
    }

    public Console restart() throws SQLException {
        try {
            Cenario cenario = CenarioDAO.findCenaById(1);
            console.setMensagem(" \"Jogo reiniciado!\" " + cenario.getDescricao());

        } catch (Exception e) {
            console.setMensagem("Erro ao reiniciar o jogo.");
        }
        return console;
    }


    public Console getResultadoConsole() {
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
                case "use" -> use();
                case "check" -> check();
                case "get" -> get();
                case "inventory" -> inventory();
                case "save" -> save();
                case "load" -> load();
                case "restart" -> restart();

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
