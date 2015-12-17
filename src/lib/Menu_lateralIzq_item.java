package lib;

import java.util.ArrayList;
import javafx.scene.image.ImageView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FLAVIO
 */
public class Menu_lateralIzq_item {
    private int id;
    private String nombre;
    private String fxml;
    private ImageView img;
    private ArrayList<Menu_lateralIzq_item> child;
    private boolean activo;
    private int activo_id; //id del componente activo (tab, scrollpane item, etc)

    public Menu_lateralIzq_item(int id, String nombre, String fxml, ImageView img, ArrayList<Menu_lateralIzq_item> child) {
        this.id = id;
        this.nombre = nombre;
        this.fxml = fxml;
        this.img = img;
        this.child = child;
        this.activo = false;
        this.activo_id = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFxml() {
        return fxml;
    }

    public void setFxml(String fxml) {
        this.fxml = fxml;
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
        this.img.setFitHeight(16);
        this.img.setFitWidth(16);
    }

    public ArrayList<Menu_lateralIzq_item> getChild() {
        return child;
    }

    public void setChild(ArrayList<Menu_lateralIzq_item> child) {
        this.child = child;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getActivo_id() {
        return activo_id;
    }

    public void setActivo_id(int activo_id) {
        this.activo_id = activo_id;
    }
    
}
