package repository;
import jogoPrincipal.Cenario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CenarioDAO {
    private final Connection connection;

    public CenarioDAO(Connection connection){
        this.connection = connection;
    }


    public  List<Cenario> getAllCenarios(Integer id) throws Exception {
            List<Cenario> cenas = new ArrayList<>();
            String sql = "select * from cenario where id = ? ";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();


            while (rs.next()) {
                Cenario cena = new Cenario();
                cena.setIdcena(rs.getInt("id"));
                cena.setDescricao(rs.getString("descricao"));
                cena.setProximo_cenario_id(rs.getInt("proximo_cenario_id"));


                cenas.add(cena);
            }
            rs.close();
            stmt.close();
            return cenas;
        }

    }

