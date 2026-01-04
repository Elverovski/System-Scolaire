package com.example.systemscolaire_projetfinal;

public class Etudiant extends Personne{
    private Double coter;

    public Double getCoter() {
        return coter;
    }

    public void setCoter(Double coter) {
        this.coter = coter;
    }

    public Etudiant(){};
    public Etudiant(String nom, String prenom, String identifiant, Double coter) {
        super(nom, prenom, identifiant);
        this.coter = coter;
    }


}
