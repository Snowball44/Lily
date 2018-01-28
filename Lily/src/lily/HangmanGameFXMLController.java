/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lily;

import Game_data.GameFacade;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import static lily.FXMLDocumentController.scene;

/**
 * FXML Controller class
 *
 * @author Kim Christensen
 */
public class HangmanGameFXMLController implements Initializable {

    static Scene scene;

    Parent root;

    @FXML
    private ImageView hangManHeart1;
    @FXML
    private ImageView hangManHeart2;
    @FXML
    private ImageView hangManHeart3;
    @FXML
    private Label hangManWordLabel;
    @FXML
    private Button hangManButtonA;
    @FXML
    private Button hangManButtonB;
    @FXML
    private Button hangManButtonC;
    @FXML
    private Button hangManButtonD;
    @FXML
    private Button hangManButtonE;
    @FXML
    private Button hangManButtonF;
    @FXML
    private Button hangManButtonG;
    @FXML
    private Button hangManButtonH;
    @FXML
    private Button hangManButtonI;
    @FXML
    private Button hangManButtonJ;
    @FXML
    private Button hangManButtonK;
    @FXML
    private Button hangManButtonL;
    @FXML
    private Button hangManButtonM;
    @FXML
    private Button hangManButtonN;
    @FXML
    private Button hangManButtonO;
    @FXML
    private Button hangManButtonP;
    @FXML
    private Button hangManButtonQ;
    @FXML
    private Button hangManButtonR;
    @FXML
    private Button hangManButtonS;
    @FXML
    private Button hangManButtonT;
    @FXML
    private Button hangManButtonU;
    @FXML
    private Button hangManButtonV;
    @FXML
    private Button hangManButtonX;
    @FXML
    private Button hangManButtonY;
    @FXML
    private Button hangManButtonZ;

    private GameFacade facade = new GameFacade();
    String selectedWord;
    String word1 = "heart";
    String word2 = "brain";
    String word3 = "brave";
    int correct = 0;
    int lifeLeft;
    char[] selectedWordArray;
    @FXML
    private AnchorPane heartGamePane;
    @FXML
    private AnchorPane heartEndPane;
    @FXML
    private TextArea heartEndTextArea;
    @FXML
    private Button heartEndConfirmButton;

    public HangmanGameFXMLController() {
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lifeLeft = 3;
        selectedWord = wordSelector();
        System.out.println(selectedWord);
        selectedWordArray = selectedWord.toCharArray();
        Image heart1 = new Image(getClass().getResource("/Assets/heart.png").toString());
        hangManHeart1.setImage(heart1);
        hangManHeart2.setImage(heart1);
        hangManHeart3.setImage(heart1);
    }

    @FXML
    private void hangManButtonGuess(ActionEvent event) {
        if (event.getSource() == hangManButtonA) {
            guessLetter('a');
            hangManButtonA.setVisible(false);
        } else if (event.getSource() == hangManButtonB) {
            guessLetter('b');
            hangManButtonB.setVisible(false);
        } else if (event.getSource() == hangManButtonC) {
            guessLetter('c');
            hangManButtonC.setVisible(false);
        } else if (event.getSource() == hangManButtonD) {
            guessLetter('d');
            hangManButtonD.setVisible(false);
        } else if (event.getSource() == hangManButtonE) {
            guessLetter('e');
            hangManButtonE.setVisible(false);
        } else if (event.getSource() == hangManButtonF) {
            guessLetter('f');
            hangManButtonF.setVisible(false);
        } else if (event.getSource() == hangManButtonG) {
            guessLetter('g');
            hangManButtonG.setVisible(false);
        } else if (event.getSource() == hangManButtonH) {
            guessLetter('h');
            hangManButtonH.setVisible(false);
        } else if (event.getSource() == hangManButtonI) {
            guessLetter('i');
            hangManButtonI.setVisible(false);
        } else if (event.getSource() == hangManButtonJ) {
            guessLetter('j');
            hangManButtonJ.setVisible(false);
        } else if (event.getSource() == hangManButtonK) {
            guessLetter('k');
            hangManButtonK.setVisible(false);
        } else if (event.getSource() == hangManButtonL) {
            guessLetter('l');
            hangManButtonL.setVisible(false);
        } else if (event.getSource() == hangManButtonM) {
            guessLetter('m');
            hangManButtonM.setVisible(false);
        } else if (event.getSource() == hangManButtonN) {
            guessLetter('n');
            hangManButtonN.setVisible(false);
        } else if (event.getSource() == hangManButtonO) {
            guessLetter('o');
            hangManButtonO.setVisible(false);
        } else if (event.getSource() == hangManButtonP) {
            guessLetter('p');
            hangManButtonP.setVisible(false);
        } else if (event.getSource() == hangManButtonQ) {
            guessLetter('q');
            hangManButtonQ.setVisible(false);
        } else if (event.getSource() == hangManButtonR) {
            guessLetter('r');
            hangManButtonR.setVisible(false);
        } else if (event.getSource() == hangManButtonS) {
            guessLetter('s');
            hangManButtonS.setVisible(false);
        } else if (event.getSource() == hangManButtonT) {
            guessLetter('t');
            hangManButtonT.setVisible(false);
        } else if (event.getSource() == hangManButtonU) {
            guessLetter('u');
            hangManButtonU.setVisible(false);
        } else if (event.getSource() == hangManButtonV) {
            guessLetter('v');
            hangManButtonV.setVisible(false);
        } else if (event.getSource() == hangManButtonX) {
            guessLetter('x');
            hangManButtonX.setVisible(false);
        } else if (event.getSource() == hangManButtonY) {
            guessLetter('y');
            hangManButtonY.setVisible(false);
        } else if (event.getSource() == hangManButtonZ) {
            guessLetter('z');
            hangManButtonZ.setVisible(false);
        }
    }

