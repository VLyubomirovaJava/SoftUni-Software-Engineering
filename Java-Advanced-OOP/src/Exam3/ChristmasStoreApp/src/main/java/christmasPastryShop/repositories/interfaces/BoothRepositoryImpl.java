package christmasPastryShop.repositories.interfaces;

import christmasPastryShop.entities.booths.interfaces.Booth;

import java.util.*;

public class BoothRepositoryImpl<B> implements  BoothRepository<Booth> {
    private Collection<Booth> booths;

    public BoothRepositoryImpl() {
        this.booths=new ArrayList<>();
    }
    @Override
    public Booth getByNumber(int number) {
Booth booth  =booths.stream().filter(b->b.getBoothNumber()==number).findFirst().orElse(null);
   return booth;
    }

    @Override
    public Collection<Booth> getAll() {
        return Collections.unmodifiableCollection(this.booths);
    }

    @Override
    public void add(Booth booth) {
        this.booths.add(booth);

    }
}
