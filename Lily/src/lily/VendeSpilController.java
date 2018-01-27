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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Jalap
 */
public class VendeSpilController implements Initializable {

    public String clickedImageView1;
    public String clickedImageView2;
    public GridPane gridPane = new GridPane();
    private Boolean setCardFlipped = false;
    private String[] saveClicks = new String[2];
    private Integer mCount = 0;
    @FXML
    private ImageView green1;
    @FXML
    private ImageView blue1;
    @FXML
    private ImageView red1;
    @FXML
    private ImageView green2;
    @FXML
    private ImageView orange2;
    @FXML
    private ImageView blue2;
    @FXML
    private ImageView red2;
    @FXML
    private ImageView orange1;
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
    
    void SetBrickColor(MouseEvent ev)
    {
        if(ev.getPickResult().getIntersectedNode().getId().equals("orange1"))
        {
            Image image = new Image(getClass().getResource("/Assets/orange.png")
                    .toString());
            orange1.setImage(image);
            
            System.out.println("orange has been clicked");
        }
        if(ev.getPickResult().getIntersectedNode().getId().equals("orange2"))
        {
            Image image = new Image(getClass().getResource("/Assets/orange.png")
                    .toString());
            orange2.setImage(image);
            System.out.println("orange has been clicked");
        }
        if(ev.getPickResult().getIntersectedNode().getId().equals("red1"))
        {
            Image image = new Image(getClass().getResource("/Assets/red.png")
                    .toString());
            red1.setImage(image);
            
            System.out.println("red has been clicked");
        }
        if(ev.getPickResult().getIntersectedNode().getId().equals("red2"))
        {
            Image image = new Image(getClass().getResource("/Assets/red.png")
                    .toString());
            red2.setImage(image);
            System.out.println("red has been clicked");
        }
        
        if(ev.getPickResult().getIntersectedNode().getId().equals("blue1"))
        {
            Image image = new Image(getClass().getResource("/Assets/blue.png")
                    .toString());
            blue1.setImage(image);
            
            System.out.println("blue1 has been clicked");
        }
        if(ev.getPickResult().getIntersectedNode().getId().equals("blue2"))
        {
            Image image = new Image(getClass().getResource("/Assets/blue.png")
                    .toString());
            blue2.setImage(image);
            System.out.println("blue has been clicked");
        }
        if(ev.getPickResult().getIntersectedNode().getId().equals("green1"))
        {
            Image image = new Image(getClass().getResource("/Assets/green.png")
                    .toString());
            green1.setImage(image);
            
            System.out.println("green has been clicked");
        }
        if(ev.getPickResult().getIntersectedNode().getId().equals("green2"))
        {
            Image image = new Image(getClass().getResource("/Assets/green.png")
                    .toString());
            green2.setImage(image);
            System.out.println("green has been clicked");
        }
    }
    
    @FXML
    private void clickKort(MouseEvent event) 
    {   
        SetBrickColor(event);
        
        if(!setCardFlipped)
        {
            setCardFlipped = true;
        }
        
        mCount++;
        
        if(setCardFlipped)
        {
            
            if(mCount == 1)
            {
                clickedImageView1 = event.getPickResult().getIntersectedNode().getId();
                System.out.println("clicked this: " + clickedImageView1);
                CheckArray(saveClicks,mCount,event.getPickResult().getIntersectedNode().getId(), null);
            }
            else if(mCount == 2)
            {
                clickedImageView2 = event.getPickResult().getIntersectedNode().getId();
                System.out.println("clicked this: " + clickedImageView2);
                CheckArray(saveClicks,mCount, saveClicks[0], event.getPickResult().getIntersectedNode().getId());
                //check bricks
                EvalBricks(clickedImageView1, clickedImageView2);
            }
            
            


            for (int i = 0; i < saveClicks.length; i++) {
                System.out.println(Arrays.toString(saveClicks));
            }
        }
        
        //String tempstr = event.getPickResult().getIntersectedNode().getId();
        
        System.out.println(event.getPickResult().getIntersectedNode().getId());
    }
    
    
    
    private void ClearData()
    {
        saveClicks[0] = null;
        saveClicks[1] = null;
        
        setCardFlipped = false;
        
        mCount = 0;
    }
    
    private Boolean EvalBricks(String matchBrick1, String matchBrick2)
    {
       //                              0       1       2       3           4       5       6       7
        String[] colors = new String[]{"red1","red2","orange1","orange2","green1","green2","blue1","blue2"};
        
        //matches red1 and red2
        if(matchBrick1.equals(colors[0]) && matchBrick2.equals(colors[1]))
        {
            System.out.println("its a match!!!!");
            return true;
        }
        
        //matches orange1 and orange2
        if(matchBrick1.equals(colors[2]) && matchBrick2.equals(colors[3]))
        {
            System.out.println("its a match!!!!");
            return true;
        }
        
        //matches green1 and green2
        if(matchBrick1.equals(colors[4]) && matchBrick2.equals(colors[5]))
        {
            System.out.println("its a match!!!!");
            return true;
        }
        
        //matches blue1 and blue2
        if(matchBrick1.equals(colors[6]) && matchBrick2.equals(colors[7]))
        {
            System.out.println("its a match!!!!");
            return true;
        }
        System.out.println("NO MATCH!!!");
        return false;
    }
    
    
}
