public class Codebase {

    private static Elements e = new Elements();
    private static Polyatomics pa = new Polyatomics();
    public static String[] commands = new String[]{"help", "exit", "lookup", "palookup", "mm", "lr", "moles"};

    //checks if a command exists:
    public boolean commandExists(String command) {

        command = command.toLowerCase();
        for (int i = 0; i < commands.length; i++) {
            if (commands[i].equals(command)) {
                return true;
            }
        }

        return false;
    }

    //checks if a char is an integer or not:
    public static boolean isInt(char x) {
        return Character.isDigit(x);
    }

    //finds the atomic mass of an element:
    public static double getElementMass(String symbol) {

        for (int i = 0; i < e.elements.length; i++) {
            if (e.elements[i][0].equals(symbol)) {
                return Double.valueOf(e.elements[i][3]);
            }
        }

        return -1;
    }

    //checks if an element exists:
    public static boolean elementExists(String symbol) {

        for (int i = 0; i < e.elements.length; i++) {
            if (e.elements[i][0].equals(symbol)) {
                return true;
            }
        }

        return false;
    }

    //returns the molar mass of a compound as a double:
    public static double getMM(String elements) {

        String[] elementArr = elements.split(" ");
        double mass = 0;

        for (int i = 0; i < elementArr.length; i++) {

            String currentNumber = "";

            for (int j = 0; j < elementArr[i].length(); j++) {
                if (isInt(elementArr[i].charAt(j))) {
                    currentNumber = currentNumber + elementArr[i].charAt(j);
                }
            }

            int currentCoefficient = Integer.parseInt(currentNumber);
            String currentSymbol = elementArr[i].replace(currentNumber, "");

            mass = mass + currentCoefficient * getElementMass(currentSymbol);
        }

        return mass;
    }

    //converts grams of a substance to moles:
    public static double moles(String elements, double grams) {
        return grams / getMM(elements);
    }
}