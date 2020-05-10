import java.util.Scanner;

public class Main {

    static Scanner scn = new Scanner(System.in);
    static Engine engine = new Engine();
    static Help help = new Help();
    static Codebase cb = new Codebase();

    public static void main(String[] args) {
        init();
    }

    //command loop:
    private static void commandLoop() {

        System.out.print("> ");
        String[] args = scn.nextLine().split(" ");
        String command = args[0].toLowerCase();

        //event for when no command is entered:
        if (command.length() < 1) {
            commandLoop();
            return;
        }

        //checks if the command exists:
        if (!cb.commandExists(command)) {
            System.out.println("invalid command: " + command);
            commandLoop();
            return;
        }

        //help command:
        if (command.equals("help")) {
            help.display();
        }

        //lookup command:
        if (command.equals("lookup")) {
            try {
                engine.lookup(args[1]);
            }
            catch (Exception e) {
                System.out.println("usage: lookup (symbol)");
            }
        }

        //polyatomic lookup command:
        if (command.equals("palookup")) {
            try {
                engine.palookup(args[1]);
            }
            catch (Exception e) {
                System.out.println("palookup (name)");
            }
        }

        //molar mass calculation command:
        if (command.equals("mm")) {

            try {
                String elements = "";
                for (int i = 1; i < args.length; i++) {
                    elements = elements + args[i] + " ";
                }
                engine.calculateMolarMass(elements);
            }
            catch (Exception e) {
                System.out.println("usage: mm (coefficient, symbol)");
            }
        }

        //limiting reactant calculator:
        if (command.equals("lr")) {

            try {
                System.out.print("compound 1:     ");
                String compound1 = scn.nextLine();
                System.out.print("compound 2:     ");
                String compound2 = scn.nextLine();
                System.out.print("mass (grams) 1: ");
                double grams1 = Double.valueOf(scn.nextLine());
                System.out.print("mass (grams) 2: ");
                double grams2 = Double.valueOf(scn.nextLine());
                System.out.print("mole ratio 1:   ");
                double mr1 = Double.valueOf(scn.nextLine());
                System.out.print("mole ratio 2:   ");
                double mr2 = Double.valueOf(scn.nextLine());

                engine.lr(compound1, compound2, grams1, grams2, mr1, mr2);
            }
            catch (Exception e) {
                System.out.println(e.toString());
            }
        }

        //moles calculator:
        if (command.equals("moles")) {

            try {

                String elements = "";
                for (int i = 1; i < args.length - 1; i++) {
                    elements = elements + args[i] + " ";
                }

                System.out.println(cb.moles(elements, Double.valueOf(args[args.length - 1])));
            }
            catch (Exception e) {
                System.out.println("usage: moles (symbol, grams)");
            }
        }

        //exit command:
        if (command.equals("exit")) {
            System.exit(0);
        }

        //recursive call, must be at bottom of function:
        commandLoop();
    }

    //init void:
    private static void init() {
        System.out.println("chemtools cli - type 'help' for help");
        commandLoop();
    }
}