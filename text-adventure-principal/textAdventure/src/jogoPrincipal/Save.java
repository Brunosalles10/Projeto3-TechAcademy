package jogoPrincipal;

import java.util.List;

public class Save {


    private int id;
    private int jogadorId;
    private int cenarioId;
    private List<Item> itens;
    private String dataSave;

    public Save(int id, int jogadorId, int cenarioId, List<Item> itens, String dataSave) {
        this.id = id;
        this.jogadorId = jogadorId;
        this.cenarioId = cenarioId;
        this.itens = itens;
        this.dataSave = dataSave;
    }

    public Save() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJogadorId() {
        return jogadorId;
    }

    public void setJogadorId(int jogadorId) {
        this.jogadorId = jogadorId;
    }

    public int getCenarioId() {
        return cenarioId;
    }

    public void setCenarioId(int cenarioId) {
        this.cenarioId = cenarioId;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public String getDataSave() {
        return dataSave;
    }

    public void setDataSave(String dataSave) {
        this.dataSave = dataSave;
    }
}

