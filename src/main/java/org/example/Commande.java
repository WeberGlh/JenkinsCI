package org.example;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Commande")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idC;

    @Column(name = "dateC")
    private LocalDate dateC;

    @ManyToOne
    @JoinColumn(name = "client_id") // Foreign key column in the Commande table
    private Client client;

    @ManyToMany
    @JoinTable(
        name = "commande_produit", // Join table name
        joinColumns = @JoinColumn(name = "commande_id"), // Foreign key for Commande
        inverseJoinColumns = @JoinColumn(name = "produit_id") // Foreign key for Produit
    )
    private List<Produit> produits = new ArrayList<>();

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

    public List<Produit> getProduits() {
        return produits;
    }

    public void addProduit(Produit p) {
        produits.add(p);
    }

    public double calculerTotal() {
        double total = 0;
        for (Produit p : produits) {
            total += p.getPrix();
        }
        return total;
    }
}
