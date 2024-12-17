package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {

    @Test
    public void testAddCommande() {
        Client client = new Client(1, "John Doe", "123 Street");
        Commande commande = new Commande(2, LocalDate.now(), client);

        client.addCommande(commande);

        assertEquals(1, client.getCommandes().size());
        assertTrue(client.getCommandes().contains(commande));
    }

    @Test
    public void testGetCommandes() {
        Client client = new Client(1, "Jane Doe", "456 Avenue");
        assertTrue(client.getCommandes().isEmpty(), "The commandes list should be empty initially");
    }

    @Test
    public void testMoyenne() {
        Client client = new Client(3, "Alice", "789 Boulevard");
        Commande c1 = new Commande(1, LocalDate.now(), client);
        Commande c2 = new Commande(2, LocalDate.now(), client);

        c1.addProduit(new Produit(1, "Table", 50.0, 10));
        c1.addProduit(new Produit(2, "Chair", 30.0, 20));
        c2.addProduit(new Produit(3, "Lamp", 20.0, 5));

        client.addCommande(c1);
        client.addCommande(c2);

        double expectedMoyenne = (80.0 + 20.0) / 2;
        assertEquals(expectedMoyenne, Main.moyenne(client), 0.01);
    }
}