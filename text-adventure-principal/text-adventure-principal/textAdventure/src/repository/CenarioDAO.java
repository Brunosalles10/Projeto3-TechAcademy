package repository;

import jogoPrincipal.Cenario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


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

    public static void insertCena(Cenario cena) throws SQLException {
        Connection connection = Mysql.getConnection();
        String insert = "INSERT INTO cenario(conteudo) VALUES (?);";
        PreparedStatement ps = connection.prepareStatement(insert);
        ps.setString(1, cena.getDescricao());
        ps.execute();
    }

    public static List<Cenario> findAll() throws SQLException {
        Connection connection = Mysql.getConnection();
        String sql = "select * from cenario;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();

        List<Cenario> cenas = new ArrayList<>();
        while (resultSet.next()) {
            Cenario cena = new Cenario();
            cena.setIdCena(resultSet.getInt("id"));
            cena.setDescricao(resultSet.getString("conteudo"));

            cenas.add(cena);
        }
        return cenas;
    }


}
