/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import java.util.ArrayList;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author FLAVIO
 */
public class Procesos_bar extends VBox {
    //Patron singleton
    private static Procesos_bar procesos_bar;
    private ArrayList<Procesos_bar_item> procesos;
    
    private Procesos_bar(){
        procesos = new ArrayList<Procesos_bar_item>();
    }
    
    public static Procesos_bar getInstance(){
        if (procesos_bar == null){
            procesos_bar = new Procesos_bar();
        }
        return procesos_bar;
    }
    
    public boolean nuevoProceso(String nombre, int porc){
        Procesos_bar_item proceso = new Procesos_bar_item(nombre, porc);
        procesos.add(proceso);
        getChildren().add(proceso);
        return true;
    }
    
    public boolean finalizaProceso(int id){
        getChildren().remove(procesos.get(id));
        procesos.remove(id);
        return true;
    }
    
    public boolean porcProceso(int id, int porc){
        procesos.get(id).setPorc(porc);
        return true;
    }
    public int getPorc(int id){
        return procesos.get(id).getPorc();
    }
}
