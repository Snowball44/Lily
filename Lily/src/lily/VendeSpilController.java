/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lily;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
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

    public Node clickedImageView1;
    public Node clickedImageView2;
    
    private Boolean setCardFlipped = false;
    private String[] saveClicks = new String[2];
    private Integer mCount = 0;
    
    ArrayList<VendeBillede> vendeBilleder = new ArrayList<VendeBillede>();
    
    private static Image orangeImage;
    private static Image greenImage;
    private static Image blueImage;
    private static Image redImage;
    private static Image blackImage;
    
    @FXML
    public GridPane gridPane;
    
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
        vendeBilleder.add(new VendeBillede(0,"orange1",orange1));
        vendeBilleder.add(new VendeBillede(1,"orange2",orange2));
        vendeBilleder.add(new VendeBillede(2,"red1",red1));
        vendeBilleder.add(new VendeBillede(3,"red2",red2));
        vendeBilleder.add(new VendeBillede(4,"green1",green1));
        vendeBilleder.add(new VendeBillede(5,"green2",green2));
        vendeBilleder.add(new VendeBillede(6,"blue1",blue1));
        vendeBilleder.add(new VendeBillede(7,"blue2",blue2));
        
        orangeImage = new Image(getClass().getResource("/Assets/orange.png")
                    .toString());
        greenImage = new Image(getClass().getResource("/Assets/green.png")
                    .toString());
        redImage = new Image(getClass().getResource("/Assets/red.png")
                    .toString());
        blueImage = new Image(getClass().getResource("/Assets/blue.png")
                    .toString());;
        blackImage = new Image(getClass().getResource("/Assets/black.png")
                    .toString());
        
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
            Image image = orangeImage;
            orange1.setImage(image);
            
            System.out.println("orange has been clicked");
        }
        if(ev.getPickResult().getIntersectedNode().getId().equals("orange2"))
        {
            Image image = orangeImage;
            orange2.setImage(image);
            System.out.println("orange has been clicked");
        }
        if(ev.getPickResult().getIntersectedNode().getId().equals("red1"))
        {
            Image image = redImage;
            red1.setImage(image);
            
            System.out.println("red has been clicked");
        }
        if(ev.getPickResult().getIntersectedNode().getId().equals("red2"))
        {
            Image image = redImage;
            red2.setImage(image);
            System.out.println("red has been clicked");
        }
        
        if(ev.getPickResult().getIntersectedNode().getId().equals("blue1"))
        {
            Image image = blueImage;
            blue1.setImage(image);
            
            System.out.println("blue1 has been clicked");
        }
        if(ev.getPickResult().getIntersectedNode().getId().equals("blue2"))
        {
            Image image = blueImage;
            blue2.setImage(image);
            System.out.println("blue has been clicked");
        }
        if(ev.getPickResult().getIntersectedNode().getId().equals("green1"))
        {
            Image image = greenImage;
            green1.setImage(image);
            
            System.out.println("green has been clicked");
        }
        if(ev.getPickResult().getIntersectedNode().getId().equals("green2"))
        {
            Image image = greenImage;
            green2.setImage(image);
            System.out.println("green has been clicked");
        }
    }
    
    @FXML
    private void clickKort(MouseEvent event) 
    {   
        System.out.println("clicked node: " + event.getPickResult().getIntersectedNode());
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
                clickedImageView1 = event.getPickResult().getIntersectedNode();
                System.out.println("clicked this: " + clickedImageView1);
                CheckArray(saveClicks,mCount,event.getPickResult().getIntersectedNode().getId(), null);
            }
            else if(mCount == 2)
            {
                clickedImageView2 = event.getPickResult().getIntersectedNode();
                System.out.println("clicked this: " + clickedImageView2);
                CheckArray(saveClicks,mCount, saveClicks[0], event.getPickResult().getIntersectedNode().getId());
                //check bricks
                if(!EvalBricks(clickedImageView1.getId(), clickedImageView2.getId()))
                {
                    System.out.println("NO MATCH!!!!");
                    
                    for (int i = 0; i < 7; i++) 
                    {
                        if(vendeBilleder.get(i).navn.equals(clickedImageView1.getId())
                                || vendeBilleder.get(i).navn.equals(clickedImageView2.getId()))
                        {
                            vendeBilleder.get(i).imgv.setImage(blackImage);
                        }
                    }
                    
                    
                }
                else{
                    
                    System.out.println("MATCH!!");
                }
                
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
            //System.out.println("its a match!!!!");
            return true;
        }
        
        //matches orange1 and orange2
        if(matchBrick1.equals(colors[2]) && matchBrick2.equals(colors[3]))
        {
            //System.out.println("its a match!!!!");
            return true;
        }
        
        //matches green1 and green2
        if(matchBrick1.equals(colors[4]) && matchBrick2.equals(colors[5]))
        {
            //System.out.println("its a match!!!!");
            return true;
        }
        
        //matches blue1 and blue2
        if(matchBrick1.equals(colors[6]) && matchBrick2.equals(colors[7]))
        {
            //System.out.println("its a match!!!!");
            return true;
        }
        //System.out.println("NO MATCH!!!");
        return false;
    }
    
    
}
