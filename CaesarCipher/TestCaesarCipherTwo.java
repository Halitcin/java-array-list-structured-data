
/**
 * Write a description of TestCaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class TestCaesarCipherTwo {
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
    public String halfOfString(String message, int start){
        StringBuilder halfMessage = new StringBuilder();
        for (int i = start; i < message.length(); i+=2){
            halfMessage.append(message.charAt(i));
        }
        return halfMessage.toString();
    }
    public int getKey(String s) {
        int [] counts = counterLetter(s);
        int key = maxIndex(counts);
        int dkey = key - 4;
        if (key < 4){
            dkey = 26 - (4 - key);
        }
        return dkey;
    }
    public void simpleTests() {
        //FileResource fr = new FileResource();
        //String text = fr.asString();
        String text = "Can you";
        CaesarCipherTwo cc = new CaesarCipherTwo(14,24);
        String encrypted = "Hfs cpwewloj loks cd Hoto kyg Cyy.";
        System.out.println(text);
        System.out.println(encrypted);
        System.out.println(cc.decrypt(encrypted)); 
        System.out.println("Automatic:  " + breakCaesarCipher(encrypted)); 
    }
    
    public String breakCaesarCipher(String input){
        
        String str1 = halfOfString(input, 0);
        String str2 = halfOfString(input, 1);
        System.out.println("String1 : " + str1);
        System.out.println("String2 : " +str2);
        int key1 = getKey(str1);
        int key2 = getKey(str2);
        System.out.println("key1 " + key1 + " key2 " + key2);
        CaesarCipherTwo cc = new CaesarCipherTwo(26 - key1, 26 - key2);
        return cc.encrypt(input);
         
    }

}
