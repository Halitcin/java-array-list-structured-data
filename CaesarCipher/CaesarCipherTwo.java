
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
    public CaesarCipherTwo(int key1, int key2){
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1= alphabet.substring(key1) + alphabet.substring(0,key1);
        shiftedAlphabet2= alphabet.substring(key2) + alphabet.substring(0,key2);
    }
    public String encrypt(String input){
        
    }

}
