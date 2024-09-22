package repository;

import jogoPrincipal.Item;
import jogoPrincipal.Cenario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {

    public static Item findItemById(Integer id) {
        return new Item();
    }


    public static List<Item> findItensByScene(Cenario cena) throws SQLException {
        Connection connection = Mysql.getConnection();
        String sql = "select * from item i where id = ?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, cena.getIdCena());
        ResultSet resultSet = ps.executeQuery();

        List<Item> itens = new ArrayList<>();
        while (resultSet.next()) {
            Item item = new Item();
            item.setIdItem(resultSet.getInt("id"));
            item.setNome(resultSet.getString("nome"));
            item.setDescricaoPositiva(resultSet.getString("nome"));
            item.setDescricaoNegativa(resultSet.getString("tipo"));
            item.setIdCenaAtual(resultSet.getInt("cenario_id"));


            Integer idCenaAtual = resultSet.getInt("cenario_id");

            item.setIdCenaAtual(idCenaAtual);

            itens.add(item);
        }

        return itens;
    }


    public static List<Item> getItensInventario() throws SQLException {
        List<Item> iten = new ArrayList<>();
        try {
        Connection connection = Mysql.getConnection();
        String sql = "Select * from item;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();


       while (rs.next()) {
           Item itens = new Item();
             itens.setIdItem(
                    rs.getInt("id"));
           itens.setDescricaoPositiva(rs.getString("nome"));
        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return iten;
    }
}






