/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 *
 * @author FLAVIO
 */
public class Menu_lateralIzq extends ScrollPane{
    private boolean procesando = false;
    private boolean activo = false;
    private static final int MENU_ANCHO = 200;
    private static final String TITULO = "SOFTWARE";

    private final Node PARENT, CHILD;

    private final VBox contenedor;
    private final Label lbl_titulo;
    private final HBox contenedor_titulo;
    private final VBox menu;
    private final TextField buscar;

    private final ArrayList<Menu_lateralIzq_item> menuItems;

    public Menu_lateralIzq(Node PARENT, Node CHILD, ArrayList<Menu_lateralIzq_item> menuItems) {
        /*
        *Nodo padre donde va a estar contenido el menu
        */
        this.PARENT = PARENT;
        this.PARENT.addEventFilter(MouseEvent.MOUSE_MOVED, (event)->{
            /*
            * Evento para mostrar y ocultar el menu al posicionarse 
              sobre la esquina arriba-izquierda del nodo padre
            */
            if (!procesando){
                if(!activo && event.getX()< 5 && event.getY() < 50){
                    muestraMenu();
                }else if(activo && event.getX() > MENU_ANCHO){
                    ocultaMenu();
                } 
            }
        });
        /*
        * Nodo hijo donde se mostraran las vistas
        */
        this.CHILD = CHILD;
        /*
        * Items del menu
        */
        this.menuItems = menuItems;
        
        this.setPrefWidth(0);
        this.setMinWidth(USE_PREF_SIZE);
        this.setFitToWidth(true);
        this.setFitToHeight(true);
        this.setHbarPolicy(ScrollBarPolicy.NEVER);
        this.getStyleClass().add("menu_LI");
        
        /*
        * Propiedades contenedor
        */
        contenedor = new VBox();
        contenedor.fillWidthProperty().set(true);
        contenedor.setPrefWidth(MENU_ANCHO);
        contenedor.getStyleClass().add("menu_LI_menu");
        
        /*
        * Titulo del menu
        */
        lbl_titulo = new Label();
        lbl_titulo.getStyleClass().add("menu_LI_titulo");
        lbl_titulo.setText(TITULO);
        lbl_titulo.setMaxWidth(Double.MAX_VALUE);
        
        contenedor_titulo = new HBox(lbl_titulo);
        contenedor_titulo.setMinSize(USE_PREF_SIZE, 30);
        contenedor_titulo.setPrefSize(USE_PREF_SIZE, 30);
        contenedor_titulo.setMaxSize(Double.MAX_VALUE, 30);
        contenedor_titulo.getStyleClass().add("menu_Li_contenedor_titulo");
        
        /*
        * Contenedor menu
        */
        menu = new VBox();
        menu.fillWidthProperty().set(true);
        menu.getStyleClass().add("menu_LI_contenedor");
        
        /*
        * Buscar
        */
        buscar = new TextField();
        buscar.getStyleClass().add("menu_LI_buscar");
        menu.setMargin(buscar, new Insets(0, 0, 5, 0));
        
        /*
        * Arma menu
        */
        menu.getChildren().add(buscar);
        contenedor.getChildren().addAll(contenedor_titulo, menu);
        this.setContent(contenedor);
        
        cargaMenu();
    }
    
    public boolean getActivo(){
        return this.activo;
    }
    public boolean getProcesando(){
        return this.procesando;
    }
    private void setActivo(boolean activo){
        this.activo = activo;
        System.out.println("estado menu: " + this.activo);
    }
    private void setProcesando(boolean procesando){
        this.procesando = procesando;
    }
    
    private void cargaMenu(){
        Label modulo1 = new Label("Modulo 1");
        modulo1.getStyleClass().add("menu_LI_modulo");
        menu.getChildren().add(modulo1);
        
        for (Menu_lateralIzq_item menuItem : menuItems) {
            HBox item1 = new HBox();
            
            Label lbl_item1 = new Label(menuItem.getNombre());
            lbl_item1.setMaxWidth(Double.MAX_VALUE);
            item1.getChildren().add(lbl_item1);
           
            if (menuItem.getChild() != null && menuItem.getChild().size() >= 0) {
                Image img2 = new Image(getClass().getResource("/img/derecha.png").toString());
                ImageView img_item1m = new ImageView(img2);
                img_item1m.setFitHeight(10);
                img_item1m.setFitWidth(10);
                item1.getChildren().add(img_item1m);
            }
            item1.setHgrow(lbl_item1, Priority.ALWAYS);
            item1.setPrefHeight(30);
            item1.setMinHeight(30);
            item1.setMaxHeight(30);
            item1.getStyleClass().add("menu_LI_menuItem");
            menu.getChildren().addAll(item1);
        }
    }
    
    public void muestraMenu(){
        setProcesando(true);
        this.setPrefWidth(0);

        Timeline timeLine = new Timeline();
        timeLine.getKeyFrames().addAll(
            new KeyFrame(Duration.millis(150), 
                new KeyValue(this.prefWidthProperty(), MENU_ANCHO)
            )
        );
        timeLine.play();
        timeLine.setOnFinished((evt)-> {
            setActivo(true);
            setProcesando(false);
        });
    }
    
    public void ocultaMenu(){
        setProcesando(true);
        Timeline timeLine = new Timeline();
        timeLine.getKeyFrames().addAll(
            new KeyFrame(Duration.millis(150),
                new KeyValue(this.prefWidthProperty(), 0)
            )
        );
        timeLine.play();
        timeLine.setOnFinished((evt) -> {
            setActivo(false);
            setProcesando(false);
        });
    }
    /*
    public void click(){
        if (CHILD instanceof TabPane){
            Tab tab = new Tab("nuevo");
            tab.setContent(item1);
            vistas.getTabs().add(tab);
        }
    }
    */
}
