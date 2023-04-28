package application.gesteven;

import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.xml.soap.Text;

class BtnEventHandler implements EventHandler<ActionEvent> {

    Ex3 testEventHandler;

    public BtnEventHandler(Ex3 testEventHandler) {
        this.testEventHandler = testEventHandler;
    }


    @Override
    public void handle(ActionEvent ae) {
        //this.testEventHandler.


    }
}


public class Ex3 extends Application {
    private String message ="Vous avez cliqué sur le bouton ===> Bonjour tout le monde !";



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Label message = new Label();
        Button btn = new Button();
        btn.setText("Cliquer ici pour dire 'Bonjour tout le monde !'");




        GridPane root = new GridPane();
        root.setAlignment(Pos.TOP_LEFT);
        root.setHgap(10);
        root.setVgap(50);
        root.setPadding(new Insets(20, 20, 20, 20));
        root.add(btn, 0, 0);
        root.add(message,0 ,1);

        Scene scene = new Scene(root, 350, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello World!");
        primaryStage.show();


        btn.setOnAction(new BtnEventHandler(this));

    }


}




