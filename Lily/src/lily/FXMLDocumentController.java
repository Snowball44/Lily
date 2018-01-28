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
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
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
    static Scene scene;

    Parent root;
    
    MediaPlayer mediaPlayer;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labyrinthPlayer.requestFocus();
        labyrinthPlayer.setFocusTraversable(true);
        score = 0;
        malwareLeft = 15;
        startTime = System.currentTimeMillis() / 1000;
        String musicFile = "heartbeat.wav";     // For example

        Media sound = new Media(new File(musicFile).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
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
        if(totalTime > 10){
            mediaPlayer.stop();
        }
        if(totalTime >= 70){
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
    private void labyrinthEndButton(ActionEvent event) throws IOException {
        changeScene("GameMenu");
    }
    
    
    public void changeScene(String newScene) throws IOException {
        root = FXMLLoader.load(getClass().getResource(newScene + ".fxml"));
        scene = labyrinthEndConfirmButton.getScene();
        scene.setRoot(root);
        scene.getRoot().requestFocus();
    }
}
