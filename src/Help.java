public class Help {

    public static void display() {
        System.out.println("help:                       Shows all available commands.");
        System.out.println("exit:                       Closes the shell.");
        System.out.println("lookup (symbol):            Looks up the information of an element.");
        System.out.println("palookup (name):            Looks up the information of a polyatomic ion.");
        System.out.println("mm (symbol):                Finds the molar mass of a compound, for exmaple: 1N 4H 1Cl.");
        System.out.println("moles (symbol, grams):      Converts grams of a substance to moles, for example: 2H 1O, 198.2");
        System.out.println("lr:                         Limiting reactant calculator between two compounds with mole ratios.");
    }
}
