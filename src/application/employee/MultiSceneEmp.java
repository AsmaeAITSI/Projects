package application.employee;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultiSceneEmp extends Application {



        Scene scene1, scene2;

        @Override
        public void start(Stage primaryStage) {

            primaryStage.setTitle("Exemple de gestion de plusieurs scènes");

//Spécification de Scene 1
            Label label1= new Label("Je suis sur la première scène");

            Button button1= new Button("Cliquez pour aller sur Scene 2");
            StackPane button1SPane = new StackPane();
            button1SPane.getChildren().add(button1);

//Méthode 4
            button1.setOnAction(new EventHandler<ActionEvent>() {

                public void handle(ActionEvent ae) {
                    primaryStage.setScene(scene2);
                } }

            );

            VBox layout1 = new VBox(20);
            layout1.setAlignment(Pos.CENTER);
            layout1.getChildren().addAll(label1, button1SPane);
            scene1= new Scene(layout1, 300, 240);
//Fin spécification de Scene 1

//Spécification de Scene 2
            Label label2= new Label("Je suis sur la deuxième scène");

            Button button2= new Button("Cliquez pour aller sur Scene 1");
            StackPane button2SPane = new StackPane();
            button2SPane.getChildren().add(button2);


//Méthode 4
            button2.setOnAction(new EventHandler<ActionEvent> () {

                public void handle(ActionEvent ae) {
                    primaryStage.setScene(scene1);
                } }

            );

            VBox layout2= new VBox(20);
            layout2.setAlignment(Pos.CENTER);
            layout2.getChildren().addAll(label2, button2SPane);
            scene2= new Scene(layout2,300,240);
//Fin spécification Scène 2

            primaryStage.setScene(scene1);// Affichage scène1
            primaryStage.show();
        }

        public static void main(String[] args) {
            launch(args);
        }

    }


/*
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
        */

