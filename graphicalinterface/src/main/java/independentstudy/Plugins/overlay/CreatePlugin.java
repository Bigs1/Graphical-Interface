package independentstudy.Plugins.overlay;

import independentstudy.Interfaces.OverlayEvent;
import independentstudy.Interfaces.OverlayInterface;

public class CreatePlugin implements OverlayInterface {

    private String name;

    //this should just create a plugin and get the name and be able to "trigger/activate" it
    public CreatePlugin(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void handleEvent(OverlayEvent event) throws InterruptedException {
        System.out.println("Custom plugin '" + name + "' triggered.");
    }
}