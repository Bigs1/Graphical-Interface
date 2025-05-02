package independentstudy.Plugins.Benchmark.Presets;

import java.util.Random;

import independentstudy.Interfaces.BenchmarkInterface;
import independentstudy.settings.Settings;

public class Ultra implements BenchmarkInterface {

    private String[] updatedValues;

    public void benchmarkProcess(Settings settings) throws InterruptedException {
        ultraSettings(settings);
    }

    private void ultraSettings(Settings settings) {
        String[] settingsArray = settings.getSettingsArray();
        updatedValues = new String[settingsArray.length];
        Random random = new Random();

        for (int i = 0; i < settingsArray.length; i++) {
            switch (settingsArray[i]) {
                case "Graphics Quality":
                    updatedValues[i] = "Ultra";
                    break;
                case "Resolution":
                    updatedValues[i] = "1920x1080";
                    break;
                case "Anti-aliasing":
                    updatedValues[i] = "FXAA";
                    break;
                default:
                    // randomly choose between "Low" and "High" for the rest of the settings
                    updatedValues[i] = random.nextBoolean() ? "Low" : "High";
                    break;
            }
        }

        settings.setValues(updatedValues);
        System.out.println("Settings changed to Ultra");

    }

}
