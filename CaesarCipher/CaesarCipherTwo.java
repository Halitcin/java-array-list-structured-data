
/**
 * Write a description of CaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
public class CaesarCipherTwo {
    private String alphabet; 
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int mainKey1;
    private int mainKey2;
    public CaesarCipherTwo(int key1, int key2){
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1= alphabet.substring(key1) + alphabet.substring(0,key1);
        shiftedAlphabet2= alphabet.substring(key2) + alphabet.substring(0,key2);
        mainKey1 = key1;
        mainKey2 = key2;
    }
    public String encrypt(String input){
        StringBuilder cc = new StringBuilder(input);
        for(int i = 0; i < cc.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = cc.charAt(i);
            //Find the index of currChar in the alphabet (call it idx)
            int idx = alphabet.indexOf(currChar);
            //If currChar is in the alphabet
            
            if(idx != -1){
                char newChar;
                if (i % 2 == 0) {
                    newChar = shiftedAlphabet1.charAt(idx);
                    //Replace the ith character of encrypted with newChar
                    
                
                }
                else {
                    newChar = shiftedAlphabet2.charAt(idx);
                }
                cc.setCharAt(i, newChar);
                //Get the idxth character of shiftedAlphabet (newChar)
            }
            else {
                idx = alphabet.toLowerCase().indexOf(currChar);
                if(idx != -1){
                    char newChar;
                    if (i % 2 == 0) {
                    newChar = shiftedAlphabet1.toLowerCase().charAt(idx);
                    //Replace the ith character of encrypted with newChar
                    }
                    else {
                        newChar = shiftedAlphabet2.toLowerCase().charAt(idx);
                    }
                    cc.setCharAt(i, newChar);
                }
            }
            //Otherwise: do nothing
        }
        //Your answer is the String inside of enc
        return cc.toString();
        
    }
    public String decrypt (String input){
       CaesarCipherTwo cc = new CaesarCipherTwo(26 - mainKey1, 26 - mainKey2);
       return cc.encrypt(input);
    }

}
