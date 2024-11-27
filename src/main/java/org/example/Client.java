package org.example;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name="Client")
public class Client {
    @Id
    @GeneratedValue
    private int idClient;
    @Column(name="nom")
    private String nom;
    @Column(name="adresse")
    private String adresse;
    @OneToMany
    private static ArrayList<Commande> commandes = new ArrayList<Commande>();

    public Client(int idClient, String nom, String adresse) {
        this.idClient = idClient;
        this.nom = nom;
        this.adresse = adresse;
    }

    public Client() {
    }

    public int getIdClient() {
        return idClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public ArrayList<Commande> getCommandes() {
        return commandes;
    }

    public void addCommande(Commande c) {
        commandes.add(c);
    }
}
