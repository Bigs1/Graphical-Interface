package independentstudy.Plugins.Benchmark.Presets;

import java.util.Random;

import independentstudy.Interfaces.BenchmarkInterface;
import independentstudy.settings.Settings;

public class Medium implements BenchmarkInterface {
    private String[] updatedValues;

    private void mediumSettings(Settings settings) {
        String[] settingsArray = settings.getSettingsArray();
        updatedValues = new String[settingsArray.length];
        Random random = new Random();

        for (int i = 0; i < settingsArray.length; i++) {
            switch (settingsArray[i]) {
                case "Graphics Quality":
                    updatedValues[i] = "Medium";
                    break;
                case "Resolution":
                    updatedValues[i] = "1920x1080";
                    break;
                case "Anti-aliasing":
                    updatedValues[i] = "MLAA";
                    break;
                default:
                    // randomly choose between "Low" and "High" for the rest of the settings
                    updatedValues[i] = random.nextBoolean() ? "Low" : "High";
                    break;
            }
        }

        settings.setValues(updatedValues);
        System.out.println("Settings changed to Medium");
    }

    public void benchmarkProcess(Settings settings) throws InterruptedException {
        mediumSettings(settings);
    }
}
