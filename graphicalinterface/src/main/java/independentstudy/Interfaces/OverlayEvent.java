package independentstudy.Interfaces;

public class OverlayEvent {

    public OverlayEventType type;
    public String name;

    public OverlayEvent(OverlayEventType type, String name) {
        this.type = type;
        this.name = name;
    }

    public static enum OverlayEventType {
        Trigger,
    }
}
