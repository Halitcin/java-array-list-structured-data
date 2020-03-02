
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
    }
    public int maxNumber(){
        int max = 0;
        for (String s : words.keySet()){
            if (words.get(s).size() > max){
                max = words.get(s).size();
            }
        }
        return max;
    }
    public ArrayList<String> wordsInNumFiles(int number){
        ArrayList<String> wordNumber = new ArrayList<String>();
        for (String s : words.keySet()){
            if (words.get(s).size() == number){
                wordNumber.add(s);
            }
        }
        return wordNumber;
    }
    public void printFilesIn(String name){
        for (String s : words.keySet()){
            if (s.equals(name)){
                for( int i = 0; i < words.get(s).size(); i++){
                    System.out.println(words.get(s).get(i));
                }
            }
        }
    }
    public void tester(){
        WordsInFiles wF = new WordsInFiles();
        wF.buildWordFileMap();
        //System.out.println(wF.wordsInNumFiles(5).size());
        //System.out.println(wF.wordsInNumFiles(4).size());
        wF.printFilesIn("red");
        ArrayList<String> test = new ArrayList<String>();
        test = wF.wordsInNumFiles(wF.maxNumber());
        /*for (int i = 0; i < test.size(); i++){
            System.out.println(test.get(i));
            wF.printFilesIn(test.get(i));
        }
        for (String s : wF.words.keySet()){
            System.out.println(s+ "\t"+ wF.words.get(s));
        }*/
        
    }
}
