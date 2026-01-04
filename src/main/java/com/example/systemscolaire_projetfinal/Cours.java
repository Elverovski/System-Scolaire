package com.example.systemscolaire_projetfinal;

public class Cours {
    private String nom;
    private String code;
    private String description;
    private String professeur;



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProfesseur() {
        return professeur;
    }

    public void setProfesseur(String professeur) {
        this.professeur = professeur;
    }

    public Cours(String nom, String code, String description, String professeur){
        this.nom = nom;
        this.code = code;
        this.description = description;
        this.professeur = professeur;
    }

    public Cours(){}
}
