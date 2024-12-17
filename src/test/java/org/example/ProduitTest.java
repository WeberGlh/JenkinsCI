package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class ProduitTest {

    @Test
    public void testAddCommande() {
        Produit produit = new Produit(1, "Table", 100.0, 5);
        Commande commande = new Commande(1, LocalDate.now(), new Client(1, "John Doe", "123 Street"));

        produit.addCommande(commande);

        assertEquals(1, produit.getCommandes().size());
        assertTrue(produit.getCommandes().contains(commande));
    }

    @Test
    public void testSetStock() {
        Produit produit = new Produit(2, "Chair", 50.0, 20);

        produit.setStock(15);

        assertEquals(15, produit.getStock());
    }

    @Test
    public void testGetPrix() {
        Produit produit = new Produit(3, "Lamp", 20.0, 10);

        assertEquals(20.0, produit.getPrix());
    }
}