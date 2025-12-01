package comprehensive;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * The larger menu options will be implemented here to keep main.java clean
 * All option methods are private or package private
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
        String adpw = String.format("%.3f", glossary.getAvgDefPerWord()); 
        System.out.println("definitions per word: " + adpw);
        System.out.println("parts of speach: " + glossary.getPosUsed().size());
        System.out.println("first word: " + glossary.getFirstWord());
        System.out.println("last word: " + glossary.getLastWord());
        System.out.println("");
    }

    /**
     * Get the words from blank to blank inclusive
     * option 2
     * 
     * @param glossary
     */
    static void getWordsInRangeMain(Glossary glossary) {
        System.out.print("Starting word: ");
        String word1 = readLine();
        System.out.println("");
        System.out.print("Ending word: ");
        String word2 = readLine();
        System.out.println("");
        try {
            ArrayList<String> wordList = glossary.getWordsInRange(word1, word2);
            System.out.println("The words between " + word1 + " and " + word2 + " are:");
            for (String word : wordList) {
                System.out.println(word);
            }
            System.out.println("");
        } catch (IllegalArgumentException e) {
            System.out.println("The starting word must come before than the ending word");
        }

    }

    /**
     * Get a word from the user and return all wordjuice
     * Option 3
     * 
     * @param glossary
     */
    static void getWordMain(Glossary glossary) {
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
            System.out.println("Word is not in the glossary!");
        }
    }

    // 4 5 are implemented in main in a few lines

    /**
     * Gets a word and returns just the POS
     * option 6
     * 
     * @param glossary
     */
    static void getWordPosMain(Glossary glossary) {
        System.out.print("Select a word: ");
        String userWord = readLine();
        try {
            // store the values
            ArrayList<WordJuice> w = glossary.getWord(userWord);

            // sort them by POS lexographically
            w.sort(Comparator
                    .comparing((WordJuice wj) -> wj.getPos().toString()));

            String lastPos = null;
            // print
            System.out.println(userWord);
            System.out.println("");
            for (WordJuice wj : w) {
                String pos = wj.getPos().toString().toLowerCase();
                // no dups
                if (!pos.equals(lastPos)) {
                    System.out.println(pos);
                    lastPos = pos;
                }

            }

            System.out.println("");

        } catch (IllegalArgumentException e) {
            System.out.println("Word is not in the glossary!");
        }
    }

    /**
     * Find the word and return the definitions and an option to go back
     * Based on selection update that def
     * Option 7
     * 
     * @param glossary
     */
    static void updateDefMain(Glossary glossary) {
        System.out.print("Select a word: ");
        String userWord = readLine();
        try {
            ArrayList<WordJuice> w = glossary.getWord(userWord);

            // sort them by POS lexographically and then definition lexographically
            w.sort(Comparator
                    .comparing((WordJuice wj) -> wj.getPos().toString())
                    .thenComparing((WordJuice wj) -> wj.getDef()));

            // Print the defs as possible options
            System.out.println("Definitions for " + userWord);
            int i = 1;
            for (WordJuice wj : w) {
                System.out.println(i + ". " + wj.getPos().toString().toLowerCase()
                        + "   " + wj.getDef());
                i++;
            }
            System.out.println(i + ". Back to main menu");

            // loop until user exits or has proper input
            while (true) {
                System.out.print("Select an option: ");
                int userNum = readNum();
                userNum--;
                if (userNum == -2) {
                    System.out.print("Invalid Input: ");
                    continue;
                } else if (userNum < w.size() && userNum >= 0) {
                    System.out.print("Type a new definition: ");
                    String newDef = readLine();
                    glossary.updateDef(userWord, userNum, newDef);
                    System.out.println("Changed!");
                    return;
                } else if (userNum == i - 1) {
                    return;
                }
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Word is not in the glossary!");
        }

    }

    /**
     * Option 8
     * Gives the definitions for word and then options to delete
     * 
     * @param glossary
     */
    static void deleteDefMain(Glossary glossary) {
        System.out.print("Select a word: ");
        String userWord = readLine();
        try {
            ArrayList<WordJuice> w = glossary.getWord(userWord);

            // sort them by POS lexographically and then definition lexographically
            w.sort(Comparator
                    .comparing((WordJuice wj) -> wj.getPos().toString())
                    .thenComparing((WordJuice wj) -> wj.getDef()));

            // Print the defs as possible options
            System.out.println("Definitions for " + userWord);
            int i = 1;
            for (WordJuice wj : w) {
                System.out.println(i + ". " + wj.getPos().toString().toLowerCase()
                        + "   " + wj.getDef());
                i++;
            }
            System.out.println(i + ". Back to main menu");

            // loop until user exits or has proper input
            while (true) {
                System.out.print("Select an option: ");
                int userNum = readNum();
                userNum--;
                if (userNum == -2) {
                    System.out.println("Invalid Input: ");
                    continue;
                } else if (userNum < w.size() && userNum >= 0) {
                    if (glossary.deleteDef(userWord, userNum)) {
                        System.out.println(userWord + " removed");
                    }
                    return;
                } else if (userNum == i - 1) {
                    return;
                }
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Word is not in the glossary!");
        }

    }

    /**
     * Option 9 add a definition
     * Ask for a word
     * Present POS
     * ask for pos
     * ask for def
     * add
     * 
     * @param glossary
     */
    static void addDefMain(Glossary glossary) {
        // txt to pos throws an error
        System.out.print("Type a word: ");
        String word = readLine();
        System.out.println("Valid parts of speach: noun, verb, adj, pron, prep, conj, interj");
        while(true){
            try {    
            System.out.print("Type a valid part of speach: ");
            String posString = readLine();
            POS pos = POS.txtToPOS(posString);
            System.out.print("Type a definition: ");
            String def = readLine();
            glossary.addDef(word, pos, def);
            System.out.println("Succsesfully added!");
            return;
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid POS");
            continue;
        }
        }
        
    }

    /**
     * Option 10 write to the file
     * 
     * @param glossary
     * 
     */
    static void saveMain(Glossary glossary) {
        System.out.print("Enter filename with path: ");
        String file = readLine();
        FileLoader.unload(file, glossary);
    }

    /**
     * Given a word return word juice
     * Helper
     * 
     * @param glossary
     * @param word
     */
    static void getWordMain(Glossary glossary, String word) {
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
        return scanner.nextLine();
    }

    // helper to get and read user inputs as ints
    @SuppressWarnings("resource")
    private static int readNum() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String line = scanner.nextLine();
        try {
            return Integer.parseInt(line.trim());
        } catch (NumberFormatException e) {
            return -1;
        }

    }
}
