package application;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

public class MenuEx2 extends Application {

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
        fichierMenu.getItems().addAll(nouveauItem, editionMenu, ouvrirItem, quitterItem);
        editionMenu.getItems().addAll(copierItem, collerItem);

        // Ajouter les menus à la barre de menus
        menuBar.getMenus().addAll(fichierMenu,  aideMenu);

        BorderPane root = new BorderPane();
        root.setTop(menuBar);
        Scene scene = new Scene(root, 350, 200);

        stage.setTitle("Menu Exemple1");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}

