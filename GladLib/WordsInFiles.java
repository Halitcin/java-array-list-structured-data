
/**
 * Write a description of WordsInFiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;

public class WordsInFiles {
    private HashMap<String, ArrayList<String>> words;
    public WordsInFiles(){
        words = new HashMap<String, ArrayList<String>>();
    }
    private void addWordsFromFile(File f) {
            Scanner sc = null;        
            try {
                sc = new Scanner(f);
            } catch (FileNotFoundException e) {
                e.printStackTrace();  
            }
            while (sc.hasNextLine()) {
                Scanner s1 = new Scanner(sc.nextLine());
                while (s1.hasNext()) {
                    String s = s1.next();
                    if (words.containsKey(s)){
                        ArrayList<String> al = new ArrayList<String>();
                        al = words.get(s); 
                        if (!al.contains(f.getName())){
                            al.add(f.getName());
                            words.put(s,al);
                        }
                    
                    } else {
                        ArrayList<String> al = new ArrayList<String>();
                        al.add(f.getName());
                        words.put(s,al); 
                    }    
                }
            }
            
            sc.close();
    }
    public void buildWordFileMap() {
        words.clear();
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
           addWordsFromFile(f);
        }
        System.out.println(words);
    }
    
}
