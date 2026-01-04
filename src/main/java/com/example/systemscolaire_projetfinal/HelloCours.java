package com.example.systemscolaire_projetfinal;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
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
    private ArrayList<Cours> listeCours = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void enregisterCours() throws IOException {
        String nom = nouveauNomCours.getText();
        String code = nouveauCodeCours.getText();
        String description = nouveauDescriptionCours.getText();


        /*Cours cours = new Cours(nom, code, description);
        listeCours.add(cours);*/

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        String chemin = "src/main/resources/JSON/Cours.json";
        File fichierJson = new File(chemin);

        if(fichierJson.exists()) {

        } else {

        }
    }
    
}
