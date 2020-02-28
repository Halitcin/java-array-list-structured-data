
/**
 * Write a description of TestCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
public class TestCaesarCipher {
    private int [] counterLetter(String words){
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
    private int maxIndex(int [] counts){
        int maxIdx = 0;
        for (int i = 0; i < counts.length; i++){
            if (counts[i] > counts[maxIdx]){
                maxIdx = i;
            }
        }
        return maxIdx;
    }
    
    public void simpleTests() {
        //FileResource fr = new FileResource();
        //String text = fr.asString();
        String text = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        CaesarCipher cc = new CaesarCipher(15);
        String encrypted = cc.encrypt(text);
        System.out.println(text);
        System.out.println(encrypted);
        System.out.println(breakCaesarCipher(encrypted)); 
        System.out.println(cc.decrypt(encrypted)); 
    }
    
    public String breakCaesarCipher(String input){
         int [] freqs = counterLetter(input);
         int maxDex = maxIndex(freqs);
         int dkey = maxDex - 4;
         if (maxDex < 4){
            dkey = 26 - (4 - maxDex);
        }
        CaesarCipher cc = new CaesarCipher(26 - dkey);
        return cc.encrypt(input);
         
    }

}
