/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game_data;

/**
 *
 * @author Zuzu
 */
public class Mess {
    
    public EndingResults finalResults;
    public Mission legs;
    public Mission brain;
    public Mission heart;
    
    Mess(){
        finalResults = new EndingResults();
        legs = new Mission("Legs");
        brain = new Mission("brain");
        heart = new Mission("Heart");
        
    }
    
    
}
