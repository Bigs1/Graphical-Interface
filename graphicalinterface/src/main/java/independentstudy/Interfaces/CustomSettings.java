package independentstudy.Interfaces;

import independentstudy.app.App;

public class CustomSettings {
    private String[] settingsArray;
    private String[] values;

    public CustomSettings(String[] settingsArray, String[] values) {
        this.settingsArray = settingsArray;
        this.values = values;
    }

    public void changeSetting(int index, String newValue) { // method to change desired value at the given index
        if (index >= 0 && index < settingsArray.length) {
            values[index] = newValue;
        } else {
            System.out.println("Invalid setting index.");
        }
    }

    public void displaySettings() { // display the custom settings
        System.out.println("Current Settings:");
        for (int i = 0; i < settingsArray.length; i++) {
            System.out.println(settingsArray[i] + ": " + values[i]);
        }
    }

    public String[] getValues() { // method to get the values
        return values;
    }

    public void changeSettingsManually() { // method to get user input to change the settings
        System.out.println("Enter the index of the setting you want to change:");
        int index = Integer.parseInt(App.scanner.nextLine());
        if (index >= 0 && index < settingsArray.length) {
            System.out.println("Enter the new value for " + settingsArray[index] + ":");
            String newValue = App.scanner.nextLine();
            changeSetting(index, newValue); // Change the setting
        } else {
            System.out.println("Invalid setting index.");
        }
    }
}
