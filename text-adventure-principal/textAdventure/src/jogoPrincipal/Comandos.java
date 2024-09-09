package jogoPrincipal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import repository.ItemDAO;
import repository.SaveDAO;
import repository.JogadorDAO;
import repository.CenarioDAO;
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


    public void processarComando(String comando) {
        Scanner scanner = new Scanner(System.in);

        switch (comando.toUpperCase()) {
            case "HELP":
                exibirMenuAjuda();
                break;
            case "USE ITEM":
                System.out.println("Digite o nome do item para usar:");
                String item = scanner.nextLine();
                usarItem(item);
                break;
            case "CHECK":
                checkDescricaoCena();
                break;
            case "GET":
                System.out.println("Digite o nome do item para pegar:");
                String itemNome = scanner.nextLine();
                pegarItem(itemNome);
                break;
            case "INVENTÁRIO":
                exibirInventario();
                break;
            case "USE":
                System.out.println("Digite o nome do item para usar:");
                String itemDoInventario = scanner.nextLine();
                usarItemInventario(itemDoInventario);
                break;
            case "SAVE":
                salvarJogo();
                break;
            case "LOAD":
                carregarJogo();
                break;
            case "RESTART":
                reiniciarJogo();
                break;
            default:
                System.out.println("Comando não reconhecido.");
                break;
        }
    }

    // Exibe o menu de ajuda
    private void exibirMenuAjuda() {
        System.out.println("Comandos disponíveis:\n" +
                "• HELP: exibe o menu de ajuda do jogo\n" +
                "• USE ITEM: interage com o item da cena\n" +
                "• CHECK: mostra a descrição do objeto na cena\n" +
                "• GET: adiciona o item ao inventário\n" +
                "• INVENTÁRIO: mostra os itens que estão no inventário\n" +
                "• USE: realiza a ação utilizando um item do inventário\n" +
                "• SAVE: salva o jogo\n" +
                "• LOAD: carrega um jogo salvo\n" +
                "• RESTART: reinicia o jogo");
    }

    // Usar um item na cena
    private void usarItem(String nomeItem) {
        try {
            List<Item> item = itemDAO.findItemByName(nomeItem);

            if (item != null) {
                System.out.println("Você usou o item: " + " ");
                // Lógica para usar o item
            } else {
                System.out.println("Item não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao usar o item: " + e.getMessage());
        }
    }

    // Mostrar descrição da cena atual
    private void checkDescricaoCena() {
        try {
            List<Cenario> cenario = cenarioDAO. getAllCenarios(jogador.getIdNome());
            if (cenario != null) {
                System.out.println("Descrição da cena: " + " ");
            } else {
                System.out.println("Cenário não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar descrição da cena: " + e.getMessage());
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
            save.setJogadorId(jogador.getIdNome());
            save.setCenarioId(jogador.getIdNome());
            save.setItens(inventario);
            saveDAO.insertSave(save);
            System.out.println("Jogo salvo com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao salvar o jogo: " + e.getMessage());
        }
    }

    // Carregar um jogo salvo
    private void carregarJogo() {
        try {
            Save save = saveDAO.findSaveById(jogador.getIdNome());
            if (save != null) {
                jogador.setIdNome(save.getCenarioId());
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
        jogador.setIdNome(1); // Exemplo: volta ao cenário inicial
        inventario.clear();
        System.out.println("Jogo reiniciado.");
    }
}
