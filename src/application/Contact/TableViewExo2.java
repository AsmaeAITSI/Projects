package application.Contact;

import application.ListView.Personne;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class TableViewExo2 extends Application{

    private ObservableList<Contact> data = getContactList();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        //Création de la table
        TableView<Contact> table = new TableView<Contact>();
        table.setEditable(true);

        Label label = new Label("Liste des contacts");
        label.setFont(new Font("Arial", 20));
 
        //Création des trois colonnes
        TableColumn<Contact, String> prenomCol =
                new TableColumn<Contact, String>("Prénom");
        prenomCol.setMinWidth(100);
        
        //Spécifier comment remplir la donnée pour chaque cellule de cette colonne
        //Ceci se fait en specifiant un "cell value factory" pour cette colonne.
        prenomCol.setCellValueFactory(
                new PropertyValueFactory<Contact, String>("prenom"));
        
        TableColumn<Contact, String> nomCol = new TableColumn<Contact, String>("Nom");
        nomCol.setMinWidth(100);
        //spécifier une préférence de tri pour cette colonne
        //nomCol.setSortType(TableColumn.SortType.ASCENDING);
        //nomCol.setSortType(TableColumn.SortType.DESCENDING);
        
        //Spécifier comment remplir la donnée pour chaque cellule de cette colonne
        //Ceci se fait en specifiant un "cell value factory" pour cette colonne.
        nomCol.setCellValueFactory(
                new PropertyValueFactory<Contact, String>("nom"));
        
        TableColumn<Contact, String> emailCol = new TableColumn<Contact, String>("Email");
        emailCol.setMinWidth(100);

        //Ceci se fait en specifiant un "cell value factory" pour cette colonne.
        emailCol.setCellValueFactory(
                new PropertyValueFactory<Contact, String>("email"));

        //On ajoute les trois colonnes à la table
        table.getColumns().addAll(prenomCol, nomCol, emailCol);

        //On rempli la table avec la liste observable
        table.setItems(data);


        //Spécifier comment remplir la donnée pour chaque cellule de cette colonne
        HBox register = new HBox();
        TextField Prenom = new TextField();
        Prenom.setPromptText("Prenom");
        Prenom.setPrefWidth(80);


        TextField Nom = new TextField();
        Nom.setPromptText("Nom");
        Nom.setPrefWidth(80);

        TextField Email = new TextField();
        Email.setPromptText("Email");
        Email.setPrefWidth(120);

        Button buttonAdd = new Button("Ajouter");
        Button buttonDelete = new Button("Supprimer");


        register.getChildren().addAll(Prenom, Nom, Email, buttonAdd, buttonDelete);
        register.setSpacing(5);

        buttonAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Contact contact = new Contact(Prenom.getText(), Nom.getText(), Email.getText());
                table.getItems().add(contact);
                System.out.println(data);

            }

        });

        buttonDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Contact elementSelectionne = table.getSelectionModel().getSelectedItem();
                if (elementSelectionne != null) {
                    table.getItems().remove(elementSelectionne);
                    System.out.println(data);
                }
            }

        });

 
        //On place le label et la table dans une VBox
        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.getChildren().addAll(label, table, register);
 
        Scene scene = new Scene(vbox);
        stage.setTitle("TableView - Deuxième exercice");
        stage.setWidth(500);
        stage.setHeight(300);
        stage.setScene(scene);
        stage.show();



    }

    private ObservableList<Contact> getContactList() {

        Contact contact1 = new Contact("Louis", "bleriot", "bleriot@gmail.com");
        Contact contact2 = new Contact("Hélène", "boucher", "boucher@gmail.com");
        Contact contact3 = new Contact("Jean", "mermoz", "mermoz@gmail.com");
        ObservableList<Contact> list = FXCollections.observableArrayList(contact1,
                contact2, contact3);
        return list;
    }

}

