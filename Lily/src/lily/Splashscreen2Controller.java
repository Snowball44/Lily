/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lily;

import Game_data.GameFacade;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;


/**
 * FXML Controller class
 *
 * @author Zuzu
 */
public class Splashscreen2Controller implements Initializable {

    @FXML
    private TextArea labyrinthEndTextArea;
    @FXML
    private Button labyrinthEndConfirmButton;

    private GameFacade facade = new GameFacade();

    static Scene scene;

    Parent root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if (facade.getWon("Brain")) {
            labyrinthEndTextArea.appendText("BRAINSYSTEMS RESTORED [OK]\nBRAINSYSTEM STABILIZED [OK]\nPRESS CONFIRM TO PROCEED");

        } else {
            labyrinthEndTextArea.appendText("CONNECTION TO BRAINSYSTEM LOST. ERROR.. ERR... BRAINSYSTEM NONFUNCTIONAL\nPRESS CONFIRM TO PROCEED!");

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
