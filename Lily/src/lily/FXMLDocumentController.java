/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lily;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;

/**
 *
 * @author Kim Christensen
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private Circle labyrinthPlayer;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labyrinthPlayer.requestFocus();
        labyrinthPlayer.setFocusTraversable(true);
    }    

    @FXML
    private void labyrinthPlayerKeyPressed(KeyEvent event) {
        if(event.getCode() == KeyCode.DOWN){
            labyrinthPlayer.setTranslateY(labyrinthPlayer.getTranslateY()-10);
        }
    }
    
}
