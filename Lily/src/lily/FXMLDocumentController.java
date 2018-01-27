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
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
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
    int malwareLeft;
    long startTime;
    long stopTime;
    long totalTime;
    static GameFacade facade = new GameFacade();
    @FXML
    private Label labyrinthTimeLabel;
    @FXML
    private Label labyrinthMalwareLeftLabel;
    @FXML
    private AnchorPane labyrinthGamePane;
    @FXML
    private AnchorPane labyrinthEndPane;
    @FXML
    private TextArea labyrinthEndTextArea;
    @FXML
    private Button labyrinthEndConfirmButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labyrinthPlayer.requestFocus();
        labyrinthPlayer.setFocusTraversable(true);
        score = 0;
        malwareLeft = 15;
        startTime = System.currentTimeMillis() / 1000;
    }    

    @FXML
    private void labyrinthPlayerKeyPressed(KeyEvent event) {
        stopTime = System.currentTimeMillis() / 1000;
        totalTime = (stopTime-startTime);
        labyrinthTimeLabel.setText(Integer.toString((int) totalTime));
        labyrinthMalwareLeftLabel.setText(Integer.toString(malwareLeft));
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
            score++;
            if(malwareLeft !=0){
            malwareLeft --;
            }
            int newX;
            int newY;
            do {                
                newX = (int) (Math.random() * 10) * 40;
                newY = (int) (Math.random() * 10) * 40;
                labyrinthFood.relocate(newX, newY);
            } 
            while ((labyrinthFood.getLayoutX() > 842 || labyrinthFood.getLayoutX() <0) || (labyrinthFood.getLayoutY()> 592 || labyrinthFood.getLayoutY()<0));
        }
        if(totalTime >= 60){
            labyrinthEndPane.toFront();
            labyrinthEndPane.setVisible(true);
            labyrinthGamePane.setVisible(false);
            labyrinthEndTextArea.appendText("The time is up. Did you manage to save the legs?\n");
            labyrinthEndTextArea.appendText("Your score is " + score);
            labyrinthEndTextArea.appendText("\nYou spent " + totalTime + " seconds\n");
            if(score>= 15){
                labyrinthEndTextArea.appendText("LEGSYSTEMS RESTORED [OK]\nLEGS STABILIZED [OK]\nPRESS CONFIRM TO PROCEED");
                facade.setWon("Legs", true);
                facade.setCompleted("Legs", true);
            }
            else{
                labyrinthEndTextArea.appendText("CONNECTION TO LEGS LOST. ERROR.. ERR... LEGS NONFUNCTIONAL\nPRESS CONFIRM TO PROCEED!");
                facade.setCompleted("Legs", true);
            }
        }
    }

    @FXML
    private void labyrinthEndButton(ActionEvent event) {
        //ACTION
    }
    
}
