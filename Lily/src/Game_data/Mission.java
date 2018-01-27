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
public class Mission {
    private String name;
    private boolean completed;
    private boolean won;
    
    Mission(String name){
        this.name = name;
        this.completed = false;
        this.won = false;
    }
    
    
    public String getName(){
        return name;
    }
    
    public boolean getCompleted(){
        return completed;
    }
    
    public boolean getWon(){
        return won;
    }
    
    public void setCompleted(boolean completed){
        this.completed = completed;
    }
    
    public void setWon(boolean won){
        this.won = won;
    }
}
