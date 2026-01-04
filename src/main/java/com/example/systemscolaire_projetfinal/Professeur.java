package com.example.systemscolaire_projetfinal;

public class Professeur extends Personne{

    private Double salaire;

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }

    public Professeur(){
        super();
    }
    public Professeur(String nom, String prenom, String identifiant, Double salaire){
        super(nom, prenom, identifiant);
        this.salaire = salaire;
    };



}
