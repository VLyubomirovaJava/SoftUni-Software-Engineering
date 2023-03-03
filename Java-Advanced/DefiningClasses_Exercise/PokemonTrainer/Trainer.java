package DefiningClasses_Exercise.PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int badgeCount;
    private List<Pokemon> pokemonCollection = new ArrayList<>();

    public Trainer(String name, List<Pokemon> pokemonCollection) {
        this.name = name;
        this.badgeCount = 0;
        this.pokemonCollection = pokemonCollection;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBadgeCount() {
        return badgeCount;
    }

    public void setBadgeCount(int badgeCount) {
        this.badgeCount = badgeCount;
    }

    public List<Pokemon> getPokemonCollection() {
        return pokemonCollection;
    }

    public void setPokemonCollection(List<Pokemon> pokemonCollection) {
        this.pokemonCollection = pokemonCollection;
    }

    public void commandExecuting(String command) {
        if (isExisting(command)) {

            badgeCount += 1;
        } else {
            for (int i = 0; i < pokemonCollection.size(); i++) {
                pokemonCollection.get(i).setHealth(pokemonCollection.get(i).getHealth() - 10);
                if (pokemonCollection.get(i).getHealth() <= 0) {
                    pokemonCollection.remove(i);
                    i--;
                }
            }
        }
    }

    // checking if we have the pokemon caught in the collection already.
    private boolean isExisting(String command) {
        for (Pokemon pokemon : pokemonCollection) {
            if (pokemon.getElement().equals(command)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", name, badgeCount, pokemonCollection.size());
        //     returns "{TrainerName} {Badges} {NumberOfPokemon}".
    }
}

