package jogoPrincipal;

public class cenario {
    private String descricao;
    private String opcoes;

    public cenario() {
    }

    public cenario(String descricao, String opcoes) {
        this.descricao = descricao;
        this.opcoes = opcoes;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getOpcoes() {
        return opcoes;
    }

    public void setOpcoes(String opcoes) {
        this.opcoes = opcoes;
    }
}
