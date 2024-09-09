package repository;
import com.google.gson.Gson;
import jogoPrincipal.Item;
import jogoPrincipal.Save;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SaveDAO {
    private final Connection conn;
    private final Gson gson = new Gson();

    public SaveDAO(Connection conn) {
        this.conn = conn;
    }

    //Metodo para salvar o progesso
    public void insertSave(Save save) throws SQLException {
        String sql = "INSERT INTO save(jogador_id, cenario_id, itens) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, save.getJogadorId());
            stmt.setInt(2, save.getCenarioId());
            stmt.setString(3, gson.toJson(save.getItens()));
            stmt.executeUpdate();
        }
    }

    //recupera um save pelo id
    public Save findSaveById(int id) throws SQLException {
        String sql = "SELECT * FROM save WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Save save = new Save();
                    save.setId(rs.getInt("id"));
                    save.setJogadorId(rs.getInt("jogador_id"));
                    save.setCenarioId(rs.getInt("cenario_id"));
                    save.setItens(gson.fromJson(rs.getString("itens"), List.class));
                    save.setDataSave(rs.getString("data_save"));
                    return save;
                }
            }
        }
        return null;
    }

    //lista todos os saves de u, jogador especifico
    public List<Save> findAllSavesByJogador(int jogadorId) throws SQLException {
        String sql = "SELECT * FROM save WHERE jogador_id = ?";
        List<Save> saves = new ArrayList<>();

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, jogadorId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Save save = new Save();
                    save.setId(rs.getInt("id"));
                    save.setJogadorId(rs.getInt("jogador_id"));
                    save.setCenarioId(rs.getInt("cenario_id"));
                    save.setItens(gson.fromJson(rs.getString("itens"), List.class));
                    save.setDataSave(rs.getString("data_save"));
                    saves.add(save);
                }
            }
        }
        return saves;
    }
}

