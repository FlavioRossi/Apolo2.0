/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import static java.lang.Double.MAX_VALUE;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import static javafx.scene.layout.Priority.ALWAYS;

/**
 *
 * @author FLAVIO
 */
public final class Procesos_bar_item extends HBox{
    private Label nombre;
    private ProgressBar proceso;

    public Procesos_bar_item(String nombre, int porc) {
        this.nombre = new Label(nombre);
        this.nombre.setMaxHeight(MAX_VALUE);
        this.nombre.setMaxWidth(MAX_VALUE);
        this.nombre.setAlignment(Pos.CENTER_RIGHT);
        setHgrow(this.nombre, ALWAYS);
        
        this.proceso = new ProgressBar((float)porc / 10);
        
        getChildren().addAll(this.nombre, this.proceso);
        setPadding(new Insets(5,5,5,5));
        setSpacing(5);
    }
    
    public void setPorc(int porc){
        this.proceso.setProgress((float)porc / 10);
    }
    public int getPorc(){
        return (int) this.proceso.getProgress() * 10;
    }
    
}
