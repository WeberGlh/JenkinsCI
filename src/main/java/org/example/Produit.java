package org.example;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Produit")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduit;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prix", nullable = false)
    private double prix;

    @Column(name = "stock", nullable = false)
    private int stock;

    @ManyToMany(mappedBy = "produits") // Inverse side of the ManyToMany relationship
    private List<Commande> commandes = new ArrayList<>();

    public Produit(int idProduit, String nom, double prix, int stock) {
        this.idProduit = idProduit;
        this.nom = nom;
        this.prix = prix;
        this.stock = stock;
    }

    public Produit() {
    }

    public int getIdProduit() {
        return idProduit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void addCommande(Commande c) {
        commandes.add(c);
        c.getProduits().add(this); // Ensure bidirectional consistency
    }
}
