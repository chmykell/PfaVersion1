package com.example.chmykel.pfaversion1;

/**
 * Created by chmykel on 30/04/17.
 */

public class Categorie {



    private int idcategorie;
    private String nomCategorie;
    private String descriptionCategorie;
    private String imgCateg;
    private int etat_categorie;


    public int getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(int idcategorie) {
        this.idcategorie = idcategorie;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public String getDescriptionCategorie() {
        return descriptionCategorie;
    }

    public void setDescriptionCategorie(String descriptionCategorie) {
        this.descriptionCategorie = descriptionCategorie;
    }

    public String getImgCateg() {
        return imgCateg;
    }

    public void setImgCateg(String imgCateg) {
        this.imgCateg = imgCateg;
    }

    public int getEtat_categorie() {
        return etat_categorie;
    }

    public void setEtat_categorie(int etat_categorie) {
        this.etat_categorie = etat_categorie;
    }
}
