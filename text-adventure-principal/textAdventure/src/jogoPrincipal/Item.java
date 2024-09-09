package jogoPrincipal;

public class Item {
    private Integer idItem;
    private String nomeItem;
    private String descricaoItem;

    public Item() {
    }

    public Item(Integer idItem,String nomeItem, String descricaoItem) {
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

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }
}
