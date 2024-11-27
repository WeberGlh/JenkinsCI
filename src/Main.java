import org.postgresql.ds.PGSimpleDataSource;

import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {
        PGSimpleDataSource ds = new PGSimpleDataSource();
        ds.setServerName("iutinfo-sgbd");
        ds.setPortNumber(5432);
        ds.setDatabaseName("iutinfo279");
        ds.setUser("iutinfo279");
        ds.setPassword("wA/jbzlQ");
        ArrayList<Films> films = new ArrayList<Films>();
        try (Connection con = ds.getConnection()) {
            String sql = "SELECT * FROM films";
            ResultSet rs = con.createStatement().executeQuery(sql);
            while (rs.next()) {
                films.add(new Films(rs.getInt("id"), rs.getInt("year"), rs.getInt("length"), rs.getString("title"), rs.getString("subject"), rs.getString("director"), rs.getInt("popularity"), rs.getInt("awards")));
            }
        }
        ArrayList<Actors> actors = new ArrayList<Actors>();
        try (Connection con = ds.getConnection()) {
            String sql = "SELECT * FROM actors";
            ResultSet rs = con.createStatement().executeQuery(sql);
            while (rs.next()) {
                actors.add(new Actors(rs.getInt("id"), rs.getString("name")));
            }
        }
        ArrayList<Client> clients = new ArrayList<Client>();
        try (Connection con = ds.getConnection()) {
            String sql = "SELECT * FROM client";
            ResultSet rs = con.createStatement().executeQuery(sql);
            while (rs.next()) {
                clients.add(new Client(rs.getString("login"), rs.getString("password"), rs.getString("nom"), rs.getString("prenom"), rs.getString("adresse")));
            }
        }
        SearchClientById searchClientById = new SearchClientById(clients);
        SearchFilmById searchFilmById = new SearchFilmById(films);
        ArrayList<Location> locations = new ArrayList<Location>();
        try (Connection con = ds.getConnection()) {
            String sql = "SELECT * FROM location";
            ResultSet rs = con.createStatement().executeQuery(sql);
            while (rs.next()) {
                locations.add(new Location(rs.getInt("id"), rs.getDate("dateLocation"), rs.getDate("dateExpedition"), rs.getDate("dateRetour"), searchClientById.searchById(rs.getString("login")), searchFilmById.searchById(rs.getInt("idFilm"))));
            }
        }
        BDD bdd = new BDD(films, actors, clients, locations);
        bdd.searchActorsByName("Harrison");
    }
}
