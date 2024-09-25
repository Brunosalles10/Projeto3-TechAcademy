package jogoPrincipal;

public class Console {
    private String mensagem;
    private Integer idSave;
    private int jogadorid;
    private int cenarioAtual;

    public int getJogadorid() {
        return jogadorid;
    }

    public void setJogadorid(int jogadorid) {
        this.jogadorid = jogadorid;
    }

    public int getCenarioAtual() {
        return cenarioAtual;
    }

    public void setCenarioAtual(int cenarioAtual) {
        this.cenarioAtual = cenarioAtual;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Integer getIdSave() {
        return idSave;
    }

    public void setIdSave(Integer idSave) {
        this.idSave = idSave;
    }
}
