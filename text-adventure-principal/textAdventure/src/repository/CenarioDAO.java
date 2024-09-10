package repository;

import jogoPrincipal.Cenario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CenarioDAO {
    private Connection connection;
    public CenarioDAO(Connection connection){
        this.connection = connection;
    }

    public List<Cenario> getAllCenarios() throws Exception{
        List<Cenario> cenarios = new ArrayList<>();
        String sql = "SELECT id, titulo, conteudo, jogador_id, cenario_id FROM cenario";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            Cenario cenario = new Cenario();
            cenario.setIdHistoria(rs.getInt("id"));
            cenario.setTitulo(rs.getString("titulo"));
            cenario.setConteudo(rs.getString("conteudo"));
            cenario.setJogadorId(rs.getInt("jogador_id"));
            cenario.setCenarioId(rs.getInt("cenario_id"));
            cenarios.add(cenario);
        }
        rs.close();
        stmt.close();
        return cenarios;
    }

    public Object getAllCenarios(Cenario cenarioId) {
        return null;
    }
}
