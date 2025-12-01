package comprehensive;
/**
 * Every word has WordJuice this stores the POS and Definition combo.
 * @Author Joshua Varughese
 * @version 11/29/25
 */
public class WordJuice {
    private POS pos;
    private String definition;

    public WordJuice(POS pos, String def){
        this.pos = pos;
        this.definition = def;
    }

    //Getters
    public POS getPos(){
        return this.pos;
    }

    public String getDef(){
        return this.definition;
    }

    //setter
    void setDef(String def){
        this.definition = def;
    }
}
