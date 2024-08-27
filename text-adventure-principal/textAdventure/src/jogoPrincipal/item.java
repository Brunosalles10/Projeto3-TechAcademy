package jogoPrincipal;

public class item {
    private String nomeItem;
    private String descricaoItem;

    public item() {
    }

    public item(String nomeItem, String descricaoItem) {
        this.nomeItem = nomeItem;
        this.descricaoItem = descricaoItem;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public String getDescricaoItem() {
        return descricaoItem;
    }

    public void setDescricaoItem(String descricaoItem) {
        this.descricaoItem = descricaoItem;
    }
}
