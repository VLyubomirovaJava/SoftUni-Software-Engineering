package christmasPastryShop.repositories.interfaces;

import christmasPastryShop.entities.cocktails.interfaces.Cocktail;

import java.util.*;

public class CocktailRepositoryImpl<C> implements CocktailRepository<Cocktail> {
    private Collection<Cocktail> cocktails;

    public CocktailRepositoryImpl() {
        this.cocktails=new ArrayList<>();
    }

    @Override
    public Cocktail getByName(String name) {
        return   this.cocktails.stream().filter(c->name.equals(c.getName())).findFirst().orElse(null);
    }

    @Override
    public Collection<Cocktail> getAll() {
        return Collections.unmodifiableCollection(this.cocktails);
    }

    @Override
    public void add(Cocktail cocktail) {
        this.cocktails.add(cocktail);

    }
}
