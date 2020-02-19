
/**
 * Write a description of WordPlay here.
 * 
 * @author halit 
 * @version 1
 */

import edu.duke.*;

public class WordPlay {
    public boolean isVowel (char ch) {
        char chLower = Character.toLowerCase(ch); 
        StringBuilder vowels = new StringBuilder("aeiou");
        for (int i = 0; i < vowels.length(); i++) {
            if (chLower == vowels.charAt(i)) {
                return true;
            }
        }
        return false;
    }
    public void testIsVowel() {
        char ch = 'E';
        System.out.println(isVowel(ch));
    }
    public String replaceVowels (String phrase, char ch) {
        StringBuilder nPhrase = new StringBuilder(phrase);
        for (int i = 0; i < nPhrase.length(); i++) {
            if (isVowel(nPhrase.charAt(i))){
                nPhrase.setCharAt(i, ch);
            } 
        }
        return nPhrase.toString();
    }
    public void testReplaceVowels(){
        System.out.println(replaceVowels("Hello Word", '*'));
    }
    public String emphasize (String phrase, char ch) {
        StringBuilder nPhrase = new StringBuilder(phrase);
        for (int i = 0; i < nPhrase.length(); i++) {
            if (nPhrase.charAt(i) == ch){
                if ((i+1) % 2 == 0) {
                    nPhrase.setCharAt(i, '+');
                }
                else nPhrase.setCharAt(i, '*');  
            } 
        }
        return nPhrase.toString();
    }
    public void testEmphasize(){
        System.out.println(emphasize("Mary Bella Abracadabra", 'a'));
    }
}

