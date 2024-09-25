package jogoPrincipal;


public class Save {


    private Integer idSave;
    private Cenario cenaAtual;

    public Integer getIdSave() {
        return idSave;
    }

    public void setIdSave(Integer idSave) {
        this.idSave = idSave;
    }

    public Cenario getCenaAtual() {
        return cenaAtual;
    }

    public void setCenaAtual(Cenario cenaAtual) {
        this.cenaAtual = cenaAtual;
    }

    @Override
    public String toString() {
        return "Save{" +
                "idSave=" + idSave +
                ", cenaAtual=" + cenaAtual +
                '}';
    }
}

