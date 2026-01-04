package com.example.systemscolaire_projetfinal;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.SerializationFeature;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloProfesseur implements Initializable {

    @FXML
    private Button btnEnregistrerProfesseur;
    @FXML
    private TextField nouveauNomProfesseur;
    @FXML
    private TextField nouveauPrenomProfesseur;
    @FXML
    private TextField nouveauIdentifiantProfesseur;
    @FXML
    private TextField nouveauSalaireProfesseur;
    @FXML
    private ArrayList<Professeur> listeProfesseurs = new ArrayList<Professeur>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    ObservableList list = FXCollections.observableArrayList();

    @FXML
    public void enregistrerProfesseur() throws IOException {
        String nom = nouveauNomProfesseur.getText();
        String prenom = nouveauPrenomProfesseur.getText();
        String identifiant = nouveauIdentifiantProfesseur.getText();
        double salaire = Double.parseDouble(nouveauSalaireProfesseur.getText());

        Professeur professeur = new Professeur(nom, prenom, identifiant, salaire);
        listeProfesseurs.add(professeur);

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        String chemin = "src/main/resources/JSON/Professeur.json";
        File fichierJson = new File(chemin);

        if (fichierJson.exists()) {
            ArrayList<Professeur> professeurExistant = mapper.readValue(fichierJson, new TypeReference<>(){});
            professeurExistant.addAll(listeProfesseurs);
            mapper.writeValue(fichierJson, professeurExistant);
        } else {
            mapper.writeValue(fichierJson, listeProfesseurs);
        }
    }
}














