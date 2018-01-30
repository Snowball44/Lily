/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lily;

import Game_data.GameFacade;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Zuzu
 */
public class GameMenuController implements Initializable {

    private Image locked;
    private Image unlocked;

    private GameFacade facade = new GameFacade();
    static Scene scene;

    Parent root;
    private Button heartButton;
    private Button brainButton;
    @FXML
    private ImageView legsView;
    @FXML
    private ImageView heartView;
    @FXML
    private ImageView brainView;
    @FXML
    private Label legCheck;
    @FXML
    private Label brainCheck;
    @FXML
    private Label heartCheck;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadCheck();
        // TODO
    }

    private void loadCheck() {
        locked = new Image(getClass().getResource("/Assets/locked.png").toExternalForm());
        unlocked = new Image(getClass().getResource("/Assets/unlocked.png").toExternalForm());
        String u = "UNKNOWN";
        String s = "SUCCES";
        String f = "FAILED";

        if (!facade.getCompleted("Legs") && !facade.getCompleted("brain") && !facade.getCompleted("Heart")) {
            legsView.setImage(unlocked);
            brainView.setImage(locked);
            heartView.setImage(locked);
        } else if (facade.getCompleted("Legs") && !facade.getCompleted("brain") && !facade.getCompleted("Heart")) {
            legsView.setImage(locked);
            brainView.setImage(unlocked);
            heartView.setImage(locked);
        } else /*(facade.getCompleted("Legs") && facade.getCompleted("brain") && !facade.getCompleted("Heart")) */ {
            legsView.setImage(locked);
            brainView.setImage(locked);
            heartView.setImage(unlocked);
        }

        if (!facade.getCompleted("legs")) {
            legCheck.setText(u);
        }
        if (!facade.getCompleted("brain")) {
            brainCheck.setText(u);
        }
        if (!facade.getCompleted("heart")) {
            heartCheck.setText(u);
        }
        if (facade.getCompleted("legs") && !facade.getWon("legs")) {
            legCheck.setText(f);
        }
        if (!facade.getWon("brain") && facade.getWon("brain")) {
            brainCheck.setText(f);
        }
        if (!facade.getWon("heart") && facade.getWon("heart")) {
            heartCheck.setText(f);
        }
        if (facade.getWon("legs")) {
            legCheck.setText(s);
        }
        if (facade.getWon("brain")) {
            brainCheck.setText(s);
        }
        if (facade.getWon("heart")) {
            heartCheck.setText(s);
        }

    }

    public void changeScene(String newScene, ImageView button) throws IOException {
        root = FXMLLoader.load(getClass().getResource(newScene + ".fxml"));
        scene = button.getScene();
        scene.setRoot(root);
    }

    @FXML
    private void legsAction(MouseEvent event) throws IOException {
        if (!facade.getCompleted("Legs") && !facade.getCompleted("Brain") && !facade.getCompleted("Heart")) {
            root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            scene = legsView.getScene();
            scene.setRoot(root);
            
            
        }
    }

    @FXML
    private void heartAction(MouseEvent event) throws IOException {
        if (facade.getCompleted("Legs") && facade.getCompleted("Brain") && !facade.getCompleted("Heart")) {
            changeScene("Hangman", heartView);
        }
    }

    @FXML
    private void brainAction(MouseEvent event) throws IOException {
        if (facade.getCompleted("Legs") && !facade.getCompleted("Brain") && !facade.getCompleted("Heart")) {
            changeScene("VendeSpil", brainView);
        }
    }
}
