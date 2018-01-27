/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lily;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Jalap
 */
public class VendeSpilController implements Initializable {

    public GridPane gridPane = new GridPane();
    private Boolean setCardFlipped = false;
    private String[] saveClicks = new String[2];
    private Integer mCount = 0;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //gridPane.add(new ImageView());
        
    }
    
    void CheckArray(String[] arrs,int cnt, String input, String input2)
    {
        System.out.println("count before: " + cnt);
        if(cnt == 1)
        {
            //sæt det første input til arr 0 element
            arrs[0] = input;
        }
        else if(cnt == 2)
        {
            arrs[1] = input2;
        }
        System.out.println("count after: " + cnt);
    }
    
    @FXML
    private void clickKort(MouseEvent event) 
    {   
        if(!setCardFlipped)
        {
            setCardFlipped = true;
        }
        
        mCount++;
        
        if(mCount <= 1)
        {
             
            
            CheckArray(saveClicks,mCount,event.getPickResult().getIntersectedNode().getId(), null);
        }
        else if(mCount >= 1 && mCount <= 2)
        {
            CheckArray(saveClicks,mCount, saveClicks[0], event.getPickResult().getIntersectedNode().getId());
        }
        
        
        for (int i = 0; i < saveClicks.length; i++) {
            System.out.println(Arrays.toString(saveClicks));
        }
        //String tempstr = event.getPickResult().getIntersectedNode().getId();
        
        
        
        
        System.out.println(event.getPickResult().getIntersectedNode().getId());
    }
    
    private Boolean EvalBricks(String matchBrick1, String matchBrick2)
    {
        if(matchBrick1.equals(matchBrick2))
        {
            return true;
        }
        return false;
    }
    
    
}
