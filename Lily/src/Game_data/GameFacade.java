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

    Mess factory= new Mess();
    
    
    @Override
    public void addResult(String name) {
        
        factory.finalResults.addResult(name, name);
    }

    @Override
    public String printResults() {
        return factory.finalResults.getResultsList();
    }

    @Override
    public void setWon(String name, boolean won) {
        factory.setWon(name, won);
        
    }

    @Override
    public void setCompleted(String name, boolean completed) {
        factory.setCompleted(name, completed);
    }

    @Override
    public boolean getWon(String name) {
        return factory.getWon(name);
    }

    @Override
    public boolean getCompleted(String name) {
        return factory.getCompleted(name);
    }

}
