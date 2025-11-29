package comprehensive;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;
/**
 * A treemap that has a word for the key and an array list of word juice for the value
 * @author Joshua Varughese
 * @version 11/29/26
 */
public class Glossary {
    //Metadata
    private int wordCount;
    private int definitionCount;
    private HashSet<POS> posUsed;

    /**
     * We use a TreeMap where each word is the key
     * Every word has an arraylist of WordJuice(pos def)
     * I chose this DS so we would have O(h) lookup and everything is kept in lexographic order
     */
    private TreeMap<String, ArrayList<WordJuice>> glossary;

    //Empty DS that FileLoader fills with the file info
    public Glossary(String file){
        this.wordCount = 0;
        this.definitionCount = 0;
        glossary = new TreeMap<>();
        posUsed = new HashSet<>();
        FileLoader.load(file, this);
    }

    public void addDef(String word, POS pos, String def){
        //get the list for the word
        ArrayList<WordJuice> list = glossary.get(word);
        
        //if the list doesn't exist
        if(list == null){
            //create list and add to glossary
            list = new ArrayList<>();
            glossary.put(word, list);
            wordCount++;
        }

        //add word juice and update metadata
        list.add(new WordJuice(pos, def));
        definitionCount++;
        posUsed.add(pos);
    }

    //Gets the POS and Def for a word
    public ArrayList<WordJuice> getWord(String word) throws IllegalArgumentException{
        if(glossary.get(word) == null){
            throw new IllegalArgumentException("Word does not exsist");
        }
        return glossary.get(word);
    }

    //Gets word in range
    public ArrayList<String> getWordsInRange(String word1, String word2){
        ArrayList<String> words = new ArrayList<>();

        return glossary.subMap(word1, word2);
    } 

    //Gets first word
    public String getFirstWord(String word){
        return glossary.firstKey();
    }

    //Gets last word
    public String getLastWord(String word){
        return glossary.lastKey();
    }


}
