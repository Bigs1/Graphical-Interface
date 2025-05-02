package independentstudy.Plugins.overlay;

import independentstudy.Interfaces.OverlayEvent;
import independentstudy.Interfaces.OverlayEvent.OverlayEventType;
import independentstudy.Interfaces.OverlayInterface;

public class ScreenShot implements OverlayInterface {

    private int i = 0;
    private String screenshot;

    public ScreenShot() { //screenshot default value
        this.screenshot = "";
    }

    public String takePic() { //take a picture incrementing its number each time
        screenshot = "picture" + i;
        i++;
        return screenshot;
    }

    public String getName() { //name of plugin
        return "ScreenShot";
    }

    public void handleEvent(OverlayEvent event) throws InterruptedException { //execute screenshot process when called
        //if event type is a trigger (need to do more research on this specifically), and the event's name is "ScreenShot", execute the recording process
        if (event.type == OverlayEventType.Trigger && event.name.equals("ScreenShot")) {
            String pictureTaken = takePic(); // Simulate taking a picture
            System.out.println(pictureTaken);
        }
    }

}