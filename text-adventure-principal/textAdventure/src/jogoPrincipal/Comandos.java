package jogoPrincipal;

import java.util.ArrayList;
import java.util.List;

import repository.CenarioDAO;
import repository.ItemDAO;
import repository.SaveDAO;

import java.sql.Connection;

public class Comandos {

    private Jogador jogador;
    private List<Item> inventario;
    private Connection conn;
    private ItemDAO itemDAO;
    private CenarioDAO cenarioDAO;
    private SaveDAO saveDAO;

    public Comandos(Connection conn, Jogador jogador) {
        this.conn = conn;
        this.jogador = jogador;
        this.inventario = new ArrayList<>();
        this.itemDAO = new ItemDAO(conn);
        this.cenarioDAO = new CenarioDAO(conn);
        this.saveDAO = new SaveDAO(conn);
    }


    public String processarComando(String comando) {
        String resultado = "";

        switch (comando.toUpperCase()) {
            case "HELP":
                resultado = exibirMenuAjuda();
                break;
            case "USE ITEM":
                resultado = usarItem();
                break;
            case "CHECK":
                resultado = checkDescricaoCena();
                break;
            case "GET":
                resultado = pegarItem();
                break;
            case "INVENTÁRIO":
                resultado = exibirInventario();
                break;
            case "USE":
                resultado = usarItemInventario();
                break;
            case "SAVE":
                resultado = salvarJogo();
                break;
            case "LOAD":
                resultado = carregarJogo();
                break;
            case "RESTART":
                resultado = reiniciarJogo();
                break;
            default:
                resultado = "Comando não reconhecido.";
                break;
        }

        return resultado;
    }



    // Exibe o menu de ajuda
    private String exibirMenuAjuda() {
        return "Comandos disponíveis:\n" +
                "• HELP: exibe o menu de ajuda do jogo\n" +
                "• USE ITEM: interage com o item da cena\n" +
                "• CHECK: mostra a descrição do objeto na cena\n" +
                "• GET: adiciona o item ao inventário\n" +
                "• INVENTÁRIO: mostra os itens que estão no inventário\n" +
                "• USE: realiza a ação utilizando um item do inventário\n" +
                "• SAVE: salva o jogo\n" +
                "• LOAD: carrega um jogo salvo\n" +
                "• RESTART: reinicia o jogo";
    }

    // Usar um item na cena
    private String usarItem(String nomeItem) {
        try {
            List<Item> item = itemDAO.findItemByName(nomeItem);

            if (item != null) {
                return "Você usou o item: " + " ";

            } else {
               return "Item não encontrado.";
            }
        } catch (Exception e) {
            return "Erro ao usar o item: " + e.getMessage();
        }

    }

    // Mostrar descrição da cena atual
    private String checkDescricaoCena() {
        try {
            Cenario cenarioAtual = (Cenario) cenarioDAO.getAllCenarios(jogador.getCenario_id());
            if (cenarioAtual!= null) {
                return "Descrição da cena: " + cenarioAtual.getConteudo();
            } else {
                return "Cenário não encontrado.";
            }
        } catch (Exception e) {
            return "Erro ao buscar descrição da cena: " + e.getMessage();
        }
    }

    // Pegar um item e adicioná-lo ao inventário
    private void pegarItem(String nomeItem) {
        try {
            List<Item> item = itemDAO.findItemByName(nomeItem);
            if (item != null) {
                inventario.add((Item) item);
                System.out.println("Você pegou o item: " + ((Item) item).getNomeItem());
            } else {
                System.out.println("Item não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao pegar o item: " + e.getMessage());
        }
    }

    // Exibir os itens no inventário
    private void exibirInventario() {
        if (inventario.isEmpty()) {
            System.out.println("Seu inventário está vazio.");
        } else {
            System.out.println("Itens no inventário:");
            for (Item item : inventario) {
                System.out.println("- " + item.getNomeItem());
            }
        }
    }

    // Usar um item do inventário
    private void usarItemInventario(String nomeItem) {
        Item item = inventario.stream().filter(i -> i.getNomeItem().equals(nomeItem)).findFirst().orElse(null);
        if (item != null) {
            System.out.println("Você usou o item do inventário: " + item.getNomeItem());
        } else {
            System.out.println("Item não encontrado no inventário.");
        }
    }

    // Salvar o jogo
    private void salvarJogo() {
        try {
            Save save = new Save();
            save.setJogadorId(jogador.getId());
            save.setCenarioId(jogador.getId());
            save.setItens(inventario);
            saveDAO.salvarprogesso(save);
            System.out.println("Jogo salvo com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao salvar o jogo: " + e.getMessage());
        }
    }

    // Carregar um jogo salvo
    private void carregarJogo() {
        try {
            Save save = saveDAO.loadsave(jogador.getId());
            if (save != null) {
                jogador.setId(save.getCenarioId());
                inventario = save.getItens();
                System.out.println("Jogo carregado com sucesso.");
            } else {
                System.out.println("Nenhum jogo salvo encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao carregar o jogo: " + e.getMessage());
        }
    }

    // Reiniciar o jogo
    private void reiniciarJogo() {
        jogador.setId(1);
        inventario.clear();
        System.out.println("Jogo reiniciado.");
    }
}
