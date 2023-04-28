package application;
import java.io.FileInputStream;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
    
    public class MenuEx2EtEx3 extends Application {
     
        @Override
        public void start(Stage stage) throws Exception{
     
            // MenuBar
            MenuBar menuBar = new MenuBar();
     
            // menus
            Menu fichierMenu = new Menu("Fichier");
            Menu editionMenu = new Menu("Edition");
            Menu projetMenu = new Menu("Projet");
            Menu aideMenu = new Menu("Aide");
     
            // MenuItems pour le menu Fichier
            //MenuItem Nouveau
            MenuItem nouveauItem = new MenuItem("Nouveau");
            //Ajouter une image au texte du menuItem
            FileInputStream input = new FileInputStream("src/application/images/new1.jpg");
	        Image nouveauImage = new Image(input); 
            nouveauItem.setGraphic(new ImageView(nouveauImage));  //option1
            
            //MenuItem Ouvrir
            MenuItem ouvrirItem = new MenuItem("Ouvrir");
            
            //SeparatorMenuItem.
            SeparatorMenuItem separator= new SeparatorMenuItem();
            
            //MenuItem Quitter
            MenuItem quitterItem = new MenuItem("Quitter");     
         // Spécifier un raccourci clavier au menuItem Quitter.
           quitterItem.setAccelerator(KeyCombination.keyCombination("Ctrl+Q")); // option2
         // Gestion du click sur le menuItem Quitter.
           quitterItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                	Platform.exit();
                }
            });
           
            
            // MenuItems pour le menu Edition
            MenuItem copierItem = new MenuItem("Copier");
            MenuItem collerItem = new MenuItem("Coller");
            
            // MenuItems pour le menu Projet
            // CheckMenuItem
            CheckMenuItem genererItem = new CheckMenuItem("Générer la Javadoc"); //option4
            genererItem.setSelected(true);
            CheckMenuItem annotationItem = new CheckMenuItem("Afficher les annotations"); // option3
            annotationItem.setSelected(true);
     
            // MenuItems pour le menu Aide
            // RadioMenuItem
            RadioMenuItem aideItem1 = new RadioMenuItem("Aide Contextuelle");
            RadioMenuItem aideItem2 = new RadioMenuItem("Aide par mot clé");
            ToggleGroup group = new ToggleGroup();
            aideItem1.setToggleGroup(group);
            aideItem2.setToggleGroup(group);
            aideItem1.setSelected(true);
                      
            // Ajouter les menuItems aux Menus
            fichierMenu.getItems().addAll(nouveauItem, ouvrirItem,separator, quitterItem);
            editionMenu.getItems().addAll(copierItem, collerItem);
            projetMenu.getItems().addAll(genererItem,annotationItem);
            aideMenu.getItems().addAll(aideItem1,aideItem2);
     
            // Ajouter les Menus au MenuBar
            menuBar.getMenus().addAll(fichierMenu, editionMenu, projetMenu, aideMenu);
     
            BorderPane root = new BorderPane();
            root.setTop(menuBar);
            Scene scene = new Scene(root, 350, 200);
     
            stage.setTitle("Menu - Exemple2 (image, check, radio)");
            stage.setScene(scene);
            stage.show();
        }  
        public static void main(String[] args) {
            Application.launch(args);
        }
     
    }

