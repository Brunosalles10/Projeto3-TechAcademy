package jogoPrincipal;

public class Cenario {
    private Integer idCena;
    private String descricao;
    private int proximo_cenario_id;

    public Cenario() {

    }

    public Cenario(Integer idcena, String descricao, int proximo_cenario_id) {
        this.idCena = idcena;
        this.descricao = descricao;
        this.proximo_cenario_id = proximo_cenario_id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getProximo_cenario_id() {
        return proximo_cenario_id;
    }

    public void setProximo_cenario_id(int proximo_cenario_id) {
        this.proximo_cenario_id = proximo_cenario_id;
    }

    public Integer getIdcena() {
        return idCena;
    }

    public void setIdcena(Integer idcena) {
        this.idCena = idcena;
    }
}
