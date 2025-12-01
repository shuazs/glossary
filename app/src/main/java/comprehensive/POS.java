package comprehensive;

/**
 * THE POS as an ENUM
 * 
 * @author Joshua Varughese
 * @version 11/29/25
 */
public enum POS {
    NOUN, VERB, ADJ, ADV, PRON, PREP, CONJ, INTERJ;

    // Helper method to turn a string into an POS
    public static POS txtToPOS(String txt) {
        if (txt == null) {
            throw new IllegalArgumentException("Txt was null!");
        }
        txt = txt.toUpperCase();
        switch (txt) {
            case "NOUN":
                return POS.NOUN;
            case "VERB":
                return POS.VERB;
            case "ADJ":
                return POS.ADJ;
            case "ADV":
                return POS.ADV;
            case "PRON":
                return POS.PRON;
            case "PREP":
                return POS.PREP;
            case "CONJ":
                return POS.CONJ;
            case "INTERJ":
                return POS.INTERJ;
            default:
                throw new IllegalArgumentException("The POS is not a valid POS!");
        }

    }
}
