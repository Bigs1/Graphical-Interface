package independentstudy.Plugins.overlay;

import independentstudy.Interfaces.OverlayEvent;
import independentstudy.Interfaces.OverlayInterface;
import independentstudy.Interfaces.OverlayEvent.OverlayEventType;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IngameFilter implements OverlayInterface {

    private boolean isActive;
    private List<String> filters;

    public String getName() {
        return "Ingame Filter";
    }

    public void handleEvent(OverlayEvent event) throws InterruptedException {
        if (event.type == OverlayEventType.Trigger && event.name.equals("Ingame Filter")) {
            System.out.println("Triggering Ingame Filter activation.");
            activateFilter();
        }
    }

    public IngameFilter() { //filter list
        this.isActive = false;
        this.filters = new ArrayList<>();
        filters.add("Sepia");
        filters.add("Grayscale");
        filters.add("Vintage");
    }

    public void activateFilter() {
        Random random = new Random();
        int randomNumber = random.nextInt(2); // Generates either 0 or 1

        // If the random number is 1, activate the filter and return a random filter from the list
        if (randomNumber == 1) { //activate
            isActive = true;
            int randomIndex = random.nextInt(filters.size());
            String selectedFilter = filters.get(randomIndex);
            System.out.println("Ingame filter activated: " + selectedFilter);
        } else {
            System.out.println("Ingame filter disabled."); //disable
        }
    }

    //active flag, realizing doesnt do anything for current implementation
    //will leave for future use in case needed
    public boolean isActive() { 
        return isActive;
    }
}