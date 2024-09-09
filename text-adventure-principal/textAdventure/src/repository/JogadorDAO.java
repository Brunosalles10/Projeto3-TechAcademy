package repository;

import jogoPrincipal.Jogador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JogadorDAO {
    private Connection connection;

    public JogadorDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Jogador> getAllJogadores() throws Exception {
        List<Jogador> jogadores = new ArrayList<>();
        String sql = "SELECT * FROM jogador";

        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            Jogador jogador = new Jogador();
            jogador.setIdNome(rs.getInt("id"));
            jogador.setNome(rs.getString("nome"));

            jogadores.add(jogador);
        }
        rs.close();
        stmt.close();
        return jogadores;

    }
}
