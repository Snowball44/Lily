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
public class FXMLSplashController implements Initializable {

    @FXML
    private Button nextButton;
    @FXML
    private ImageView view;

    private final Image[] mainBack = new Image[4];
    private final Image[] endings = new Image[4];
    

    private int checkArray = 0;

    static Scene scene;

    Parent root;

    private GameFacade facade = new GameFacade();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void changeSceneButtonAction(ActionEvent event) throws IOException {
        mainBack[0] = new Image(getClass().getResource("/Assets/1.png").toExternalForm());
        mainBack[1] = new Image(getClass().getResource("/Assets/2.png").toExternalForm());
        mainBack[2] = new Image(getClass().getResource("/Assets/3.png").toExternalForm());
        mainBack[3] = new Image(getClass().getResource("/Assets/4.png").toExternalForm());
        endings[0] = new Image(getClass().getResource("/Assets/succes.png").toExternalForm());
        endings[1] = new Image(getClass().getResource("/Assets/para.png").toExternalForm());
        endings[2] = new Image(getClass().getResource("/Assets/Brain.png").toExternalForm());
        endings[3] = new Image(getClass().getResource("/Assets/Dead.png").toExternalForm());
        if (checkArray < mainBack.length) {
            view.setImage(mainBack[checkArray]);
            checkArray++;
        }  else {
            changeScene("GameMenu");
            checkArray++;
        }
    }

    @FXML
    private void handleButtonAction(KeyEvent event) {
    }

    public void changeScene(String newScene) throws IOException {
        root = FXMLLoader.load(getClass().getResource(newScene + ".fxml"));
        scene = nextButton.getScene();
        scene.setRoot(root);
        scene.getRoot().requestFocus();
    }

}
