/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmltableview;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author usuario
 */
public class FXMLTableView extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Introducimos el titulo de la stage
        primaryStage.setTitle("FXML TableView Example");
        //Incluimos el layout, en este caso Pane que vendrá proporcionado por el fxml.
        Pane myPane = (Pane)FXMLLoader.load(getClass().getResource("fxml_tableview.fxml"));
        
        //Creamos la escena con el layout principal
        Scene myScene = new Scene(myPane);
        //Añadimos la escena a la ventana
        primaryStage.setScene(myScene);
        //Mostramos la stage
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
