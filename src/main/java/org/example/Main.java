package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void insertion(List<Client> clients, List<Produit> produits, List<Commande> commandes) {
        // Produits
        Produit chaise = new Produit(1, "chaise", 7.99, 40);
        Produit table = new Produit(2, "table", 24.99, 30);
        Produit lampe = new Produit(3, "lampe", 19.99, 25);
        Produit lit = new Produit(4, "lit", 99.99, 10);
        Produit tableDeChevet = new Produit(5, "table de chevet", 14.99, 35);
        Produit bureau = new Produit(6, "bureau", 49.99, 15);

        produits.add(chaise);
        produits.add(table);
        produits.add(lampe);
        produits.add(lit);
        produits.add(tableDeChevet);
        produits.add(bureau);

        // Clients
        Client guilhem = new Client(1, "Guilhem", "Obies");
        Client cyran = new Client(2, "Cyran", "Bavay");
        Client tristan = new Client(3, "Tristan", "Houdain");

        clients.add(guilhem);
        clients.add(cyran);
        clients.add(tristan);

        // Commandes
        Commande c1 = new Commande(1, LocalDate.of(2024, 1, 14), guilhem);
        Commande c2 = new Commande(2, LocalDate.of(2024, 1, 24), cyran);
        Commande c3 = new Commande(3, LocalDate.of(2024, 1, 17), tristan);

        commandes.add(c1);
        commandes.add(c2);
        commandes.add(c3);

        // Association des produits et commandes
        c1.addProduit(chaise);
        c1.addProduit(bureau);
        guilhem.addCommande(c1);

        c2.addProduit(table);
        c2.addProduit(lampe);
        cyran.addCommande(c2);

        c3.addProduit(lit);
        c3.addProduit(tableDeChevet);
        tristan.addCommande(c3);
    }

    public static double moyenne(Client client) {
        double total = 0.0;
        for (Commande commande : client.getCommandes()) {
            total += commande.calculerTotal();
        }
        return client.getCommandes().isEmpty() ? 0 : total / client.getCommandes().size();
    }

    public static void printClientOrders(Client client) {
        System.out.println("Client: " + client.getNom());
        for (Commande commande : client.getCommandes()) {
            System.out.println("  Commande #" + commande.getIdC() + " - Total: " + commande.calculerTotal());
            for (Produit produit : commande.getProduits()) {
                System.out.println("    Produit: " + produit.getNom() + " - Prix: " + produit.getPrix());
            }
        }
    }

    public static void main(String[] args) {
        List<Client> clients = new ArrayList<>();
        List<Produit> produits = new ArrayList<>();
        List<Commande> commandes = new ArrayList<>();

        // Initialisation des données
        insertion(clients, produits, commandes);

        // Exemple de calcul
        Client guilhem = clients.get(0); // Premier client
        double moyenneGuilhem = moyenne(guilhem);
        System.out.println("Moyenne des commandes pour Guilhem : " + moyenneGuilhem);

        Commande c2 = commandes.get(1); // Deuxième commande
        double totalC2 = c2.calculerTotal();
        System.out.println("Total de la commande 2 : " + totalC2);

        // Affichage détaillé des commandes d'un client
        printClientOrders(guilhem);
    }
}
