/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lily;

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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Zuzu
 */
public class ResultSubmitController implements Initializable {

    @FXML
    private TextField nameField;
    @FXML
    private Button submitButton;

    
    static Scene scene;

    Parent root;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void changeScene(String newScene) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(newScene + ".fxml"));
        
        scene.setRoot(root);
        scene.getRoot().requestFocus();
    } 

    @FXML
    private void submitAction(ActionEvent event) {
        String playername = nameField.getText();
        System.out.println(playername + "controller");
        game.submitHighScore(playername);
        changeScene("mainMenu");
    }
}
