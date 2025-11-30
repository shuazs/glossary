package comprehensive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Reads the text file and turns it into a glossary
 * 
 * @author Joshua Varughese
 * @version 11/29/25
 */
public class FileLoader {

    /**
     * file -> glossary
     * @param file - filepath
     * @param glossary - glossary!
     */
    public static void load(String file, Glossary glossary){
        try{
            File f = new File(file);
            Scanner scanner = new Scanner(f);

            //while there are lines left
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                //split by section
                String[] sections = line.split("::");
                //assign everything to apporpriate place
                String word = sections[0];
                POS pos = POS.txtToPOS(sections[1]);
                String def = sections[2];
                //add to glossary
                glossary.addDef(word, pos, def);
            }

            scanner.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found :/");
        }
        
    }

}
