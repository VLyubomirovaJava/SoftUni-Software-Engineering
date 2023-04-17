//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package goldDigger.repositories;

import goldDigger.models.disocverer.Discoverer;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class DiscovererRepository implements Repository<Discoverer> {
    Map<String, Discoverer> discoverers = new LinkedHashMap<>();

    public DiscovererRepository() {
    }

    public Collection<Discoverer> getCollection() {
        return Collections.unmodifiableCollection(this.discoverers.values());
    }

    public void add(Discoverer discoverer) {
        String name = discoverer.getName();
        this.discoverers.put(name, discoverer);
    }

    public boolean remove(Discoverer discoverer) {
        return this.discoverers.remove(discoverer.getName(), discoverer);
    }

    public Discoverer byName(String name) {
        return (Discoverer)this.discoverers.get(name);
    }
}
