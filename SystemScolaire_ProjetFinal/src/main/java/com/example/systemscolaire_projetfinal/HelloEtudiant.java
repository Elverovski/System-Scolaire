package com.example.systemscolaire_projetfinal;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloEtudiant implements Initializable {
    @FXML
    private TextField nouveauNomEtudiant;
    @FXML
    private TextField nouveauPrenomEtudiant;
    @FXML
    private TextField nouveauIdentifiantEtudiant;
    @FXML
    private TextField nouveauCoteREtudiant;
    @FXML
   private ArrayList<Etudiant> listeEtudiants = new ArrayList<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    public void enregistrerEtudiant() throws IOException {
        String nom = nouveauNomEtudiant.getText();
        String prenom = nouveauPrenomEtudiant.getText();
        String identifiant = nouveauIdentifiantEtudiant.getText();
        double coter = Double.parseDouble(nouveauCoteREtudiant.getText());

        Etudiant etudiant  = new Etudiant(nom, prenom, identifiant, coter);
        listeEtudiants.add(etudiant);

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        String chemin = "src/main/resources/JSON/Etudiant.json";
        File fichierJson = new File(chemin);

        if (fichierJson.exists()) {
            ArrayList<Etudiant> etudiantExistant = mapper.readValue(fichierJson, new TypeReference<>(){});
            etudiantExistant.addAll(listeEtudiants);
            mapper.writeValue(fichierJson, etudiantExistant);
        } else {
            mapper.writeValue(fichierJson, listeEtudiants);
        }
    }
}
