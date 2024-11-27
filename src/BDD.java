import org.postgresql.ds.PGSimpleDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class BDD {
    private ArrayList<Films> films;
    private ArrayList<Actors> actors;
    private ArrayList<Client> clients;
    private ArrayList<Location> locations;

    public BDD(ArrayList<Films> f, ArrayList<Actors> a, ArrayList<Client> c, ArrayList<Location> l) {
        films = f;
        actors = a;
        clients = c;
        locations = l;
    }

    public void searchActorsByName(String name) {
        PGSimpleDataSource ds = new PGSimpleDataSource();
        ds.setServerName("iutinfo-sgbd");
        ds.setPortNumber(5432);
        ds.setDatabaseName("iutinfo279");
        ds.setUser("iutinfo279");
        ds.setPassword("wA/jbzlQ");
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < actors.size(); i++) {
            String nom = actors.get(i).getName().split(", ")[0];
            if (nom.contains(name)) {
                result.add("\n" + i + ": " + actors.get(i).getName());
            }
        }
        System.out.println(result);
        int choix = 0;
        Scanner sc = new Scanner(System.in);
        if (result.size() > 1) {
            System.out.println("Plusieurs acteurs trouvés, veuillez choisir un numéro :");
            choix = sc.nextInt();
        } else if (result.isEmpty()) {
            System.out.println("Aucun acteur trouvé");
        } else {
            choix = sc.nextInt();
        }
        System.out.println("Acteur choisi : " + actors.get(choix).getName());
        ArrayList<Integer> filmsActeur = new ArrayList<Integer>();
        try (Connection con = ds.getConnection()) {
            String sql = "SELECT * FROM ajoue WHERE idactor = " + actors.get(choix);
            ResultSet rs = con.createStatement().executeQuery(sql);
            while (rs.next()) {
                filmsActeur.add(rs.getInt("idfilm"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Films> films = new ArrayList<Films>();
        SearchFilmById SearchFilmsById = new SearchFilmById(films);
        for (int i: filmsActeur) {
            films.add(SearchFilmsById.searchById(i));
        }
        System.out.println("Films dans lesquels il a joué :");
        for (Films f: films) {
            System.out.println("\n" + f.getTitle());
        }
    }

}
