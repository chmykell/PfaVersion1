package com.example.chmykel.pfaversion1;

/**
 * Created by chmykel on 30/04/17.
 */

public class Devis {
    //
    private int idproduit;
    private String nom;
    private String description;
    private int reference;
    private int etat;
    private int date_ajout_produit;
    private int id_categ;
    private int id_sous_categ;
    private int prix;

    public int getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(int idproduit) {
        this.idproduit = idproduit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public int getDate_ajout_produit() {
        return date_ajout_produit;
    }

    public void setDate_ajout_produit(int date_ajout_produit) {
        this.date_ajout_produit = date_ajout_produit;
    }

    public int getId_categ() {
        return id_categ;
    }

    public void setId_categ(int id_categ) {
        this.id_categ = id_categ;
    }

    public int getId_sous_categ() {
        return id_sous_categ;
    }

    public void setId_sous_categ(int id_sous_categ) {
        this.id_sous_categ = id_sous_categ;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
}
