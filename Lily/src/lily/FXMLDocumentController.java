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
    @FXML
    private Circle labyrinthFood;
    
    
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
        System.out.println(labyrinthPlayer.getBoundsInParent());
        System.out.println(labyrinthFood.getBoundsInParent());
        if(event.getCode() == KeyCode.UP){
            labyrinthPlayer.setTranslateY(labyrinthPlayer.getTranslateY()-10);
        }
        else if(event.getCode() == KeyCode.DOWN){
            labyrinthPlayer.setTranslateY(labyrinthPlayer.getTranslateY()+10);
        }
        else if(event.getCode() == KeyCode.LEFT){
            labyrinthPlayer.setTranslateX(labyrinthPlayer.getTranslateX()-10);
        }
        else if(event.getCode() == KeyCode.RIGHT){
            labyrinthPlayer.setTranslateX(labyrinthPlayer.getTranslateX()+10);
        }
        
        if(labyrinthPlayer.getBoundsInParent().getMaxX() == labyrinthFood.getBoundsInParent().getMaxX() && labyrinthPlayer.getBoundsInParent().getMaxY() == labyrinthFood.getBoundsInParent().getMaxY()){
            System.out.println("BØH");
            int newX;
            int newY;
            //Add et point
            do {                
                newX = (int) (Math.random() * 10) * 40;
                newY = (int) (Math.random() * 10) * 40;
                labyrinthFood.setTranslateX(newX);
                labyrinthFood.setTranslateY(newY);
                System.out.println(labyrinthFood.getBoundsInParent().getMaxX());
                System.out.println(labyrinthFood.getBoundsInParent().getMaxY());
            } 
            while ((labyrinthFood.getBoundsInParent().getMaxX() > 842 && labyrinthFood.getBoundsInParent().getMaxX() <0) || (labyrinthFood.getBoundsInParent().getMaxY() > 592 && labyrinthFood.getBoundsInParent().getMaxY()<0));
        }
    }
    
}
