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
                "• CHECK: mostra a descrição de itens,  ou objetos do jogo e acessa portas quando possível \n" +
                "• GET : Pega o item e adiciona ao inventário\n" +
                "• INVENTORY: mostra os itens que foram pegos  nos cenários\n" +
                "• USE_WITH mais nome dos itens: Realiza ação combinando itens se possível.\n" +
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


            } else if (comando[1].equalsIgnoreCase("flipper")) {
                Cenario cenario = CenarioDAO.findCenaById(2);
                console.setMensagem(" " + cenario.getDescricao());


            } else if (comando[1].equalsIgnoreCase("laser")) {
                Cenario cenario = CenarioDAO.findCenaById(11);
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
                console.setMensagem("Check: comando incompleto. Exemplo:check-laser");
                return console;
            } else if (comando[1].equalsIgnoreCase("chave-y")) {
                Item item = ItemDAO.checkItensInventario(4);
                console.setMensagem(" " + item.getNome());
            } else if (comando[1].equalsIgnoreCase("chave-eletronica")) {
                Item item = ItemDAO.checkItensInventario(2);
                console.setMensagem(" " + item.getNome());

            } else if (comando[1].equalsIgnoreCase("laser")) {
                Item item = ItemDAO.checkItensInventario(1);
                console.setMensagem(" " + item.getNome());
            } else if (comando[1].equalsIgnoreCase("laser-y")) {
                Item item = ItemDAO.checkItensInventario(5);
                console.setMensagem(item.getNome());
            } else if (comando[1].equalsIgnoreCase("traje")) {
                Item item = ItemDAO.checkItensInventario(6);
                console.setMensagem(item.getNome());
            } else if (comando[1].equalsIgnoreCase("flipper")) {
                Item item = ItemDAO.checkItensInventario(7);
                console.setMensagem(item.getNome());

            } else if (comando[1].equalsIgnoreCase("porta")) {
                Cenario cenario = CenarioDAO.findCenaById(3);
                console.setMensagem(cenario.getDescricao());
            }

        } catch (Exception e) {
            e.printStackTrace();
            console.setMensagem("Erro ao tentar checar o item.");
        }
        return console;
    }

    public Console get() {
        try {
            if (comando.length < 2) {
                console.setMensagem("PEGAR ITEM!");

            } else if (comando[1].equalsIgnoreCase("laser-y")) {
                Cenario cenario = CenarioDAO.findCenaById(7);
                console.setMensagem(" " + cenario.getDescricao());
                Item item = ItemDAO.addInventario(1, 1, 1, "laser-y");
            } else if (comando[1].equalsIgnoreCase("chave-y")) {
                Cenario cenario = CenarioDAO.findCenaById(8);
                console.setMensagem(" " + cenario.getDescricao());
                Item item = ItemDAO.addInventario(1, 2, 1, "chave-y");
            } else if (comando[1].equalsIgnoreCase("chave-eletronica")) {
                Cenario cenario = CenarioDAO.findCenaById(9);
                console.setMensagem(" " + cenario.getDescricao());
                Item item = ItemDAO.addInventario(1, 3, 1, "chave-eletronica");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return console;
    }

    public Console inventory() {
        try {

            if (comando.length < 2) {
                console.setMensagem("Comando errado! inventory jogador");
            } else if (comando[1].equalsIgnoreCase("jogador")) {
                List<Item> inventario = ItemDAO.exibirInventario(1);
                StringBuilder itensInventario = new StringBuilder("Itens pegos nos cenarios:\n");
                for (Item item : inventario) {
                    itensInventario.append("---------------------------------------------\n-")
                            .append("Jogador ID: ").append(item.getIdItensJogador()).append("\n")
                            .append("Nome item: ").append(item.getNome()).append("\n")
                            .append("Quantidade: ").append(item.getQuantidade()).append("\n")
                            .append("---------------------------------------------\n");

                    console.setMensagem(itensInventario.toString());
                }
                if (inventario.isEmpty()) {
                    console.setMensagem("inventário está vazio");
                }


            }


        } catch (Exception e) {
            console.setMensagem("Erro ao listar os itens do inventário.");
        }
        return console;
    }


    public Console save() {
        try {

            Save save = SaveDAO.novoJogo(1,1);
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
        try {if (comando.length < 2){
            console.setMensagem("digite load jogador para carregar jogo");
        } else if (comando[1].equalsIgnoreCase("jogador")) {
            Save save = SaveDAO.carregarJogo(5);
            console.setMensagem(" " + save.getIdSave());
            console.setMensagem(" " + save.getCenaAtual());
            console.setMensagem("Jogo carregado com sucesso!");}
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

    public Console use_with(){
        try{
            if(comando.length < 2){
                console.setMensagem(" use_with nome-item + nome-item para combinar os 2 itens, se possível");
            } else if (comando[1].equalsIgnoreCase("flippermaischave")) {
                Cenario cenario = CenarioDAO.findCenaById(10);
                console.setMensagem(" " + cenario.getDescricao());

            }

        } catch (Exception e) {
            console.setMensagem("Erro ao combinar itens");
        }
        return console;
    }


    public Console getResultadoConsole() {
        try {
            String primeiroComando = comando[0].toLowerCase();
            return switch (primeiroComando) {
                case "help" -> help();
                case "start" -> start();
                case "use" -> use();
                case "check" -> check();
                case "get" -> get();
                case "use_with" -> use_with();
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
