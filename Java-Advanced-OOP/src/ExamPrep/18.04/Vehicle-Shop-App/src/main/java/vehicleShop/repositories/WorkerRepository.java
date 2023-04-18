package vehicleShop.repositories;

import vehicleShop.models.worker.Worker;

import java.util.*;

public class WorkerRepository implements Repository<Worker> {
private Collection<Worker> workers;

    public WorkerRepository() {
        this.workers=new ArrayList<>();

    }

    @Override
    public Collection<Worker> getWorkers() {
        return Collections.unmodifiableCollection(workers);
    }

    @Override
    public void add(Worker model) {
if (findByName(model.getName())==null){
    workers.add(model);
}
    }

    @Override
    public boolean remove(Worker model) {
        return workers.remove(model);
    }

    @Override
    public Worker findByName(String name) {
        return workers.stream()
                .filter(worker -> worker.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
