public class Engine {

    private static Elements e = new Elements();
    private static Polyatomics pa = new Polyatomics();
    private static Codebase cb = new Codebase();

    //looks up an element:
    public static void lookup(String symbol) {

        for (int i = 0; i < e.elements.length; i++) {
            if (e.elements[i][0].equals(symbol)) {
                System.out.println("Element:        " + e.elements[i][1]);
                System.out.println("Atomic number:  " + e.elements[i][2]);
                System.out.println("Atomic mass:    " + e.elements[i][3]);
                return;
            }
        }

        System.out.println("symbol not found: " + symbol);
    }

    //looks up a polyatomic:
    public static void palookup(String name) {

        name = name.toLowerCase();

        for (int i = 0; i < pa.polyatomics.length; i++) {
            if (pa.polyatomics[i][0].toLowerCase().equals(name)) {
                System.out.println("Name: " + pa.polyatomics[i][0]);
                System.out.println("Formula: " + pa.polyatomics[i][1]);
                System.out.println("Charge: " + pa.polyatomics[i][2]);
                return;
            }
        }

        System.out.println("polyatomic not found: " + name);
    }

    //calculates the molar mass of a compound:
    public static void calculateMolarMass(String elements) {

        String[] elementArr = elements.split(" ");
        double mass = 0;

        for (int i = 0; i < elementArr.length; i++) {

            String currentNumber  = "";

            for (int j = 0; j < elementArr[i].length(); j++) {
                if (cb.isInt(elementArr[i].charAt(j))) {
                    currentNumber = currentNumber + elementArr[i].charAt(j);
                }
            }

            int currentCoefficient = Integer.parseInt(currentNumber);
            String currentSymbol = elementArr[i].replace(currentNumber, "");

            if (!cb.elementExists(currentSymbol)) {
                System.out.println("symbol not found: " + currentSymbol);
                return;
            }

            mass = mass + (currentCoefficient * cb.getElementMass(currentSymbol));
        }

        System.out.println(mass + " g/mol");
    }

    //limiting reactant calculator:
    public static void lr(String compound1, String compound2, double grams1, double grams2, double mr1, double mr2) {

        double mm1 = cb.getMM(compound1);
        double mm2 = cb.getMM(compound2);
        double moles1 = grams1 / mm1;
        double moles2 = grams2 / mm2;

        //Assume that all of compound1 reacts:
        double theoretical2 = (mr2 / mr1) * moles1;
        if (moles2 < theoretical2) {
            System.out.println("lr: " + compound2);
            return;
        }

        //Assume that all of compound2 reacts:
        double theoretical1 = (mr1 / mr2) * moles2;
        if (moles1 < theoretical1) {
            System.out.println("lr: " + compound1);
            return;
        }

        //If there is no limiting reactant:
        System.out.println("no limiting reactant.");
    }
}