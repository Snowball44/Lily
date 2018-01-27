/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

/**
 *
 * @author Zuzu
 */
public interface InterfaceGame {
   
    public void addResult(String name);
    public void setWon(String name, boolean won);
    public void setCompleted(String name, boolean completed);
    public boolean getWon(String name);
    public boolean getCompleted(String name);
    public String printResults();
    
}
