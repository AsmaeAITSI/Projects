package application.employee;

import javafx.application.Application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class InterfaceEmployee extends Application {

    @Override
    public void start(Stage stage) {

        // Création de MenuBar
        MenuBar menuBar = new MenuBar();

        // Creation des menus
        Menu fichierMenu = new Menu("Fichier");
        Menu editionMenu = new Menu("Edition");
        Menu aideMenu = new Menu("Aide");

        // Creation des MenuItems du menu Fichier
        MenuItem nouveauItem = new MenuItem("Nouveau");
        MenuItem ouvrirItem = new MenuItem("Ouvrir");
        MenuItem quitterItem = new MenuItem("Quitter");
        // Creation des MenuItems du menu Edition
        MenuItem copierItem = new MenuItem("Copier");
        MenuItem collerItem = new MenuItem("Coller");

        // Ajouter les menuItems aux Menus
        fichierMenu.getItems().addAll(nouveauItem, ouvrirItem, quitterItem);
        editionMenu.getItems().addAll(copierItem, collerItem);

        // Ajouter les menus à la barre de menus
        menuBar.getMenus().addAll(fichierMenu, editionMenu, aideMenu);

        Label label = new Label();




        ouvrirItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                //FileChooser fileChooser = new FileChooser();
                String path = "src/application/employee/employes.txt";
                //String path = String.valueOf(fileChooser.showOpenDialog(stage));
                LesEmployes lesEmployes = new LesEmployes(path);
                label.setText(lesEmployes.fabriqueChaine());

            }
        });

        quitterItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });



        BorderPane root = new BorderPane();
        root.setTop(menuBar);
        root.setLeft(label);
        Scene scene = new Scene(root, 350, 200);

        stage.setTitle("Menu Exemple avec fichier");
        stage.setScene(scene);
        stage.show();
    }






    public static void main(String[] args) {
        Application.launch(args);
    }

}

