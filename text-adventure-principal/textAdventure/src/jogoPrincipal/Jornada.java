package jogoPrincipal;

import com.google.gson.Gson;
import repository.JogadorDAO;
import repository.Mysql;
import repository.HistoriaDAO;
import repository.SaveDAO;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import static spark.Spark.*;

public class Jornada {
    private static final Gson gson = new Gson();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Connection conn = Mysql.getConnection();
        JogadorDAO jogadorDAO = new JogadorDAO(conn);
        HistoriaDAO historiaDAO = new HistoriaDAO(conn);
        SaveDAO saveDAO = new SaveDAO(conn);
        Jogador jogador = new Jogador();
        Comandos comandos = new Comandos(conn, jogador);




        get("/historias", (req, res) -> {
            List<Historia> historias = historiaDAO.getAllHistorias();
            return gson.toJson(historias);
        });


        get("/jogadores", (req, res) -> {
            List<Jogador> jogadores = jogadorDAO.getAllJogadores();
            return gson.toJson(jogadores);
        });

        post("/saves", (req, res) -> {
            Save save = gson.fromJson(req.body(), Save.class);
            saveDAO.insertSave(save);
            res.status(201);
            return "Save realizado com sucesso!";
        });

        get("/saves/:jogadorId", (req, res) -> {
            int jogadorId = Integer.parseInt(req.params(":jogadorId"));
            List<Save> saves = saveDAO.findAllSavesByJogador(jogadorId);
            return gson.toJson(saves);
        });

         while (true) {
            System.out.println("Digite um comando:");
            String comando = sc.nextLine();
            comandos.processarComando(comando);
        }




    }






}



