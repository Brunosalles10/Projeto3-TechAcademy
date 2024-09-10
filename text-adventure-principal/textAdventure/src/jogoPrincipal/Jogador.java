package jogoPrincipal;

public class Jogador {
    private int id;
    private String nome;
    private Cenario cenario_id;

    public Jogador() {
    }

    public Jogador(int id, String nome, Cenario cenario_id) {
        this.id = id;
        this.nome = nome;
        this.cenario_id = cenario_id;
    }

    public Cenario getCenario_id() {
        return cenario_id;
    }

    public void setCenario_id(Cenario cenario_id) {
        this.cenario_id = cenario_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
