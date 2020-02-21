
/**
 * Write a description of CaesarBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class CaesarBreaker {
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
    public String decrypt(String encrypted){
        CaesarCipher cc = new CaesarCipher();
        int [] freqs = counterLetter(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4){
            dkey = 26 - (4 - maxDex);
        }
        return cc.encrypt(encrypted, 26 - dkey);
    }
    public void testDecrypt (){
        String test = "At noon be in the conference room with youreeeeeeeeeee hat on for a surprise party. YELL LOUD!";
        CaesarCipher cc1 = new CaesarCipher();
        String encrypted = cc1.encrypt(test, 15);
        System.out.println(test);
        System.out.println(encrypted);
        System.out.println(decrypt(encrypted));
    }
    public String halfOfString(String message, int start){
        StringBuilder halfMessage = new StringBuilder();
        for (int i = start; i < message.length(); i+=2){
            halfMessage.append(message.charAt(i));
        }
        return halfMessage.toString();
    }
    public void testHalfOfString(){
        String test = "Qbkm Zgis";
        System.out.println(halfOfString(test,1));
    }
    public int getKey(String s){
        int [] counts = counterLetter(s);
        int key = maxIndex(counts);
        int dkey = key - 4;
        if (key < 4){
            dkey = 26 - (4 - key);
        }
        return dkey;
    }
    public String decryptTwoKeys(String encrypted){
        CaesarCipher cc = new CaesarCipher();
        String str1 = halfOfString(encrypted, 0);
        String str2 = halfOfString(encrypted, 1);
        int key1 = getKey(str1);
        int key2 = getKey(str2);
        System.out.println(key1);
        System.out.println(key2);
        return cc.encryptTwoKeys(encrypted, 26 - key1, 26 - key2);
    }
    public void testDecryptTwoKeys (){
        String test = "Akag tjw Xibhr awoa aoee xakex znxag xwko";
        CaesarCipher cc2 = new CaesarCipher();
        FileResource fr = new FileResource();
        String encrypted = fr.asString();
        System.out.println(encrypted);
        System.out.println(decryptTwoKeys(encrypted));
    }
    
}
