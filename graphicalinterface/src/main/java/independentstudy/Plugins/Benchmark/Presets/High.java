package independentstudy.Plugins.Benchmark.Presets;

import java.util.Random;

import independentstudy.Interfaces.BenchmarkInterface;
import independentstudy.settings.Settings;

public class High implements BenchmarkInterface {
    private String[] updatedValues;

    public void benchmarkProcess(Settings settings) throws InterruptedException {
        highSettings(settings);
    }

    private void highSettings(Settings settings) {
        String[] settingsArray = settings.getSettingsArray();
        updatedValues = new String[settingsArray.length];
        Random random = new Random();

        for (int i = 0; i < settingsArray.length; i++) {
            switch (settingsArray[i]) {
                case "Graphics Quality":
                    updatedValues[i] = "High";
                    break;
                case "Resolution":
                    updatedValues[i] = "1920x1080";
                    break;
                case "Anti-aliasing":
                    updatedValues[i] = "TAA";
                    break;
                default:
                    // randomly choose between "Low" and "High" for the rest of the settings
                    updatedValues[i] = random.nextBoolean() ? "Low" : "High";
                    break;
            }
        }

        settings.setValues(updatedValues);
        System.out.println("Settings changed to High");
    }

}
