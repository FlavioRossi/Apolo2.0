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
    private int numProceso = 0;
    
    private Procesos_bar(){
        procesos = new ArrayList<Procesos_bar_item>();
    }
    
    public static Procesos_bar getInstance(){
        if (procesos_bar == null){
            procesos_bar = new Procesos_bar();
        }
        return procesos_bar;
    }
    
    public Integer nuevoProceso(String nombre, int porc){
        numProceso++;
        Procesos_bar_item proceso = new Procesos_bar_item(nombre, porc, numProceso);
        procesos.add(proceso);
        getChildren().add(proceso);
        return numProceso;
    }
    
    public boolean finalizaProceso(int id){
        for(Procesos_bar_item proceso : procesos){
            if (id == proceso.getIdProceso()){
                procesos.remove(proceso);
                getChildren().remove(proceso);
                return true;
            }
        }
        return false;
    }
    
    public boolean porcProceso(int id, int porc){
        for(Procesos_bar_item proceso : procesos){
            if (id == proceso.getIdProceso()){
                proceso.setPorc(porc);
                return true;
            }
        }
        return false;
    }
    public int getPorc(int id){
        for(Procesos_bar_item proceso : procesos){
            if (id == proceso.getIdProceso()){
                return proceso.getPorc();
            }
        }
        return 0;
    }
}
