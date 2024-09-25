package jogoPrincipal;



public class Item {
    private Integer idItem;
    private String nome;
    private Integer idItensJogador;
    private Integer quantidade;

    public Integer getIdItensJogador() {
        return idItensJogador;
    }

    public void setIdItensJogador(Integer idItensJogador) {
        this.idItensJogador = idItensJogador;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
