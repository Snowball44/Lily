/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game_data;

import Game_data.EndingResult;
import Game_data.CompareEnding;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Zuzu
 */
public class EndingResults {

    
    private static ArrayList<EndingResult> results;
    private static final String RESULTS_FILE = "results.txt";
    static ObjectOutputStream outputStream = null;
    static ObjectInputStream inputStream = null;

  
    EndingResults() {
       
         results = new ArrayList<>();
    }

    public static ArrayList<EndingResult> getScores() {
        loadResultFile();
        sort();
        return results;
    }
    
    private static void sort() {
        
        CompareEnding comparator = new CompareEnding();
        
        Collections.sort(results, comparator);
    }

    public void addResult(String name, String result) {
        loadResultFile(); 
        results.add(new EndingResult(name, result));
        updateResultFile(); 
    }

    
    public static void loadResultFile() {
        try {
       
            inputStream = new ObjectInputStream(new FileInputStream(RESULTS_FILE));
            results = (ArrayList<EndingResult>) inputStream.readObject();
           
        } catch (FileNotFoundException e) {
            System.out.println("[Load] FNF Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("[Load] IO Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("[Load] CNF Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Load] IO Error: " + e.getMessage());
            }
        }
    }


    public void updateResultFile() {
        try {
            
            outputStream = new ObjectOutputStream(new FileOutputStream(RESULTS_FILE));
            outputStream.writeObject(results);
            
        } catch (FileNotFoundException e) {
            System.out.println("[Update] FNF Error: " + e.getMessage() + ",the program will try and make a new file");
        } catch (IOException e) {
            System.out.println("[Update] IO Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Update] Error: " + e.getMessage());
            }
        }
    }

    public String getResultsList() {
        String highscoreList = "";
        
        ArrayList<EndingResult> scores;
        
        scores = getScores();

        int x = scores.size();

        
        for (int i = 0; i < x; i++) {
            highscoreList += (i + 1) + ".\t" + String.format("%-12s", scores.get(i).getName()) + "\t\t" + results.get(i).getResult() + "\n";
        }

        return highscoreList;
    }

}