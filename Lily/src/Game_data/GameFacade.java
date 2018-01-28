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
public class GameFacade implements InterfaceGame {

    static Mess factory = new Mess();

    @Override
    public void addResult(String name) {
        
        String status;
        if (factory.getWon("Legs") && factory.getWon("Brain") && factory.getWon("Heart")) {
            //Working
            status = "Succes";
        } else if (factory.getWon("Brain") && factory.getWon("Heart")) {
            //Paralyzed
            status = "Paralysed";
        } else if (factory.getWon("Heart")) {
            //Braindamage
            status = "Brain damaged";
        } else {
            //Dead
            status = "Dead";
        }
        
        factory.finalResults.addResult(name, status);
    }

    @Override
    public String printResults() {
        return factory.finalResults.getResultsList();
    }

    @Override
    public void setWon(String name, boolean won) {
        factory.getWon(name);

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

    @Override
    public void reset() {
        factory.reset();
    }

}
