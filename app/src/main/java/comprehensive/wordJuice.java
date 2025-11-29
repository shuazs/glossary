package comprehensive;

//Every word has WordJuice this stores the POS and Definition combo.
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
}
