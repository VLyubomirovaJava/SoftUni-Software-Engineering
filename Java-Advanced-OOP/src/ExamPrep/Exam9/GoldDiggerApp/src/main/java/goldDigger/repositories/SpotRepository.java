//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package goldDigger.repositories;

import goldDigger.models.disocverer.Discoverer;
import goldDigger.models.spot.Spot;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public  class SpotRepository implements Repository<Spot> {
 private    Map<String, Spot> spots = new LinkedHashMap<>();

    public SpotRepository() {
        this.spots=new LinkedHashMap<>();
    }

    public Collection<Spot> getCollection() {
        return Collections.unmodifiableCollection(this.spots.values());
    }

    public void add(Spot spot) {
        String name = spot.getName();
        this.spots.put(name, spot);
    }

    @Override
    public void add(Discoverer discoverer) {

    }

    public boolean remove(Spot spot) {
        return this.spots.remove(spot.getName(), spot);
    }

    @Override
    public boolean remove(Discoverer discoverer) {
        return false;
    }

    public Spot byName(String name) {
        return this.spots.get(name);
    }
}
