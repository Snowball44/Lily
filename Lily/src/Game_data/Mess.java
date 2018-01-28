/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game_data;

import java.util.ArrayList;

/**
 *
 * @author Zuzu
 */
public class Mess {
    
    EndingResults finalResults;
    ArrayList<Mission> missions = new ArrayList<>();
    
    
    Mess(){
        finalResults = new EndingResults();
        missions.add(new Mission("Legs"));
        missions.add(new Mission("Brain"));
        missions.add(new Mission("Heart"));
    }
    
   
    public void setWon(String name, boolean won) {
        Mission seeMission;
        for (int i = 0; i < missions.size(); i++) {
            seeMission = (Mission) missions.get(i);
            if (seeMission.getName().equalsIgnoreCase(name)) {
                seeMission.setWon(won);
                break;
            }
        }
    }

   
    public void setCompleted(String name, boolean completed) {
        Mission seeMission;
        for (int i = 0; i < missions.size(); i++) {
            seeMission = (Mission) missions.get(i);
            if (seeMission.getName().equalsIgnoreCase(name)) {
                seeMission.setCompleted(completed);
                break;
            }
        }
    }

   
    public boolean getWon(String name) {
        Mission seeMission = null;
        for (int i = 0; i < missions.size(); i++) {
            seeMission = (Mission) missions.get(i);
            if (seeMission.getName().equalsIgnoreCase(name)) {
               break;           
            }
        }
        return seeMission.getWon();
    }

    
    public boolean getCompleted(String name) {
        Mission seeMission = null;
        for (int i = 0; i < missions.size(); i++) {
            seeMission = (Mission) missions.get(i);
            if (seeMission.getName().equalsIgnoreCase(name)) {
                break;
            }
        }
        return seeMission.getCompleted();
    }

    void setWon(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
