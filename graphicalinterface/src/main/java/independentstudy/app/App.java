package independentstudy.app;

import java.util.Scanner;

import independentstudy.Interfaces.CustomSettings;
import independentstudy.Interfaces.Overlay;
import independentstudy.Registries.BenchReg;
import independentstudy.settings.Settings;

public class App {
    public static Scanner scanner = new Scanner(System.in); // initialize the scanner

    public static int getNextInt() {
        return Integer.parseInt(scanner.nextLine());
    }

    public static String getNextLine() {
        return scanner.nextLine();
    }

    public static void main(String[] args) throws InterruptedException {
        Settings settings = new Settings();
        CustomSettings customsettings = new CustomSettings(settings.getSettingsArray(), settings.getValues());
        Overlay overlay = new Overlay();
        BenchReg benchreg = new BenchReg(scanner); // Pass the scanner to BenchReg constructor

        int input = 0;

        while (input != 6) {
            System.out.println("Graphical Interface"
                    + "\nWhat would you like to do?"
                    + "\n1) Change Settings"
                    + "\n2) Benchmark"
                    + "\n3) Enter Overlay"
                    + "\n4) Current Settings"
                    + "\n6) Exit");

            input = getInput();

            switch (input) {
                case 1:
                    System.out.println("Change Settings");
                    settings.printCombinedArray(); // print out before changed settings
                    customsettings.changeSettingsManually();
                    // Get the updated values array from CustomSettings and set it in Settings
                    settings.setValues(customsettings.getValues());
                    System.out.println("Settings changed to: ");
                    settings.printCombinedArray();
                    break;
                case 2:
                    System.out.println("Benchmark");
                    // Call benchmark process and update settings
                    benchreg.enterBenchReg(); // Assuming benchmarking is managed within BenchReg
                    break;
                case 3:
                    System.out.println("Enter Overlay");
                    // Enter overlay here
                    overlay.enterOverlay();
                    break;
                case 4:
                    System.out.println("Current Settings:");
                    settings.printCombinedArray(); // just get the currently set settings
                    break;
                case 6:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static int getInput() {
        int input = Integer.parseInt(scanner.nextLine());
        return input;
    }
}