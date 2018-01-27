/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lily;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;

/**
 * FXML Controller class
 *
 * @author Zuzu
 */
public class MainMenuController implements Initializable {

    @FXML
    private AnchorPane background;
    @FXML
    private Button endingResults;
    @FXML
    private Button playButton;
    
    private Boolean helpDrawed = false;

    static Scene scene;

    Parent root;
   
    
    private TextArea popupText;
    @FXML
    private ImageView view;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        view.setImage( url("Assets/backgroundMainMenu.png"));
            // TODO
    }    

    @FXML
    private void endingResultsButtonAction(ActionEvent event) {
         if (!helpDrawed) {
            openWindow();

            popupText.setText(EndingResults.getHighscoreList());
            background.getChildren().add(popupText);
            helpDrawed = true;
        } else {
            background.getChildren().remove(4);
            helpDrawed = false;
        }
    }

    @FXML
    private void playButtonAction(ActionEvent event) {
    }
    
    public void changeScene(String newScene) throws IOException {
        root = FXMLLoader.load(getClass().getResource(newScene + ".fxml"));
        scene = playButton.getScene();
        scene.setRoot(root);
        scene.getRoot().requestFocus();
    }
    
        private void openWindow() {
        int helpTextWidth = 280;
        int helpTextHeight;
        popupText = new TextArea();
        popupText.setPrefSize(helpTextWidth, 280);
        popupText.setLayoutX((background.getWidth() / 2) - (helpTextWidth / 2));
        popupText.setLayoutY(280);
    }

    private Image url(String assetsbackgroundMainMenupng) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
        
}
