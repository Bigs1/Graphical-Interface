package independentstudy.settings;

public class Settings {
    private String[] settingsArray;
    private String[] values;

    // Constructor to initialize settingsArray and values
    public Settings() {
        //Starting array of values and fields
        this.settingsArray = new String[] {
                "Graphics Quality",
                "Resolution",
                "Anti-aliasing",
                "Texture Quality",
                "Shadow Quality",
                "Anisotropic Filtering",
                "V-Sync",
                "Frame Rate Limit",
                "Gamma Correction",
                "Brightness",
                "Contrast"
        };

        this.values = new String[] {
                "High",
                "1920x1080",
                "4x",
                "High",
                "High",
                "16x",
                "On",
                "Unlimited",
                "1.0",
                "Medium",
                "Medium"
        };
    }

    // Getters and setters
    public String[] getSettingsArray() {
        return settingsArray;
    }

    public void setSettingsArray(String[] settingsArray) {
        this.settingsArray = settingsArray;
    }

    public String[] getValues() {
        return values;
    }

    public void setValues(String[] values) {
        this.values = values;
    }

    // Method to get combined array
    public String[][] getCombinedArray() {
        String[][] combinedArray = new String[settingsArray.length][2];
        for (int i = 0; i < settingsArray.length; i++) {
            combinedArray[i][0] = settingsArray[i];
            combinedArray[i][1] = values[i];
        }
        return combinedArray;
    }

    // Method to print combined array
    public void printCombinedArray() {
        System.out.println("Settings and Values (Field index starts at 0):");
        for (String[] setting : getCombinedArray()) {
            System.out.println(setting[0] + ": " + setting[1]);
        }
    }
}
