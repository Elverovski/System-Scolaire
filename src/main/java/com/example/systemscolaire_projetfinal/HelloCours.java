package com.example.systemscolaire_projetfinal;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloCours implements Initializable {
    @FXML
    private TextField nouveauNomCours;
    @FXML
    private TextField nouveauCodeCours;
    @FXML
    private TextField nouveauDescriptionCours;
    @FXML
    private ComboBox listeProfesseurs;
    @FXML
    private ArrayList<Cours> listeCours = new ArrayList<Cours>();
    @FXML
    private ArrayList<Professeur> professeurs = new ArrayList<Professeur>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            lireListeProfesseurs();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    private void lireListeProfesseurs() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String chemin = "src/main/resources/JSON/Professeur.json";
        professeurs = mapper.readValue(new File(chemin), new TypeReference<>(){});

        ArrayList<String> nomCompletProfesseur = new ArrayList<>();
        for (Professeur professeur : professeurs) {
            String nomComplet = professeur.getNom() + " " + professeur.getPrenom();
            nomCompletProfesseur.add(nomComplet);
        }
        listeProfesseurs.getItems().addAll(nomCompletProfesseur);
    }

    @FXML
    public void enregistrerCours() throws IOException {
        String nom = nouveauNomCours.getText();
        String code = nouveauCodeCours.getText();
        String description = nouveauDescriptionCours.getText();
        String professeur = (String) listeProfesseurs.getValue();

        Cours cours = new Cours(nom, code, description, professeur);
        listeCours.add(cours);

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        String chemin = "src/main/resources/JSON/Cours.json";
        File fichierJson = new File(chemin);

        if (fichierJson.exists()) {
            ArrayList<Cours> coursExistant = mapper.readValue(fichierJson, new TypeReference<>() {
            });
            coursExistant.addAll(listeCours);
            mapper.writeValue(fichierJson, coursExistant);
        } else {
            mapper.writeValue(fichierJson, listeCours);
        }
    }

}
