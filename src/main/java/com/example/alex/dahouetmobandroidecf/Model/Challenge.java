package com.example.alex.dahouetmobandroidecf.Model;

import java.util.Date;

/**
 * Created by alex on 08/11/17.
 */

public class Challenge {
    int id_challenge;
    String code_challenge;
    String nom_challenge;
    Date date_debut_challenge;
    Date date_fin_challenge;


    public Challenge(int id_challenge, String code_challenge, String nom_challenge, Date date_debut_challenge, Date date_fin_challenge) {
        this.id_challenge = id_challenge;
        this.code_challenge = code_challenge;
        this.nom_challenge = nom_challenge;
        this.date_debut_challenge = date_debut_challenge;
        this.date_fin_challenge = date_fin_challenge;
    }

    public int getId_challenge() {
        return id_challenge;
    }

    public void setId_challenge(int id_challenge) {
        this.id_challenge = id_challenge;
    }

    public String getCode_challenge() {
        return code_challenge;
    }

    public void setCode_challenge(String code_challenge) {
        this.code_challenge = code_challenge;
    }

    public String getNom_challenge() {
        return nom_challenge;
    }

    public void setNom_challenge(String nom_challenge) {
        this.nom_challenge = nom_challenge;
    }

    public Date getDate_debut_challenge() {
        return date_debut_challenge;
    }

    public void setDate_debut_challenge(Date date_debut_challenge) {
        this.date_debut_challenge = date_debut_challenge;
    }

    public Date getDate_fin_challenge() {
        return date_fin_challenge;
    }

    public void setDate_fin_challenge(Date date_fin_challenge) {
        this.date_fin_challenge = date_fin_challenge;
    }

    @Override
    public String toString() {
        return nom_challenge;
    }
}


