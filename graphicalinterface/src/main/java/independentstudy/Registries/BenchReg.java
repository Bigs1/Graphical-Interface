package independentstudy.Registries;

import independentstudy.Interfaces.BenchmarkInterface;
import independentstudy.Plugins.Benchmark.Default;
import independentstudy.Plugins.Benchmark.Presets.CreateCustom;
import independentstudy.Plugins.Benchmark.Presets.High;
import independentstudy.Plugins.Benchmark.Presets.Low;
import independentstudy.Plugins.Benchmark.Presets.Medium;
import independentstudy.Plugins.Benchmark.Presets.Ultra;
import independentstudy.settings.Settings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BenchReg {
    private Map<String, BenchmarkInterface> benchmarkRegistry = new HashMap<>();
    private Scanner scanner;
    private Settings settings;

    public BenchReg(Scanner scanner) {
        this.scanner = scanner;
        this.settings = new Settings(); // Initialize settings
        initializeDefaultPresets();
    }

    private void initializeDefaultPresets() {
        // add pre-made presets
        benchmarkRegistry.put("Default", new Default());
        benchmarkRegistry.put("Ultra", new Ultra());
        benchmarkRegistry.put("High", new High());
        benchmarkRegistry.put("Medium", new Medium());
        benchmarkRegistry.put("Low", new Low());
    }

    public void addPreset(String name, BenchmarkInterface preset) {
        benchmarkRegistry.put(name, preset); //adds preset to registry hash map
    }

    public BenchmarkInterface getPreset(String name) {
        return benchmarkRegistry.get(name); //get preset from the list
    }

    public void listPresets() { //list all current presets in the hash map
        System.out.println("Available Presets:");
        for (String name : benchmarkRegistry.keySet()) {
            System.out.println(name);
        }
    }

    public void enterBenchReg() throws InterruptedException { //what the user interacts with to get registries
        //possibly should have been its own class but imo the user would be saying "optimize it for me" and then select items from the server if they wanted
        while (true) {
            System.out.println("Choose an option");
            listPresets(); //list presets in registry
            System.out.println("Or type 'Create preset' to create a new preset to add to registry");
            System.out.println("Type 'exit' to leave");

            String input = scanner.nextLine(); //get user input
            if (input.equalsIgnoreCase("exit")) {
                break;
            } else if (input.equalsIgnoreCase("create preset")) {
                createCustomPreset(); //create custom preset which the preset should be a NEW Custom Preset with its own name
            } else if (benchmarkRegistry.containsKey(input)) {
                executePreset(input); //execute called preset
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void createCustomPreset() throws InterruptedException { //start the creation process of the custom preset/plugin
        System.out.println("Enter the name for the custom preset:");
        String presetName = scanner.nextLine(); //get name for the preset
        CreateCustom customPreset = new CreateCustom(this, presetName); //create the plugin with this preset connecting it to this registry
        addPreset(presetName, customPreset); // add the preset to the list
        customPreset.modifySettings(settings); //allow the user to modify the settings of the preset
        customPreset.benchmarkProcess(settings); //activates the preset after it is made
        System.out.println("Custom preset \"" + presetName + "\" added to the registry."); //confirms it has been added to the registry
    }

    private void executePreset(String presetName) {
        BenchmarkInterface preset = benchmarkRegistry.get(presetName);
        try {
            preset.benchmarkProcess(settings); // Pass the Settings object so that when the preset is activated, it updates the settings
            settings.printCombinedArray(); // Print updated settings
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}