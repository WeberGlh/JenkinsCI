package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CommandeTest {

    @Test
    public void testAddProduit() {
        Commande commande = new Commande(1, LocalDate.now(), new Client(1, "John Doe", "123 Street"));
        Produit produit = new Produit(1, "Table", 100.0, 5);

        commande.addProduit(produit);

        assertEquals(1, commande.getProduits().size());
        assertTrue(commande.getProduits().contains(produit));
    }

    @Test
    public void testCalculerTotal() {
        Commande commande = new Commande(2, LocalDate.now(), new Client(2, "Jane Doe", "456 Avenue"));
        commande.addProduit(new Produit(1, "Table", 50.0, 10));
        commande.addProduit(new Produit(2, "Chair", 30.0, 20));

        double expectedTotal = 80.0;
        assertEquals(expectedTotal, commande.calculerTotal(), 0.01);
    }

    @Test
    public void testGetClient() {
        Client client = new Client(3, "Alice", "789 Boulevard");
        Commande commande = new Commande(1, LocalDate.now(), client);

        assertEquals(client, commande.getClient());
    }
}