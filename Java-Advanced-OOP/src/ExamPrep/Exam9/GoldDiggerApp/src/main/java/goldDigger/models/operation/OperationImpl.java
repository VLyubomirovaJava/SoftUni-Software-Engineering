package goldDigger.models.operation;

import goldDigger.models.disocverer.Discoverer;
import goldDigger.models.spot.Spot;

import java.util.*;

public class OperationImpl implements Operation {

    public OperationImpl() {
    }

    public void startOperation(Spot spot, Collection<Discoverer> discoverers) {
Collection<String> exhibits = spot.getExhibits();
        for (Discoverer discoverer:discoverers) {
while (discoverer.canDig() && !exhibits.isEmpty()) {
    discoverer.dig();
    String current = exhibits.iterator().next();
    discoverer.getMuseum().getExhibits().add(current);
    exhibits.remove(current);
}      }
    }
}
