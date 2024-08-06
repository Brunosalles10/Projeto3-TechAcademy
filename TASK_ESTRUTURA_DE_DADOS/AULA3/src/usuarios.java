import java.util.Date;

public class usuarios {
    public String users;
    public String name;
    public String sobrenome;
    public Integer salarios;
    public Date dataNascimento;

    public usuarios() {
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Integer getSalarios() {
        return salarios;
    }

    public void setSalarios(Integer salarios) {
        this.salarios = salarios;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
