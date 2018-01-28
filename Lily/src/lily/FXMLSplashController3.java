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
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author Zuzu
 */
public class FXMLSplashController3 implements Initializable {

    @FXML
    private Button nextButton;
    @FXML
    private ImageView view;

    private final Image[] endings = new Image[4];

    private int checkArray = 0;

    static Scene scene;

    Parent root;

    private GameFacade facade = new GameFacade();
    private int check = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void changeSceneButtonAction(ActionEvent event) throws IOException {
        endings[0] = new Image(getClass().getResource("/Assets/succes.png").toExternalForm());
        endings[1] = new Image(getClass().getResource("/Assets/para.png").toExternalForm());
        endings[2] = new Image(getClass().getResource("/Assets/Brain.png").toExternalForm());
        endings[3] = new Image(getClass().getResource("/Assets/Dead.png").toExternalForm());
        if (facade.getWon("Legs") && facade.getWon("Brain") && facade.getWon("Heart") && check == 0) {
            //Working

            view.setImage(endings[0]);
            check++;
        } else if ((!facade.getWon("Legs") || facade.getWon("Legs")) && facade.getWon("Brain") && facade.getWon("Heart")&& check == 0) {
            //Paralyzed

            view.setImage(endings[1]);
            check++;
        } else if ((!facade.getWon("Legs") || facade.getWon("Legs")) && (!facade.getWon("Brain") || facade.getWon("Brain")) && facade.getWon("Heart")&& check == 0) {
            //Braindamage

            view.setImage(endings[2]);
            check++;
        } else if ((!facade.getWon("Legs") || facade.getWon("Legs")) && (!facade.getWon("Brain") || facade.getWon("Brain")) && !facade.getWon("Heart")&& check == 0) {
            //Dead
            view.setImage(endings[3]);
            check++;
        } else {
            check = 0;
            changeScene("resultSubmit");
        }
    }

    @FXML
    private void handleButtonAction(KeyEvent event) {
    }

    public void changeScene(String newScene) throws IOException {
        root = FXMLLoader.load(getClass().getResource(newScene + ".fxml"));
        scene = nextButton.getScene();
        scene.setRoot(root);
        //scene.getRoot().requestFocus();
    }

}
