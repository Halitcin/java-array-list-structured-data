
/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class WordLengths {
    public void countWordLengths(FileResource resource, int [] counts){
        for (String word: resource.words()){
            word = word.toLowerCase();
            int wordLength = word.length();
            if (!Character.isLetter(word.charAt(0))){
                wordLength -= 1;
            }
            if (!Character.isLetter(word.charAt(word.length() - 1))){
                wordLength -= 1; 
            }
            counts[wordLength] += 1;
        }
    }
    public void testCountWordLengths() {
        FileResource file = new FileResource();
        int [] counts = new int[31];
        countWordLengths(file, counts);
        for (int i = 1; i < counts.length; i++ ){
            System.out.println(i + " words of length " + counts[i] );
        }
    }
}
