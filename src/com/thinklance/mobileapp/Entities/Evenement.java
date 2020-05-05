/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.mobileapp.Entities;

import com.codename1.l10n.DateFormat;
import java.util.Date;

/**
 *
 * @author Oussema-PC
 */
public class Evenement {
   int id ;
    String nom ;
    String lieu ;
    String description ;
    String datedeb ;
   
    int nbr_place ;
    float prix ;
    String categorie;
    int idadmin;
    

    
    public Evenement()
    {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

 

  

    public int getNbr_place() {
        return nbr_place;
    }

    public void setNbr_place(int nbr_place) {
        this.nbr_place = nbr_place;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(int idadmin) {
        this.idadmin = idadmin;
    }

    public String getDatedeb() {
        return datedeb;
    }

    public void setDatedeb(String datedeb) {
        this.datedeb = datedeb;
    }

    public Evenement(String nom, String lieu, String description, String datedeb, int nbr_place, float prix, String categorie, int idadmin) {
        this.nom = nom;
        this.lieu = lieu;
        this.description = description;
        this.datedeb = datedeb;
        this.nbr_place = nbr_place;
        this.prix = prix;
        this.categorie = categorie;
        this.idadmin = idadmin;
    }

    @Override
    public String toString() {
        return "Evenement{" + "id=" + id + ", nom=" + nom + ", lieu=" + lieu + ", description=" + description + ", datedeb=" + datedeb + ", nbr_place=" + nbr_place + ", prix=" + prix + ", categorie=" + categorie + ", idadmin=" + idadmin + '}';
    }

    
    
}
