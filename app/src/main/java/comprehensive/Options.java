package comprehensive;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * The larger menu options will be implemented here to keep main.java clean
 * 
 * @author Joshua Varughese
 * @version 11/30/25
 */
public class Options {
    
    /**
     * Get a word from the user and return all wordjuice
     * @param glossary
     */
    public static void getWordMain(Glossary glossary) {
        System.out.print("Select a word: ");
        String userWord = readLine();
        try{
            //store the values
            ArrayList<WordJuice> w = glossary.getWord(userWord);
            
            //sort them by POS lexographically and then definition lexographically
            w.sort(Comparator
                .comparing((WordJuice wj) -> wj.getPos().toString())
                .thenComparing((WordJuice wj) -> wj.getDef())    
            );
            
            //print
            for(WordJuice wj : w){
                String pos = wj.getPos().toString().toLowerCase();
                System.out.println(pos + ".  " + wj.getDef());
            }

            //space line
            System.out.println("");


        }
        catch(IllegalArgumentException e){
            System.out.println("userWord is not in the glossary!");
        }
    }

    // helper to get and read user inputs as Strings
    @SuppressWarnings("resource")
    private static String readLine() {
        // DON'T CLOSE SCANNER CAUSES BUGS
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String line = scanner.nextLine();
        return line.toLowerCase();

    }
}
