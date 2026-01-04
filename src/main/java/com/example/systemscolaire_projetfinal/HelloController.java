package com.example.systemscolaire_projetfinal;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    ObservableList<Professeur> listeProfesseurs = FXCollections.observableArrayList();
    ObservableList<Etudiant> listeEtudiants = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lireProfesseur();
        lireEtudiant();

    }

    ////////////////////////////////////////////////*cours*////////////////////////////////////////////////
    @FXML
    private TableView tableCours;

    @FXML
    private TableColumn<Cours, String> nomCours;

    @FXML
    private TableColumn<Cours, String> codeCours;

    @FXML
    private TableColumn<Cours, String> descriptionCours;

    @FXML
    private TableColumn<Cours, String> professeurCours;

    ////////////////////////*Ajouter un Cours*////////////////////////
    @FXML
    private Button btnAjouterCours;

    @FXML
    private void ajouterUnCours() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ajouter-cours.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 300);
        Stage stage = new Stage();
        stage.setTitle("Ajouter un cours");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    ////////////////////////////////////////////////*Professeurs*////////////////////////////////////////////////
    @FXML
    private TableView tableProfesseurs;

    @FXML
    private TableColumn<Professeur, String> nomProfesseur;
    @FXML
    private TableColumn<Professeur, String> prenomProfesseur;
    @FXML
    private TableColumn<Professeur, String> identifiantProfesseur;
    @FXML
    private TableColumn<Professeur, Double> salaireProfesseur;

    ////////////////////////*Ajouter un Professeur*////////////////////////
    @FXML
    private Button btnAjouterProfesseur;

    @FXML
    public void ajouterUnProfesseur() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ajouter-professeur.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 300);
        Stage stage = new Stage();
        stage.setTitle("Ajouter un professeur");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void lireProfesseur() {
        String chemin = "src/main/resources/JSON/Professeur.json";
        File fichierJson = new File(chemin);

        ObjectMapper mapper = new ObjectMapper();
        if (fichierJson.exists()) {
            try {
                ArrayList<Professeur> professeurs = mapper.readValue(fichierJson, new TypeReference<>(){});
                listeProfesseurs.addAll(professeurs);
                nomProfesseur.setCellValueFactory(new PropertyValueFactory<>("nom"));
                prenomProfesseur.setCellValueFactory(new PropertyValueFactory<>("prenom"));
                identifiantProfesseur.setCellValueFactory(new PropertyValueFactory<>("identifiant"));
                salaireProfesseur.setCellValueFactory(new PropertyValueFactory<>("salaire"));

                tableProfesseurs.setItems(listeProfesseurs);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    ////////////////////////////////////////////////*Etudiants*////////////////////////////////////////////////
    @FXML
    private TableView tableEtudiants;

    @FXML
    private TableColumn<Etudiant, String> nomEtudiant;
    @FXML
    private TableColumn<Etudiant, String> prenomEtudiant;
    @FXML
    private TableColumn<Etudiant, String> identifiantEtudiant;
    @FXML
    private TableColumn<Etudiant, Double> coterEtudiant;

    ////////////////////////*Ajouter un Etudiant*////////////////////////
    @FXML
    private Button btnAjouterEtudiant;

    @FXML
    private void ajouterUnEtudiant() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ajouter-etudiant.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 300);
        Stage stage = new Stage();
        stage.setTitle("Ajouter un etudiant");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void lireEtudiant() {
        String chemin = "src/main/resources/JSON/Etudiant.json";
        File fichierJson = new File(chemin);
        ObjectMapper mapper = new ObjectMapper();

        if (fichierJson.exists()) {
            try {
                ArrayList<Etudiant> etudiants = mapper.readValue(fichierJson, new TypeReference<>(){});
                listeEtudiants.addAll(etudiants);
                nomEtudiant.setCellValueFactory(new PropertyValueFactory<>("nom"));
                prenomEtudiant.setCellValueFactory(new PropertyValueFactory<>("prenom"));
                identifiantEtudiant.setCellValueFactory(new PropertyValueFactory<>("identifiant"));
                coterEtudiant.setCellValueFactory(new PropertyValueFactory<>("coter"));

                tableEtudiants.setItems(listeEtudiants);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}