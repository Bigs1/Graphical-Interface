package independentstudy.Registries;

import independentstudy.Interfaces.OverlayInterface;
import independentstudy.Plugins.overlay.IngameFilter;
import independentstudy.Plugins.overlay.Recording;
import independentstudy.Plugins.overlay.ScreenShot;

import java.util.HashMap;
import java.util.Map;

public class OverlayReg {

    private Map<String, OverlayInterface> plugins;

    public OverlayReg() {
        plugins = new HashMap<>();
        initializePlugins(); //initalize plugins/add premade plugins ot the registry
    }

    // Method to initialize plugins
    private void initializePlugins() {
        // Add premade plugins to the HashMap with unique keys
        plugins.put("Ingame Filter", new IngameFilter());
        plugins.put("Recording", new Recording());
        plugins.put("ScreenShot", new ScreenShot());
        // Add more plugins if needed
    }

    // Method to get a plugin by name
    public OverlayInterface getPlugin(String pluginName) {
        return plugins.get(pluginName);
    }

    // Method to get all plugins
    public Map<String, OverlayInterface> getAllPlugins() {
        return plugins;
    }

    // Method to add a new plugin
    public void addPlugin(String pluginName, OverlayInterface customOverlayPlugin) {
        plugins.put(pluginName, customOverlayPlugin);
    }

    // Method to remove a plugin
    public void removePlugin(String pluginName) {
        plugins.remove(pluginName); //not needed for this project rn but put it here in case i need it later
    }
}