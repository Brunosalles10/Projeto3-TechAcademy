package repository;


import java.sql.*;
import jogoPrincipal.Save;


public class SaveDAO {


    public static Save novoJogo() throws SQLException {
        Connection conn = Mysql.getConnection();
        String sql = "INSERT INTO save (id) VALUES (1);";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet generatedKeys = stmt.getGeneratedKeys();
        Save save = new Save();
        if(generatedKeys.next()){
            save.setIdSave(generatedKeys.getInt(1));
            save.setCenaAtual(CenarioDAO.findCenaById(1));
        }
        return save;
    }

}


