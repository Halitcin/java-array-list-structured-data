
/**
 * Write a description of CodonCount here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.util.*;

public class CodonCount {
    private HashMap<String, Integer> codons;
    public CodonCount(){
    codons = new HashMap<String, Integer>();
    }
    public void buildCodonMap(int start, String dna){
        codons.clear();
        dna = dna.toLowerCase();
        for (int i = start; i < dna.length(); i = i+3){
            if (i+3 >= dna.length()) {
                break;
            }
            else {
                String codon = dna.substring(i, i+3);
                if (codons.containsKey(codon)){
                    codons.put(codon, codons.get(codon)+1);
                }
                else {
                    codons.put(codon, 1);
                }
                
            }
        }
    }
    public String getMostCommonCodon(){
        int max = 0;
        String maxCodon = null;
        for (String s : codons.keySet()){
            if (codons.get(s) > max) {
                max = codons.get(s);
                maxCodon = s;
            }
        }
        return maxCodon;
    }
    public void printCodonCounts(int start, int end){
        for (String s : codons.keySet()){
            if (codons.get(s) >= start && codons.get(s) <= end) {
                System.out.println(s + "\t" + codons.get(s));
                
            }
        }
    }
    public void tester(){
        CodonCount cc = new CodonCount();
        FileResource fr = new FileResource();
        /*for (int i = 0; i < 3; i++){
            cc.buildCodonMap (i, fr.asString().trim());
            System.out.println(cc.codons.size());
            //printCodonCounts(1, 5);
        }*/
        cc.buildCodonMap (1, fr.asString().trim());
        System.out.println(cc.getMostCommonCodon());
    }
}
