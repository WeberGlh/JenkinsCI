package org.example;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "Produit")
public class Produit {
    @Id
    @GeneratedValue
    private int idProduit;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prix")
    private double prix;
    @Column(name = "stock")
    private int stock;
    @ManyToMany
    private static ArrayList<Commande> commandes = new ArrayList<Commande>();

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

    public ArrayList<Commande> getCommandes() {
        return commandes;
    }

    public void addCommande(Commande c) {
        commandes.add(c);
    }
}
