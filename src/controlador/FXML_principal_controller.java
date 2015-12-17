/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import lib.Menu_lateralIzq;
import lib.Menu_lateralIzq_item;
import lib.Procesos_bar;

/**
 * FXML Controller class
 *
 * @author FLAVIO
 */
public class FXML_principal_controller implements Initializable {

    //barra inferior de procesos
    @FXML BorderPane borderPane_ppal;
    Procesos_bar procesos;
    //contenido de vistas
    @FXML TabPane tabPane_ppal;
    //barra superior de menu
    @FXML MenuBar menuBar_ppal;
    //barra lateral izquierda de menu
    Menu_lateralIzq menuLateral;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        borderPane_ppal.setTop(null);
        //Creo instancia de procesos
        procesos = Procesos_bar.getInstance();
        borderPane_ppal.setBottom(procesos);
        //procesos.nuevoProceso("Mi primer proceso", -1);
        
        //Menu del proyecto
        ArrayList<Menu_lateralIzq_item> menuItems = new ArrayList<Menu_lateralIzq_item>();
        cargaItems(menuItems);
        menuLateral = new Menu_lateralIzq(borderPane_ppal, borderPane_ppal, menuItems);
        borderPane_ppal.setLeft(menuLateral);
        
        Tab tab_loguin = new Tab("Ingresa a tu cuenta");
        tab_loguin.setClosable(false);
        
        try {
            Parent loguin = FXMLLoader.load(getClass().getResource("/vista/FXML_loguin.fxml"));
            tab_loguin.setContent(loguin);
        } catch (IOException ex) {
            System.out.println("Error al cargar el loguin del usuario");
        }
        tabPane_ppal.getTabs().add(tab_loguin);
    }    
 
    /*
    * Carga menu desde la base de datos
    */
    private void cargaItems(ArrayList<Menu_lateralIzq_item> menuItems){
        Menu_lateralIzq_item item;
        ImageView img;
        for(int i = 0; i < 10; i++){
            img = new ImageView(getClass().getResource("/img/menu.png").toString());  
            item = new Menu_lateralIzq_item(i, "Menu " + i, null, img, null);
            menuItems.add(item);
        }
    }
}