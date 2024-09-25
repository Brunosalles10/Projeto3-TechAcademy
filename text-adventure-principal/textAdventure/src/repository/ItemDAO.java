package repository;

import jogoPrincipal.Item;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ItemDAO {

    public static Item addInventario(Integer jogador_id, Integer item_id, Integer quantidade,String nome) throws SQLException {
        Item item = new Item();
        PreparedStatement stmt = null;
        Connection conn = Mysql.getConnection();
        String sql = "insert into itens_jogador (jogador_id,item_id,quantidade,nome) values(?,?,?,?)";
        stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1,jogador_id);
        stmt.setInt(2,item_id);
        stmt.setInt(3,quantidade);
        stmt.setString(4,nome);
        int up = stmt.executeUpdate();

        if (up > 0){
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                item.setIdItensJogador(rs.getInt(1));
                item.setIdItem(item_id);
                item.setQuantidade(quantidade);
                item.setNome(nome);
            }

        }

        return item;
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



    public static List<Item> exibirInventario(Integer jogador_id) throws SQLException{
        List<Item> itms = new ArrayList<>();
        Connection coon = Mysql.getConnection();
        String sql = "SELECT * FROM itens_jogador WHERE jogador_id = ?";
        PreparedStatement stmt = coon.prepareStatement(sql);
        stmt.setInt(1,jogador_id);
        ResultSet rs = stmt.executeQuery();

       while (rs.next()){
            Item item = new Item();
            item.setIdItensJogador(rs.getInt("jogador_id"));
            item.setNome(rs.getString("nome"));
            item.setQuantidade(rs.getInt("quantidade"));
            itms.add(item);
        }




        return itms;
    }


}






