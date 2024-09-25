package repository;


import java.sql.*;

import jogoPrincipal.Cenario;
import jogoPrincipal.Save;


public class SaveDAO {


    public static Save novoJogo(Integer jogadorId, Integer cenarioId) throws SQLException {
        Connection conn = Mysql.getConnection();
        String sql = "INSERT INTO save (jogador_id,cenario_id) VALUES (?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, jogadorId);
        stmt.setInt(2, cenarioId);
        stmt.executeUpdate();
        ResultSet generatedKeys = stmt.getGeneratedKeys();
        Save save = new Save();
        if (generatedKeys.next()) {
            save.setIdSave(generatedKeys.getInt(1));
            save.setCenaAtual(CenarioDAO.findCenaById(cenarioId));
        }
        return save;
    }

    public static Save carregarJogo(int Id) throws SQLException {
        Save save = new Save();
        Connection conn = Mysql.getConnection();
        String sql = "SELECT s.cenario_id, c.conteudo FROM  save s INNER JOIN cenario c ON s.cenario_id = c.id WHERE s.id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, Id);
        ResultSet rs = stmt.executeQuery();
        Cenario cenario = new Cenario();

        if (rs.next()) {
            save.setIdSave(rs.getInt("id"));
            cenario.setIdCena(rs.getInt("cenario_id"));
            cenario.setDescricao(rs.getString("conteudo"));

        }

        return save;
    }

}


