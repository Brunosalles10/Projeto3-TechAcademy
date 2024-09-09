package jogoPrincipal;

import java.util.List;

public class Jogador {
    private Integer idNome;
    private String nome;

    public Jogador() {
    }

    public Jogador(Integer idNome,String nome) {
        this.nome = nome;
    }

    public Integer getIdNome() {
        return idNome;
    }

    public void setIdNome(Integer idNome) {
        this.idNome = idNome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



}
