package independentstudy.Interfaces;

public interface OverlayInterface {

    public String getName();

    public void handleEvent(OverlayEvent event) throws InterruptedException;

}
