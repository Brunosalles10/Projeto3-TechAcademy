package repository;

import jogoPrincipal.Cenario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class CenarioDAO {

    public static Cenario findCenaById(Integer id) throws SQLException {
        Connection conn = Mysql.getConnection();
        String sql = "SELECT * FROM cenario WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Cenario cena = new Cenario();

        if (rs.next()) {
            cena.setIdCena(
                    rs.getInt("id"));
            cena.setDescricao(rs.getString("conteudo"));
        }
        return cena;
    }



}
