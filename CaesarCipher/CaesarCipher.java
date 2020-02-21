import edu.duke.*;

public class CaesarCipher {
    
    public String encrypt(String input, int key) {
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet
        String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
        //Compute the shifted alphabet
        String shiftedAlphabetUpper = alphabetUpper.substring(key)+
        alphabetUpper.substring(0,key);
        String shiftedAlphabetLower = alphabetLower.substring(key)+
        alphabetLower.substring(0,key);
        String alphabet = alphabetUpper + alphabetLower;
        String shiftedAlphabet = shiftedAlphabetUpper + shiftedAlphabetLower;
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            //Find the index of currChar in the alphabet (call it idx)
            int idx = alphabet.indexOf(currChar);
            //If currChar is in the alphabet
            if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabet.charAt(idx);
                //Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i, newChar);
            }
            //Otherwise: do nothing
        }
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }
    public void testCaesar() {
        
        System.out.println(encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 15)); 
        
    }
    public String encryptTwoKeys(String input, int key1, int key2){
        StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet
        String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
        String alphabet = alphabetUpper + alphabetLower;
        //Compute the shifted alphabet
        String shiftedAlphabetUpperK1 = alphabetUpper.substring(key1)+
        alphabetUpper.substring(0,key1);
        String shiftedAlphabetLowerK1 = alphabetLower.substring(key1)+
        alphabetLower.substring(0,key1);
        String shiftedAlphabetK1 = shiftedAlphabetUpperK1 + shiftedAlphabetLowerK1;
        //shifted alphabet 2
        String shiftedAlphabetUpperK2 = alphabetUpper.substring(key2)+
        alphabetUpper.substring(0,key2);
        String shiftedAlphabetLowerK2 = alphabetLower.substring(key2)+
        alphabetLower.substring(0,key2);
        String shiftedAlphabetK2 = shiftedAlphabetUpperK2 + shiftedAlphabetLowerK2;
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            //Find the index of currChar in the alphabet (call it idx)
            int idx = alphabet.indexOf(currChar);
            //If currChar is in the alphabet
            if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                 //Replace the ith character of encrypted with newChar
                if (i % 2 == 0) {
                    char newChar = shiftedAlphabetK1.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                }
                else {
                    char newChar = shiftedAlphabetK2.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                }
            }
            //Otherwise: do nothing
        }
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }
    public void testEncryptTwoKeys() {
        
        System.out.println(encryptTwoKeys("Top ncmy qkff vi vguv vbg ycpx", 24, 6)); 
        
    }
}

