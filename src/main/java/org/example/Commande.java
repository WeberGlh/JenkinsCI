package org.example;

import javax.persistence.*;

import java.util.ArrayList;
import java.time.LocalDate;

@Entity
@Table(name = "Commande")
public class Commande {
    @Id
    @GeneratedValue
    private int idC;
    @Column(name = "dateC")
    private LocalDate dateC;
    @ManyToOne
    private Client client;
    @ManyToMany
    private static ArrayList<Produit> produits = new ArrayList<Produit>();

    public Commande(int idC, LocalDate dateC, Client client) {
        this.idC = idC;
        this.dateC = dateC;
        this.client = client;
    }

    public Commande() {
    }

    public int getIdC() {
        return idC;
    }

    public LocalDate getDateC() {
        return dateC;
    }

    public void setDateC(LocalDate dateC) {
        this.dateC = dateC;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ArrayList<Produit> getProduits() {
        return produits;
    }

    public void addProduit(Produit p) {
        produits.add(p);
    }

    public double calculerTotal() {
        double rep = 0;
        for (Produit p : produits) {
            rep += p.getPrix();
        }
        return rep;
    }
}
