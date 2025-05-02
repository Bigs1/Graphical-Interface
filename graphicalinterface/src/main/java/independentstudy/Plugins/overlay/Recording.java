package independentstudy.Plugins.overlay;

import independentstudy.Interfaces.OverlayEvent;
import independentstudy.Interfaces.OverlayEvent.OverlayEventType;
import independentstudy.Interfaces.OverlayInterface;

public class Recording implements OverlayInterface {

    private boolean isRecording;

    public Recording() { //recording flag, set false by default
        this.isRecording = false;
    }

    public void startRecording() { //start the recording
        if (!isRecording) {
            isRecording = true;
            System.out.println("Recording...");
        }
    }

    public void stopRecording() { //stop the recording
        if (isRecording) {
            isRecording = false;
            System.out.println("Recording stopped.");
        }
    }

    public void toggleRecording() { //toggle the recording on or off
        if (isRecording) {
            stopRecording();
        } else {
            startRecording();
        }
    }

    public String getName() { //name of the plugin
        return "Recording";
    }

    public void handleEvent(OverlayEvent event) throws InterruptedException { //execute the recording plugin process
        //need to do more research into triggers but this is bare minimum implementation
        //if event type is a trigger (need to do more research on this specifically), and the event's name is "Recording", execute the recording process
        if (event.type == OverlayEventType.Trigger && event.name.equals("Recording")) 
            toggleRecording();
        Thread.sleep(5000); // Simulate recording process
        toggleRecording();
    }
}