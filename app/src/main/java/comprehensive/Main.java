package comprehensive;

public class Main {
    public static void main(String[] args) {
        Glossary glossary = new Glossary(args[0]);
        boolean running = true;
        while (running) {
            printMenu();
            int userIn = readNum();
            switch (userIn) {
                // get metadata
                case 1:
                    Options.getMetaDataMain(glossary);
                    break;
                // get words in range
                case 2:
                    Options.getWordsInRangeMain(glossary);
                    break;
                // get word
                case 3:
                    Options.getWordMain(glossary);
                    break;
                // get first word
                case 4:
                    System.out.println(glossary.getFirstWord());
                    Options.getWordMain(glossary, glossary.getFirstWord());
                    break;
                // get last word
                case 5:
                    String lastWord = glossary.getLastWord();
                    System.out.println(lastWord);
                    Options.getWordMain(glossary, lastWord);
                    break;
                // get parts of speach
                case 6:
                    Options.getWordPosMain(glossary);
                    break;
                // update definition
                case 7:
                    break;
                // delete definition
                case 8:
                    break;
                // Add new definition
                case 9:
                    break;
                // save dictionary
                case 10:
                    break;
                // exit
                case 11:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }

    //TODO: Handle invalid inputs!
    // helper to get and read user inputs as ints
    @SuppressWarnings("resource")
    private static int readNum() {
        // DON'T CLOSE SCANNER CAUSES BUGS
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println("");
        return num;
    }

    // menu
    private static void printMenu() {
        System.out.println("Main menu");
        System.out.println("1.  Get metadata");
        System.out.println("2.  Get words in range");
        System.out.println("3.  Get word");
        System.out.println("4.  Get first word");
        System.out.println("5.  Get last word");
        System.out.println("6.  Get parts of speech");
        System.out.println("7.  Update definition");
        System.out.println("8.  Delete definition");
        System.out.println("9.  Add new definition");
        System.out.println("10. Save dictionary");
        System.out.println("11. Quit");
        System.out.println(" ");
        System.out.print("Select an option: "); // colon + space
    }
}
