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
     * Option 1
     * Words:
     * Defintions:
     * Def per Word 3 dec places:
     * Parts of speach used as a num:
     * first word:
     * last word:
     * 
     * @param glossary
     */
    public static void getMetaDataMain(Glossary glossary) {
        System.out.println("words: " + glossary.getWordCount());
        System.out.println("definitions: " + glossary.getDefCount());
        System.out.print("definitions per word: ");
        System.out.printf("%.3f", glossary.getAvgDefPerWord());
        System.out.println("");
        System.out.println("parts of speach: " + glossary.getPosUsed().size());
        System.out.println("first word: " + glossary.getFirstWord());
        System.out.println("last word: " + glossary.getLastWord());
        System.out.println("");
    }

    /**
     * Get the words from blank to blank inclusive 
     * option 2
     * @param glossary
     */
    public static void getWordsInRangeMain(Glossary glossary){
        System.out.print("Starting word: ");
        String word1 = readLine();
        System.out.println("");
        System.out.print("Ending word: ");
        String word2 = readLine();
        System.out.println("");
        ArrayList<String> wordList = glossary.getWordsInRange(word1, word2);
        System.out.println("The words between " + word1 + " and " + word2 + " are:");
        for(String word : wordList){
            System.out.println(word);
        }
        System.out.println("");
    }

    /**
     * Get a word from the user and return all wordjuice
     * Option 3
     * 
     * @param glossary
     */
    public static void getWordMain(Glossary glossary) {
        System.out.print("Select a word: ");
        String userWord = readLine();
        try {
            // store the values
            ArrayList<WordJuice> w = glossary.getWord(userWord);

            // sort them by POS lexographically and then definition lexographically
            w.sort(Comparator
                    .comparing((WordJuice wj) -> wj.getPos().toString())
                    .thenComparing((WordJuice wj) -> wj.getDef()));

            // print
            System.out.println(userWord);
            System.out.println("");
            for (WordJuice wj : w) {
                String pos = wj.getPos().toString().toLowerCase();
                System.out.println(pos + ".  " + wj.getDef());
            }

            System.out.println("");

        } catch (IllegalArgumentException e) {
            System.out.println("userWord is not in the glossary!");
        }
    }

    //4 5 are implemented in main in a few lines

    /**
     * Gets a word and returns just the POS
     * option 6
     * @param glossary
     */
    public static void getWordPosMain(Glossary glossary){
        System.out.print("Select a word: ");
        String userWord = readLine();
        try {
            // store the values
            ArrayList<WordJuice> w = glossary.getWord(userWord);

            // sort them by POS lexographically
            w.sort(Comparator
                    .comparing((WordJuice wj) -> wj.getPos().toString()));

            // print
            System.out.println(userWord);
            System.out.println("");
            for (WordJuice wj : w) {
                String pos = wj.getPos().toString().toLowerCase();
                System.out.println(pos);
            }

            System.out.println("");

        } catch (IllegalArgumentException e) {
            System.out.println("userWord is not in the glossary!");
        }
    }

    /**
     * Given a word return word juice
     * Helper
     * 
     * @param glossary
     * @param word
     */
    public static void getWordMain(Glossary glossary, String word) {
        // store the values
        ArrayList<WordJuice> w = glossary.getWord(word);

        // sort them by POS lexographically and then definition lexographically
        w.sort(Comparator
                .comparing((WordJuice wj) -> wj.getPos().toString())
                .thenComparing((WordJuice wj) -> wj.getDef()));

        // print
        System.out.println(word);
        System.out.println("");
        for (WordJuice wj : w) {
            String pos = wj.getPos().toString().toLowerCase();
            System.out.println(pos + ".  " + wj.getDef());
        }

        // space line
        System.out.println("");

    }

    // helper to get and read user inputs as Strings
    @SuppressWarnings("resource")
    private static String readLine() {
        // DON'T CLOSE SCANNER CAUSES BUGS
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println("");
        return line.toLowerCase();

    }
}
