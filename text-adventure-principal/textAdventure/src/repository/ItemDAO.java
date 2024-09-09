package repository;

import jogoPrincipal.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {

    private final Connection connection;

    public ItemDAO(Connection connection) {
        this.connection = connection;
    }


    public List<Item> findItemByName(String nome) throws Exception {
        List<Item> items = new ArrayList<>();
        String sql = "SELECT * FROM item WHERE nome = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Item item = new Item();
            item.setIdItem(rs.getInt("id"));
            item.setNomeItem(rs.getString("nome"));
            item.setDescricaoItem(rs.getString("descricao"));

            items.add(item);

        }

        rs.close();
        stmt.close();
        return items;


    }
}


