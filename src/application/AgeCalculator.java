package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.time.Period;

public class AgeCalculator extends Application {

    @Override
    public void start(Stage stage) {
        // Création des éléments d'interface utilisateur
        Label nameLabel = new Label("Prénom : ");
        TextField nameField = new TextField();
        Label dobLabel = new Label("Date de naissance : ");
        DatePicker dobPicker = new DatePicker();
        ToggleGroup genderGroup = new ToggleGroup();
        RadioButton maleButton = new RadioButton("Masculin");
        maleButton.setToggleGroup(genderGroup);
        RadioButton femaleButton = new RadioButton("Féminin");
        femaleButton.setToggleGroup(genderGroup);
        Button calculateButton = new Button("Calculer");
        Label resultLabel = new Label();

        // Définition de l'action à effectuer lorsque le bouton est cliqué
        calculateButton.setOnAction(event -> {
            // Récupération des données saisies par l'utilisateur
            String name = nameField.getText();
            LocalDate dob = dobPicker.getValue();

            // Calcul de l'âge à partir de la date de naissance
            int age = Period.between(dob, LocalDate.now()).getYears();

            // Affichage du résultat
            resultLabel.setText(name + ", vous avez " + age + " ans.");
        });

        // Création de la mise en page de l'interface utilisateur
        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(20, 10, 20, 20));
        root.addRow(0, nameLabel, nameField);
        root.addRow(1, dobLabel, dobPicker);
        root.addRow(2, calculateButton);
        root.addRow(3, resultLabel);

        // Affichage de l'interface utilisateur
        Scene scene = new Scene(root, 350, 300);
        stage.setTitle("Calculateur d'âge");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}