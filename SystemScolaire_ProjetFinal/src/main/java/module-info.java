module com.example.systemscolaire_projetfinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;


    opens com.example.systemscolaire_projetfinal to javafx.fxml;
    exports com.example.systemscolaire_projetfinal;
}