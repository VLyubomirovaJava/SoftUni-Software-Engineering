package christmasPastryShop.repositories.interfaces;

import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

public interface DelicacyRepository<T> extends Repository<T> {
    T getByName(String name);

}
