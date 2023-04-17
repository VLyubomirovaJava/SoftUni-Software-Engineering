package goldDigger.repositories;

import goldDigger.models.disocverer.Discoverer;

import java.util.Collection;

public interface Repository<T> {
    Collection<T> getCollection();

    void add(T entity);

    void add(Discoverer discoverer);

    boolean remove(T entity);

    boolean remove(Discoverer discoverer);

    T byName(String name);
}
