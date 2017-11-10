package com.example.alex.dahouetmobandroidecf.Model;

/**
 * Created by alex on 06/11/17.
 */

public class Classement {


    int id_particip;
    int temps_reel;
    int temps_compense;
    int place;
    int id_regate;
    int id_voilier;
    int id_equipage;
    int id_skipper;
    int id_personne;
    String nom_voilier;
    String num_voilier;
    int id_competiteur;
    int id_classe;
    int id_proprietaire;


    public Classement(int id_particip, int temps_reel, int temps_compense, int place, int id_regate, int id_voilier, int id_equipage, int id_skipper, int id_personne, String nom_voilier, String num_voilier, int id_competiteur, int id_classe, int id_proprietaire) {
        this.id_particip = id_particip;
        this.temps_reel = temps_reel;
        this.temps_compense = temps_compense;
        this.place = place;
        this.id_regate = id_regate;
        this.id_voilier = id_voilier;
        this.id_equipage = id_equipage;
        this.id_skipper = id_skipper;
        this.id_personne = id_personne;
        this.nom_voilier = nom_voilier;
        this.num_voilier = num_voilier;
        this.id_competiteur = id_competiteur;
        this.id_classe = id_classe;
        this.id_proprietaire = id_proprietaire;
    }

    public int getId_regate() {
        return id_regate;
    }

    public void setId_regate(int id_regate) {
        this.id_regate = id_regate;
    }

    public int getId_particip() {
        return id_particip;
    }

    public void setId_particip(int id_particip) {
        this.id_particip = id_particip;
    }

    public int getTemps_reel() {
        return temps_reel;
    }

    public void setTemps_reel(int temps_reel) {
        this.temps_reel = temps_reel;
    }

    public int getTemps_compense() {
        return temps_compense;
    }

    public void setTemps_compense(int temps_compense) {
        this.temps_compense = temps_compense;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public int getId_voilier() {
        return id_voilier;
    }

    public void setId_voilier(int id_voilier) {
        this.id_voilier = id_voilier;
    }

    public int getId_equipage() {
        return id_equipage;
    }

    public void setId_equipage(int id_equipage) {
        this.id_equipage = id_equipage;
    }

    public int getId_skipper() {
        return id_skipper;
    }

    public void setId_skipper(int id_skipper) {
        this.id_skipper = id_skipper;
    }

    public int getId_personne() {
        return id_personne;
    }

    public void setId_personne(int id_personne) {
        this.id_personne = id_personne;
    }

    public String getNom_voilier() {
        return nom_voilier;
    }

    public void setNom_voilier(String nom_voilier) {
        this.nom_voilier = nom_voilier;
    }

    public String getNum_voilier() {
        return num_voilier;
    }

    public void setNum_voilier(String num_voilier) {
        this.num_voilier = num_voilier;
    }

    public int getId_competiteur() {
        return id_competiteur;
    }

    public void setId_competiteur(int id_competiteur) {
        this.id_competiteur = id_competiteur;
    }

    public int getId_classe() {
        return id_classe;
    }

    public void setId_classe(int id_classe) {
        this.id_classe = id_classe;
    }

    public int getId_proprietaire() {
        return id_proprietaire;
    }

    public void setId_proprietaire(int id_proprietaire) {
        this.id_proprietaire = id_proprietaire;
    }

    @Override
    public String toString() {
        return "Place n°" + place +
                "\n Nom_voilier :"+ nom_voilier +
                "\n Temps réel :"+ temps_reel +
                "\n Temps_compensé :"+ temps_compense ;

    }
}
