package independentstudy.Interfaces;

import java.util.Map;

import independentstudy.Interfaces.OverlayEvent.OverlayEventType;
import independentstudy.Plugins.overlay.CreatePlugin;
import independentstudy.Registries.OverlayReg;
import independentstudy.app.App;

public class Overlay {

    private OverlayReg overlayReg;

    private int input;

    public Overlay() {
        this.overlayReg = new OverlayReg();
    }

    public void enterOverlay() {
        while (true) { // while we dont exit allow an option to be chosen
            System.out.println("Choose an option:");
            int optionNum = 1;
            Map<String, OverlayInterface> plugins = overlayReg.getAllPlugins();

            // Show existing plugins
            for (String pluginName : plugins.keySet()) {
                System.out.println(optionNum + ") " + pluginName);
                optionNum++;
            }

            // Show option to create a custom plugin
            System.out.println(optionNum + ") Create Custom Plugin");

            // Show exit option
            System.out.println(optionNum + 1 + ") Exit");

            input = App.getNextInt();

            if (input >= 1 && input <= plugins.size()) {// make sure the input is within the limits of the amount of options available
                String selectedPluginName = (String) plugins.keySet().toArray()[input - 1]; //get the plugin we selected
                OverlayInterface selectedPlugin = plugins.get(selectedPluginName); //get the selected plugin
                try {
                    selectedPlugin.handleEvent(new OverlayEvent(OverlayEventType.Trigger, selectedPluginName)); //even handler for the selected plugin, should trigger an overlay plugin
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (input == plugins.size() + 1) { //else our last option before exit is to create a plugin
                // Create Custom Plugin
                System.out.println("Enter name for the custom plugin:");
                String pluginName = App.getNextLine(); //get plugin name from user
                OverlayInterface customPlugin = new CreatePlugin(pluginName); //create the new plugin
                //(acting as if the overlay allows the user to create teh plugin and then uploads said plugin to the registry/server)
                overlayReg.addPlugin(pluginName, customPlugin); //add the plugin to the registry
                System.out.println("Custom plugin '" + pluginName + "' added."); //debugging step
            } else if (input == plugins.size() + 2) {
                // Exit
                System.out.println("Exiting overlay.");
                break;
            } else {
                System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }
}