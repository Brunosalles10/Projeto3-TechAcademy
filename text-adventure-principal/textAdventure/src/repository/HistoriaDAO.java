package repository;

import jogoPrincipal.Historia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HistoriaDAO {
    private Connection connection;
    public HistoriaDAO(Connection connection){
        this.connection = connection;
    }

    public List<Historia> getAllHistorias() throws Exception{
        List<Historia> historias = new ArrayList<>();
        String sql = "SELECT id, titulo, conteudo, jogador_id, cenario_id FROM historia";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            Historia historia = new Historia();
            historia.setIdHistoria(rs.getInt("id"));
            historia.setTitulo(rs.getString("titulo"));
            historia.setConteudo(rs.getString("conteudo"));
            historia.setJogadorId(rs.getInt("jogador_id"));
            historia.setCenarioId(rs.getInt("cenario_id"));
            historias.add(historia);
        }
        rs.close();
        stmt.close();
        return historias;
    }
}
