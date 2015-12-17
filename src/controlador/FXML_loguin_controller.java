/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import lib.Procesos_bar;

/**
 * FXML Controller class
 *
 * @author FLAVIO
 */
public class FXML_loguin_controller implements Initializable {
    
    @FXML Button btn_proceso;
    Procesos_bar procesos;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        procesos = Procesos_bar.getInstance();
    }

    @FXML
    public void proceso(){
        int id = procesos.nuevoProceso("Mi proceso de otra clase", -1);
        
        Task task2 = new Task() {
            @Override protected Void call() throws Exception {
                for (int i = 1; i <= 10; i++) {
                    final int cont = i;
                    Platform.runLater(()->{
                        procesos.porcProceso(id, cont);
                    });
                    Thread.sleep(1000);
                }
                Platform.runLater(()->{
                    procesos.finalizaProceso(id);
                });
                return null;
            }
        };
        Thread th2 = new Thread(task2);
        th2.start();
    }
}
