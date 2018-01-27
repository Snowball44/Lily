/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game_data;
import Acquaintance.InterfaceGame;
/**
 *
 * @author Zuzu
 */
public class GameFacade implements InterfaceGame{

    EndingResults finalResults = new EndingResults();
    
    
    @Override
    public void addResult(String name) {
        
        finalResults.addResult(name, name);
    }
    
}
