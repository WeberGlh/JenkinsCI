package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void testInsertion() {
        List<Client> clients = new ArrayList<>();
        List<Produit> produits = new ArrayList<>();
        List<Commande> commandes = new ArrayList<>();

        Main.insertion(clients, produits, commandes);

        assertEquals(3, clients.size());
        assertEquals(6, produits.size());
        assertEquals(3, commandes.size());
    }

    @Test
    public void testMoyenne() {
        List<Client> clients = new ArrayList<>();
        List<Produit> produits = new ArrayList<>();
        List<Commande> commandes = new ArrayList<>();

        Main.insertion(clients, produits, commandes);

        Client client = clients.get(0);
        double moyenne = Main.moyenne(client);

        assertTrue(moyenne > 0, "Moyenne should be greater than zero for a client with orders");
    }
}
