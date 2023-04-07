package football.entities.field;

import football.entities.player.Player;
import football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static football.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static football.common.ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY;

public abstract class BaseField implements Field {
    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Player> players;

    public BaseField(String name, int capacity) {
        this.name=name;
        this.capacity=capacity;
        this.players = new ArrayList<>();
        this.supplements = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(FIELD_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int sumEnergy() {
        int energySum = 0;
        for (Supplement supplement : supplements) {
            energySum += supplement.getEnergy();
        }
        return energySum;
    }

    @Override
    public void addPlayer(Player player) {
        if (this.capacity <= player.getKg()) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
        this.players.add(player);
    }

    public void removePlayer(Player player){
        this.players.remove(player);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);
    }

    @Override
    public void drag() {
        for (Player player : this.players) {
            player.stimulation();
        }
    }
    @Override
        public String getInfo(){ return toString();
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder()
            .append(String.format("%s (%s):",this.name,this.getClass().getSimpleName()))
            .append(System.lineSeparator())
            .append("Player: ");
     if (this.players.isEmpty()){
         sb.append("none");
     } else {
         sb.append(this.players.stream().map(Player::getName).collect(Collectors.joining(" ")));

     }
     sb.append(System.lineSeparator())
             .append("Supplement: ")
             .append(this.supplements.size())
             .append(System.lineSeparator())
             .append("Energy: ")
             .append(this.sumEnergy());
     return sb.toString().trim();
        }

    @Override

    public Collection<Supplement> getSupplements() {
        return supplements;
    }

    @Override
    public Collection<Player> getPlayers() {
        return players;
    }

}

