package goldDigger.core;

import goldDigger.models.disocverer.Anthropologist;
import goldDigger.models.disocverer.Archaeologist;
import goldDigger.models.disocverer.Discoverer;
import goldDigger.models.disocverer.Geologist;
import goldDigger.models.operation.Operation;
import goldDigger.models.operation.OperationImpl;
import goldDigger.models.spot.Spot;
import goldDigger.models.spot.SpotImpl;
import goldDigger.repositories.DiscovererRepository;
import goldDigger.repositories.SpotRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static goldDigger.common.ConstantMessages.*;
import static goldDigger.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private DiscovererRepository discoverers = new DiscovererRepository();
    private SpotRepository spots = new SpotRepository();
    private int spotCount;

    public ControllerImpl() {

    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {
        Discoverer discoverer;
        if (kind.equals("Anthropologist")) {
            discoverer = new Anthropologist(discovererName);
        } else if (kind.equals("Archaeologist")) {
            discoverer = new Archaeologist(discovererName);
        } else if (kind.equals("Geologist")) {
            discoverer = new Geologist(discovererName);
        } else {
            throw new IllegalArgumentException(DISCOVERER_INVALID_KIND);
        }
        this.discoverers.add(discoverer);
        return String.format(String.format(DISCOVERER_ADDED, kind, discovererName));
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {
        Spot spot = new SpotImpl(spotName);
        String[] var4 = exhibits;
        int var5 = exhibits.length;
        for (int var6 = 0; var6 < var5; var6++) {
            String exhibit = var4[var6];
            spot.getExhibits().add(exhibit);
        }
        this.spots.add(spot);
        return String.format(String.format(SPOT_ADDED, spotName));
    }

    @Override
    public String excludeDiscoverer(String discovererName) {
        if (this.discoverers.byName(discovererName) == null) {
            throw new IllegalArgumentException(String.format(DISCOVERER_DOES_NOT_EXIST, discovererName));
        }
        this.discoverers.remove(this.discoverers.byName(discovererName));

        return String.format(String.format(DISCOVERER_EXCLUDE, discovererName));
    }

    @Override
    public String inspectSpot(String spotName) {
        List<Discoverer> discovererList = new ArrayList<>(this.discoverers.getCollection());
        List<Discoverer> availableOnes = discovererList.stream()
                .filter(discoverer -> discoverer.getEnergy() > 45.0)
                .collect(Collectors.toList());
        if (availableOnes.isEmpty()) {
            throw new IllegalArgumentException(SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        } else {
            Operation operation = new OperationImpl();
            operation.startOperation(this.spots.byName(spotName), availableOnes);
            long count = availableOnes.stream().filter(discoverer -> discoverer.getEnergy() == 0).count();
            ++spotCount;
            return String.format(INSPECT_SPOT, spotName, count);
        }
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d spots were inspected.", this.spotCount));
        sb.append(System.lineSeparator());
        sb.append("Information for the discoverers:").append(System.lineSeparator());
        List<Discoverer> discovererList = new ArrayList<>(this.discoverers.getCollection());
        Iterator var3 = discovererList.iterator();

        while(var3.hasNext()) {
            Discoverer discoverer = (Discoverer)var3.next();
            sb.append(String.format("Name: %s", discoverer.getName())).append(System.lineSeparator());
            sb.append(String.format("Energy: %.0f", discoverer.getEnergy())).append(System.lineSeparator());
            String museumReport = discoverer.getMuseum().getExhibits().isEmpty() ? "None" : (String)discoverer.getMuseum().getExhibits().stream().collect(Collectors.joining(", "));
            sb.append(String.format("Museum exhibits: %s", museumReport)).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
