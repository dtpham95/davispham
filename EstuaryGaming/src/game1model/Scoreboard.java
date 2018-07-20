package game1model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Scoreboard {
	Game game;
	
	ArrayList<Score> scores = new ArrayList<Score>();
	ArrayList<Score> scoresM = new ArrayList<Score>();
	ArrayList<Score> scoresH = new ArrayList<Score>();
	
	
	public Scoreboard(Game game) {
		this.game = game;
	}
	
    public void readsE() {

        // The name of the file to open.
        String fileName = "src/game1model/Scoreboard.txt";

        // This will reference one line at a time
        String line = null;
        for (int i = 0; i < scores.size(); i++) {
        	scores.remove(i);
        }
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                	int space = line.indexOf(" ");
                	String n = line.substring(0, space);
                	String num = line.substring(space + 1);
                	int result = Integer.parseInt(num);
                	Score s = new Score(result, n);
                	scores.add(s);
            }   
            
            Collections.sort(scores);

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    }
    
    public void writesE() {
        String fileName = "src/game1model/Scoreboard.txt";

        try {
            // Assume default encoding.
            FileWriter fileWriter =
                new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character.
            for (int i = 0; i < scores.size(); i++) {
	            bufferedWriter.write(scores.get(i).toString());
	            bufferedWriter.newLine();
            }

            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
    
    public boolean newScore(int contender) {
    	for (int i = 0; i < scores.size(); i++) {
    		if (contender > scores.get(i).number) {
    			if (game.textBox == 0) {
        				game.textBox = 1;
    			}
    			return true;
    		}
    	}
    	return false;
    }
    
    
    
    
    
    
    public boolean newScoreM(int contender) {
    	for (int i = 0; i < scoresM.size(); i++) {
    		if (contender > scoresM.get(i).number) {
    			if (game.textBox == 0) {
        				game.textBox = 1;
    			}
    			return true;
    		}
    	}
    	return false;
    }
    public void readsM() {

        // The name of the file to open.
        String fileName = "src/game1model/ScoreboardMed.txt";

        // This will reference one line at a time
        String line = null;
        for (int i = 0; i < scoresM.size(); i++) {
        	scoresM.remove(i);
        }
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                	int space = line.indexOf(" ");
                	String n = line.substring(0, space);
                	String num = line.substring(space + 1);
                	int result = Integer.parseInt(num);
                	Score s = new Score(result, n);
                	scoresM.add(s);
            }   
            
            Collections.sort(scoresM);

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    }
    
    public void writesM() {
        String fileName = "src/game1model/ScoreboardMed.txt";

        try {
            // Assume default encoding.
            FileWriter fileWriter =
                new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character.
            for (int i = 0; i < scoresM.size(); i++) {
	            bufferedWriter.write(scoresM.get(i).toString());
	            bufferedWriter.newLine();
            }

            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
        
        public boolean newScoreH(int contender) {
        	for (int i = 0; i < scoresH.size(); i++) {
        		if (contender > scoresH.get(i).number) {
        			if (game.textBox == 0) {
            				game.textBox = 1;
        			}
        			return true;
        		}
        	}
        	return false;
        }
        
        public void readsH() {

            // The name of the file to open.
            String fileName = "src/game1model/ScoreboardH.txt";

            // This will reference one line at a time
            String line = null;
            for (int i = 0; i < scoresH.size(); i++) {
            	scoresH.remove(i);
            }
            try {
                // FileReader reads text files in the default encoding.
                FileReader fileReader = 
                    new FileReader(fileName);

                // Always wrap FileReader in BufferedReader.
                BufferedReader bufferedReader = 
                    new BufferedReader(fileReader);

                while((line = bufferedReader.readLine()) != null) {
                    	int space = line.indexOf(" ");
                    	String n = line.substring(0, space);
                    	String num = line.substring(space + 1);
                    	int result = Integer.parseInt(num);
                    	Score s = new Score(result, n);
                    	scoresH.add(s);
                }   
                
                Collections.sort(scoresH);


                // Always close files.
                bufferedReader.close();         
            }
            catch(FileNotFoundException ex) {
                System.out.println(
                    "Unable to open file '" + 
                    fileName + "'");                
            }
            catch(IOException ex) {
                System.out.println(
                    "Error reading file '" 
                    + fileName + "'");                  
                // Or we could just do this: 
                // ex.printStackTrace();
            }
        }
        
        public void writesH() {
            String fileName = "src/game1model/ScoreboardH.txt";

            try {
                // Assume default encoding.
                FileWriter fileWriter =
                    new FileWriter(fileName);

                // Always wrap FileWriter in BufferedWriter.
                BufferedWriter bufferedWriter =
                    new BufferedWriter(fileWriter);

                // Note that write() does not automatically
                // append a newline character.
                for (int i = 0; i < scoresH.size(); i++) {
    	            bufferedWriter.write(scoresH.get(i).toString());
    	            bufferedWriter.newLine();
                }

                // Always close files.
                bufferedWriter.close();
            }
            catch(IOException ex) {
                System.out.println(
                    "Error writing to file '"
                    + fileName + "'");
                // Or we could just do this:
                // ex.printStackTrace();
            }
        }
    }
    

   

