package christmasPastryShop.repositories.interfaces;

import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.*;

public class DelicacyRepositoryImpl<D> implements DelicacyRepository<Delicacy> {
private Collection<Delicacy> delicacies;

    public DelicacyRepositoryImpl() {
        this.delicacies = new ArrayList<>();
    }

    @Override
    public Delicacy getByName(String name) {
      return   this.delicacies.stream().filter(f->name.equals(f.getName())).findFirst().orElse(null);
    }

    @Override
    public Collection<Delicacy> getAll() {
        return Collections.unmodifiableCollection(this.delicacies);
    }

    @Override
    public void add(Delicacy delicacy) {
this.delicacies.add(delicacy);
    }
}
