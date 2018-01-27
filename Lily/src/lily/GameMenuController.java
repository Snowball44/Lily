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

    static GameFacade facade = new GameFacade();
    static Scene scene;

    Parent root;
    @FXML
    private ImageView heartButton;
    @FXML
    private ImageView brainButton;
    @FXML
    private ImageView legs;
    @FXML
    private Button load;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void legsAction(MouseEvent event) throws IOException {
        if (!facade.getCompleted("Legs") && !facade.getCompleted("brain") && !facade.getCompleted("Heart")) {
            changeScene("FXMLDocument", legs);
        }

    }

    public void changeScene(String newScene, ImageView image) throws IOException {
        root = FXMLLoader.load(getClass().getResource(newScene + ".fxml"));
        scene = image.getScene();
        scene.setRoot(root);
        scene.getRoot().requestFocus();
    }

    @FXML
    private void heartActon(MouseEvent event) throws IOException {
        if (facade.getCompleted("Legs") && facade.getCompleted("brain") && !facade.getCompleted("Heart")) {
         //   changeScene("", heartButton);
        }

    }

    @FXML
    private void brainAction(MouseEvent event) throws IOException {
        if (facade.getCompleted("Legs") && !facade.getCompleted("brain") && !facade.getCompleted("Heart")) {
          //  changeScene("", brainButton);
        }
    }

    @FXML
    private void loadAction(ActionEvent event) {

        locked = new Image(getClass().getResource("/Assets/locked.png").toExternalForm());
        unlocked = new Image(getClass().getResource("/Assets/unlocked.png").toExternalForm());

        if (!facade.getCompleted("Legs") && !facade.getCompleted("brain") && !facade.getCompleted("Heart")) {
            legs.setImage(unlocked);
            brainButton.setImage(locked);
            heartButton.setImage(locked);
        } else if (facade.getCompleted("Legs") && !facade.getCompleted("brain") && !facade.getCompleted("Heart")) {
            legs.setImage(locked);
            brainButton.setImage(unlocked);
            heartButton.setImage(locked);
        } else /*(facade.getCompleted("Legs") && facade.getCompleted("brain") && !facade.getCompleted("Heart")) */ {
            legs.setImage(locked);
            brainButton.setImage(locked);
            heartButton.setImage(unlocked);
        }
    }
}
