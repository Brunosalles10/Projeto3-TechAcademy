package jogoPrincipal;

import java.util.List;

public class Cenario {
    private int idHistoria;
    private String titulo;
    private String conteudo;
    private List<Item> itens;
    private int jogadorId;
    private int cenarioId;

    public Cenario() {
    }

    public Cenario(int idHistoria, String titulo, String conteudo, List<Item> itens, int jogadorId, int cenarioId) {
        this.idHistoria = idHistoria;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.itens = itens;
        this.jogadorId = jogadorId;
        this.cenarioId = cenarioId;
    }

    public int getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(int idHistoria) {
        this.idHistoria = idHistoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
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
}
