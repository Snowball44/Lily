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
import Game_data.GameFacade;
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
    int score;
    static GameFacade facade = new GameFacade();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labyrinthPlayer.requestFocus();
        labyrinthPlayer.setFocusTraversable(true);
        score = 0;
    }    

    @FXML
    private void labyrinthPlayerKeyPressed(KeyEvent event) {
        System.out.println(labyrinthPlayer.getBoundsInParent());
        System.out.println(labyrinthFood.getBoundsInParent());
        if(event.getCode() == KeyCode.UP || event.getCode() == KeyCode.W){
            labyrinthPlayer.setTranslateY(labyrinthPlayer.getTranslateY()-5);
        }
        else if(event.getCode() == KeyCode.DOWN || event.getCode() == KeyCode.S){
            labyrinthPlayer.setTranslateY(labyrinthPlayer.getTranslateY()+5);
        }
        else if(event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.A){
            labyrinthPlayer.setTranslateX(labyrinthPlayer.getTranslateX()-5);
        }
        else if(event.getCode() == KeyCode.RIGHT ||event.getCode() == KeyCode.D){
            labyrinthPlayer.setTranslateX(labyrinthPlayer.getTranslateX()+5);
        }
        
        if(labyrinthPlayer.getBoundsInParent().getMaxX() == labyrinthFood.getBoundsInParent().getMaxX() && labyrinthPlayer.getBoundsInParent().getMaxY() == labyrinthFood.getBoundsInParent().getMaxY()){
            System.out.println("BØH");
            score++;
            System.out.println(facade.getWon("Legs"));
            facade.setWon("Legs", true);
            System.out.println(facade.getWon("Legs"));
            System.out.println(score);
            int newX;
            int newY;
            //Add et point
            do {                
                newX = (int) (Math.random() * 10) * 40;
                newY = (int) (Math.random() * 10) * 40;
                labyrinthFood.relocate(newX, newY);
                System.out.println(newX);
                System.out.println(newY);
            } 
            while ((labyrinthFood.getLayoutX() > 842 || labyrinthFood.getLayoutX() <0) || (labyrinthFood.getLayoutY()> 592 || labyrinthFood.getLayoutY()<0));
        }
    }
    
}
