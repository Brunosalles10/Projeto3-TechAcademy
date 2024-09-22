package repository;

import jogoPrincipal.Item;
import java.sql.*;


public class ItemDAO {

    public static Item exibirInventario() {

        return new Item();
    }


    public static Item checkItensInventario(Integer id) throws SQLException {

            Item item = new Item();
            Connection conn = Mysql.getConnection();
            String sql = "SELECT * FROM item WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();


            if (rs.next()) {

                item.setIdItem(
                        rs.getInt("id"));
                item.setNome(rs.getString("nome"));
            }



        return item;
    }
}







