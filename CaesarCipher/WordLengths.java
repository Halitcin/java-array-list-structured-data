
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
            int wordLength = word.length();
            if ( word.length() == 1 && !Character.isLetter(word.charAt(0))){
                wordLength = 1;
            }
            else word = word.toLowerCase();
            if (word.length() != 1 && !Character.isLetter(word.charAt(0))){
                wordLength -= 1;
            }
            if ( word.length() != 1 && !Character.isLetter(word.charAt(word.length() - 1))){
                wordLength -= 1; 
            }
            if (wordLength >= counts.length) {
                counts[counts.length - 1] +=1; 
            }
            System.out.println(wordLength);
            System.out.println(word);
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
