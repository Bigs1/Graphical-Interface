package independentstudy.Plugins.Benchmark.Presets;

import independentstudy.Interfaces.BenchmarkInterface;
import independentstudy.Registries.BenchReg;
import independentstudy.settings.Settings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CreateCustom implements BenchmarkInterface {
    private Map<String, String[]> customPresetList = new HashMap<>();
    private BenchReg benchReg;
    private Scanner scanner = new Scanner(System.in);
    private String name;

    public CreateCustom(BenchReg benchReg, String name) {
        this.benchReg = benchReg;
        this.name = name;
    }

    public void benchmarkProcess(Settings settings) throws InterruptedException {
        activatePreset(settings); // activate the desired preset
    }

    public void modifySettings(Settings settings) {
        if (name == null) { // if we don't have a name
            System.out.println("Preset name not specified. Exiting...");
            return;
        }

        String[] settingsArray = settings.getSettingsArray(); // get list of settings
        String[] presetValues = new String[settingsArray.length]; // make an array for the preset being built

        for (int i = 0; i < settingsArray.length; i++) {
            System.out.println("Enter value for " + settingsArray[i] + ":");
            String userInput = scanner.nextLine();

            presetValues[i] = userInput; // store the values input
        }

        // Create a new map entry for the custom preset
        customPresetList.put(name, presetValues.clone()); // clone to avoid reference sharing
        benchReg.addPreset(name, this); // add reset to registry
        System.out.println("Custom preset \"" + name + "\" added to the registry.");
    }

    public void activatePreset(Settings settings) {
        if (name == null) {
            System.out.println("Preset name not specified. Exiting...");
            return;
        }

        String[] presetValues = customPresetList.get(name); // Retrieve values for the requested preset
        if (presetValues != null) {
            settings.setValues(presetValues); // will only update if the array of values have values
            System.out.println("Preset \"" + name + "\" activated.");
        } else {
            System.out.println("Preset \"" + name + "\" not found.");
        }
    }
}