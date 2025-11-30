package comprehensive;

public class Main {
    public static void main(String[] args) {
        Glossary glossary = new Glossary(args[0]);
        printMenu();
        int userIn = readNum();
    }

    // helper to get and read user inputs as Strings
    @SuppressWarnings("resource")
    private static String readLine() {
        //DON'T CLOSE SCANNER CAUSES BUGS
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String line = scanner.nextLine();
        return line;

    }

    // helper to get and read user inputs as ints
    @SuppressWarnings("resource")
    private static int readNum() {
        //DON'T CLOSE SCANNER CAUSES BUGS
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int num = scanner.nextInt();
        return num;
    }

    //menu
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
