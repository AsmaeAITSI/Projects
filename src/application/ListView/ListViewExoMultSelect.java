package application.ListView;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ListViewExoMultSelect extends Application {
	
	 Label resultat;

	   
	   public void start(Stage stage) {
	      
	      // Creation du label.
	      resultat = new Label("Sélections : ");
	      
	    //La méthode createPersonList() est définie en fin de fichier
	      ObservableList<Personne> data =createPersonList();
	      
	      // Creation de la ListView.*******
	      ListView<Personne> listView = new ListView<Personne>();
	      listView.setItems(data);
	      //Permet de pouvoir faire une sélection multiple dans la liste
	      listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	      // the preferred height and width.
	      listView.setPrefSize(150, 120);;
	      
	      //Obtenir une référence sur l'objet SelectionModel.
	     /* MultipleSelectionModel<Personne> lvSelModel = listView.getSelectionModel();
	      
	      lvSelModel.selectedItemProperty().addListener(new ChangeListener<Personne>() {
	         public void changed(ObservableValue<? extends Personne> ov,
	                                  Personne oldVal, Personne newVal) {
	         }
	      });*/

		   Button selItems = new Button("Récupérer la selection");

		   selItems.setOnAction(new EventHandler<ActionEvent>() {
			   @Override
			   public void handle(ActionEvent event) {
				   StringBuffer sb = new StringBuffer();
				   //On récupère les items sélectionnées sous forme de liste
				   ObservableList<Personne> selectedItems =
						   listView.getSelectionModel().getSelectedItems();
				   // Affichage des items sélectionné dans le label resultat.
				   for (int i = 0; i < selectedItems.size(); i++)
					   sb.append("\n " + selectedItems.get(i).toString());

				   resultat.setText("Les items sélectionnés : " + sb.toString());

			   }
		   });

	     
	      // vertical and horizontal gaps of 10.
	      HBox root = new HBox(10);
	      // Centrer the le noeud root dans scene.
	      root.setAlignment(Pos.CENTER);
	      root.getChildren().addAll(listView, selItems );
		  root.setSpacing(10);
	      
	      // Set the Style-properties of the VBox
	        root.setStyle("-fx-padding: 10;" +
	            "-fx-border-style: solid inside;" +
	            "-fx-border-width: 2;" +
	            "-fx-border-insets: 5;" +
	            "-fx-border-radius: 5;" +
	            "-fx-border-color: blue;");
	      
	      // Creation de  la scene.
	      Scene scene = new Scene(root, 300, 220);
	      // placer la scène sur le stage.
	      stage.setScene(scene);
	      stage.setTitle("ListView - Selection multiple");
	      stage.show();
	   }
	   
	// Création de la liste de personnes
	    private ObservableList<Personne> createPersonList() {
	    	 
	    	Personne person1 = new Personne("Louis", "Blériot");
	    	Personne person2 = new Personne("Jean", "Mermoz");
	    	Personne person3 = new Personne("Roland", "Garros");
	    	Personne person4 = new Personne("Antoine", "de Saint-Exupéry");
	    	Personne person5 = new Personne("Hélène", "Boucher");
	    	Personne person6 = new Personne("Maryse", "Bastié");
	 
	        ObservableList<Personne> list = FXCollections.observableArrayList(person1, person2, person3, person4, person5,person6);
	        return list;
	    }
	   
	   public static void main(String[] args) {
		      launch(args);
	   }

}
