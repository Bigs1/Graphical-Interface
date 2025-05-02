package independentstudy.Plugins.Benchmark;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import independentstudy.Interfaces.BenchmarkInterface;
import independentstudy.settings.Settings;

public class Default implements BenchmarkInterface {
    private String[] updatedValues;

    public void benchmarkProcess(Settings settings) throws InterruptedException {

        System.out.println("Connecting to database server");
        TimeUnit.SECONDS.sleep(1); // simlate a 1 second display
        System.out.println("Gathering system info");
        TimeUnit.SECONDS.sleep(1); // simlate a 1 second display
        System.out.println("Searching for updates");
        TimeUnit.SECONDS.sleep(1); // simlate a 1 second display
        System.out.println("Running tests");
        TimeUnit.SECONDS.sleep(1); // simlate a 1 second display

        Random random = new Random();
        int randomValue = random.nextInt(2) + 1; // Randomly selects 1 or 2

        if (randomValue == 1) {
            System.out.println("Settings not changed");
        } else {
            randomizeSettings(settings);
        }
    }

    private void randomizeSettings(Settings settings) {
        //randomizing default values because default may actually differ from computer to computer, thus the default doesnt matter
        String[] settingsArray = settings.getSettingsArray();
        updatedValues = new String[settingsArray.length];
        Random random = new Random();

        for (int i = 0; i < settingsArray.length; i++) {
            switch (settingsArray[i]) {
                case "Graphics Quality":
                    updatedValues[i] = getRandomGraphicsQuality(random);
                    break;
                case "Resolution":
                    updatedValues[i] = getRandomResolution(random);
                    break;
                case "Anti-aliasing":
                    updatedValues[i] = getRandomAntiAliasing(random);
                    break;
                default:
                    // randomly choose between "Low" and "High" for the rest of the settings
                    updatedValues[i] = random.nextBoolean() ? "Low" : "High";
                    break;
            }
        }

        settings.setValues(updatedValues);// set the values in settings
        System.out.println("Settings updated successfully");
    }

    //list of random values

    private String getRandomGraphicsQuality(Random random) {
        String[] options = { "Low", "Medium", "High", "Ultra" };
        return options[random.nextInt(options.length)];
    }

    private String getRandomResolution(Random random) {
        String[] options = { "800x600", "1024x768", "1280x720", "1920x1080" };
        return options[random.nextInt(options.length)];
    }

    private String getRandomAntiAliasing(Random random) {
        String[] options = { "Off", "2x", "4x", "8x" };
        return options[random.nextInt(options.length)];
    }

    // Getter for the updated values array
    public String[] getUpdatedValues() {
        return updatedValues;
    }
}
