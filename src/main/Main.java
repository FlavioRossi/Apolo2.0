/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author FLAVIO
 */
public class Main extends Application{

    Scene scene; // escena principal
    Parent root; // vista principal
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        root = FXMLLoader.load(getClass().getResource("/vista/FXML_principal.fxml"));
        
        scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(getClass().getResource("/css/apoloEstilos.css").toString());
        
        primaryStage.setTitle("Apolo 2.0 - Versión Beta");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
