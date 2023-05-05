package application.Multifenetre;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class NouvelleFenetreNone extends Application {

	@Override
	public void start(Stage primaryStage) {

		Button btnOuvrir = new Button();
		btnOuvrir.setText("Cliquez ici pour ouvrir une nouvelle fenêtre");

		btnOuvrir.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				//Construction de la nouvelle fenêtre
				// Ceci pourrait être placé dans une classe séparée
				Label nouvFenetreLbl = new Label("Vous êtes sur la nouvelle fenêtre");
				StackPane nouvFenetreSPane = new StackPane();
				nouvFenetreSPane.getChildren().add(nouvFenetreLbl);
				Scene nouvFenetreScene = new Scene(nouvFenetreSPane, 230, 100);
				// Nouvelle Fenêtre (Stage)
				Stage nouvFenetre = new Stage();
				nouvFenetre.setTitle("Nouvelle Fenêtre");
				nouvFenetre.setScene(nouvFenetreScene);
				// Définir la position de la nouvelle fenetre 
				//relativement à la fenetre principale.
				nouvFenetre.setX(primaryStage.getX() + 200);
				nouvFenetre.setY(primaryStage.getY() + 100);
				//Affichage de la nouvelle fenêtre
				nouvFenetre.show();
			}
		});

		StackPane root = new StackPane();
		root.getChildren().add(btnOuvrir);

		Scene scene = new Scene(root, 450, 250);

		primaryStage.setTitle("Exemple ouverture Fenêtre Non Modale");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
