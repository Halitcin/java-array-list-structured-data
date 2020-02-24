
/**
 * Write a description of TestCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
public class TestCaesarCipher {
    public int [] counterLetter(String words){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int [] counts = new int [26];
        words = words.toLowerCase();
        for (int i = 0; i < words.length(); i++){
            char ch = words.charAt(i);
            int idx = alphabet.indexOf(ch);
            if (idx != -1) {
                counts[idx] += 1;
            }
        }
        return counts;
    }
    public int maxIndex(int [] counts){
        int maxIdx = 0;
        for (int i = 0; i < counts.length; i++){
            if (counts[i] > counts[maxIdx]){
                maxIdx = i;
            }
        }
        return maxIdx;
    }
    
    public void simpleTests() {
        FileResource fr = new FileResource();
        String text = fr.asString();
        CaesarCipher cc = new CaesarCipher(18);
        String encrypted = cc.encrypt(text);
        System.out.println(text);
        System.out.println(encrypted);
        System.out.println(cc.decrypt(encrypted)); 
    } 

}
