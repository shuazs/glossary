package comprehensive;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;
/**
 * A treemap that has a word for the key and an array list of word juice for the value
 * @author Joshua Varughese
 * @version 11/29/25
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

    //Update def for option 7
    public void updateDef(String word, int index, String newDef){
        ArrayList<WordJuice> w = glossary.get(word);
        WordJuice wj = w.get(index);
        wj.setDef(newDef);
    }

    //delete def for option 8
    public void deleteDef(String word, int index){
        ArrayList<WordJuice> w = glossary.get(word);
        w.remove(index);
        this.definitionCount--;
        if(w.size() == 0){
            glossary.remove(word);
            this.wordCount--;
        }
        
        computePosUsed();
    }


    //3
    //Gets the POS and Def for a word
    public ArrayList<WordJuice> getWord(String word) throws IllegalArgumentException{
        if(glossary.get(word) == null){
            //TODO:handle this exception in main
            throw new IllegalArgumentException("Word does not exsist");
        }
        return glossary.get(word);
    }

    //2
    //Gets word in range
    public ArrayList<String> getWordsInRange(String word1, String word2){
        ArrayList<String> words = new ArrayList<>();

        //iterate over the keys in the range and put them in word
        for(String key:glossary.subMap(word1, true, word2, true).keySet()){
            words.add(key);
        }
        return words;
    } 
    
    //4
    //Gets first word
    public String getFirstWord(){
        return glossary.firstKey();
    }

    //5
    //Gets last word
    public String getLastWord(){
        return glossary.lastKey();
    }

    //1
    //Getters for option 1
    public int getWordCount(){
        return this.wordCount;
    }

    public int getDefCount(){
        return this.definitionCount;
    }

    //TODO:format in main avg def per word to 3 dec 
    //format in main
    public float getAvgDefPerWord(){
        if(wordCount == 0){
            return 0;
        }
        return (float) this.definitionCount/this.wordCount;
    }

    public HashSet<POS> getPosUsed(){
        return this.posUsed;
    }

    //Helper to recompute the POS used metadata
    private void computePosUsed(){
        posUsed.clear();
        for(ArrayList<WordJuice> w : glossary.values()){
            for(WordJuice wj : w){
                posUsed.add(wj.getPos());
            }
        }
    }

    //package private getter for FileLoader
    TreeMap<String, ArrayList<WordJuice>> getGlossary(){
        return this.glossary;
    }

}
