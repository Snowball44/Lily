/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lily;

/**
 *
 * @author Zuzu
 */
public class EndingResult {
    private String name;
    private String endingStatus;
    
    EndingResult(String name, String result){
        this.name = name;
        this.endingStatus = result;
    }
    
    public String getName(){
        return name;
    }
    
    public String getResult(){
        return endingStatus;
    }
    
}