    //Hangman guess method
    public void guessLetter(char letter) {
        int i = 0;
        boolean isFound = false;
        while (i != selectedWordArray.length) {
            if (selectedWordArray[i] == letter) {
                System.out.println("Bogstav findes");
                isFound = true;
                i++;
                break;
            } else {
                i++;
            }
        }
        if (isFound) {
            char[] hangManWordLabelCharArray;
            String hej = hangManWordLabel.getText();
            hangManWordLabelCharArray = hej.toCharArray();
            System.out.println(hej);
            System.out.println(hangManWordLabelCharArray);
            hangManWordLabelCharArray[i - 1] = letter;
            hej = String.valueOf(hangManWordLabelCharArray);
            hangManWordLabel.setText(hej);
            correct++;
            System.out.println(correct);
            System.out.println(lifeLeft);

            if (correct == 5) {
                facade.setWon("Heart", true);
                facade.setCompleted("Heart", true);
                heartEndPane.setVisible(true);
                heartGamePane.setVisible(false);
                heartEndTextArea.setText("HEART SYSTEMS RESTORED [OK]\nHEART RATE STABILIZED [OK]\nANTIVIRUS CODE UPLOADED. MALWARE DELETED [OK]");
                System.out.println(facade.getWon("Heart"));
            }
        } else {
            lifeLeft--;
            //Win
            if (lifeLeft == 0) {
                hangManHeart1.setVisible(false);
                //Skift til nyt pane der viser win eller lose og husk confirm button.
                facade.setCompleted("Heart", true);
                facade.setWon("Heart", false);
                heartEndPane.setVisible(true);
                heartGamePane.setVisible(false);
                heartEndTextArea.setText("ERROR. ERROR. ERROR. HEART BEAT RATIO AT 0.\nTERMINATING PROCESS.\nConnection to heart LOST");

            }

            //Lose
        }
        if (lifeLeft == 2) {
            hangManHeart3.setVisible(false);
        } else if (lifeLeft == 1) {
            hangManHeart2.setVisible(false);
        }
    }

    //Hangman Stringselector
    public String wordSelector() {
        int num = (int) Math.floor(Math.random() * 3) + 1;
        switch (num) {
            case 1:
                selectedWord = word1;
                break;
            case 2:
                selectedWord = word2;
                break;
            case 3:
                selectedWord = word3;
                break;
            default:
                break;
        }
        return selectedWord;
    }

    @FXML
    private void heartEndConfirmButton(ActionEvent event) throws IOException {
        changeScene("splashscreen3");
    }

    public void changeScene(String newScene) throws IOException {
        root = FXMLLoader.load(getClass().getResource(newScene + ".fxml"));
        scene = heartEndConfirmButton.getScene();
        scene.setRoot(root);
        scene.getRoot().requestFocus();
    }
}
