package jogoPrincipal;

import com.google.gson.Gson;
import repository.JogadorDAO;
import repository.Mysql;
import repository.CenarioDAO;
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
        CenarioDAO cenarioDAO = new CenarioDAO(conn);
        SaveDAO saveDAO = new SaveDAO(conn);
        Jogador jogador = new Jogador();
        Comandos comandos = new Comandos(conn, jogador);




        get("/cenarios", (req, res) -> {
            List<Cenario> cenarios = cenarioDAO.getAllCenarios();
            return gson.toJson(cenarios);
        });


        get("/jogadores", (req, res) -> {
            List<Jogador> jogadores = jogadorDAO.getAllJogadores();
            return gson.toJson(jogadores);
        });


         while (true) {
            System.out.println("Digite um comando:");
            String comando = sc.nextLine();
            comandos.processarComando(comando);
        }




    }






}



