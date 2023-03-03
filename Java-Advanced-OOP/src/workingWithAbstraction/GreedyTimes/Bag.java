package workingWithAbstraction.GreedyTimes;

import java.util.*;

import static workingWithAbstraction.GreedyTimes.Type.*;

public class Bag {
    private List<Item> items;
    long capacity;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    public long getAmountPerType(Type type) {
        return items.stream()
                .filter(e -> e.getType().equals(type))
                .mapToLong(Item::getAmount)
                .sum();
    }

    public long getBagAmount() {
        return getAmountPerType(GEM)
                + getAmountPerType(CASH)
                + getAmountPerType(GOLD);
    }

    public void addToBag(Item item) {
        long currentAmount = item.getAmount();
        if (currentAmount + getBagAmount() <= capacity) {
            Type type = item.getType();
            switch (type.toString()) {
                case "GOLD":
                    if (conditionsAreMet(getAmountPerType(GOLD) + currentAmount,
                            getAmountPerType(GEM),
                            getAmountPerType(CASH))) {
                        items.add(item);
                    }
                    break;
                case "GEM":
                    if (conditionsAreMet(getAmountPerType(GOLD),
                            getAmountPerType(GEM) + currentAmount,
                            getAmountPerType(CASH))) {
                        items.add(item);
                    }
                    break;
                case "CASH":
                    if (conditionsAreMet(getAmountPerType(GOLD),
                            getAmountPerType(GEM),
                            getAmountPerType(CASH) + currentAmount)) {
                        items.add(item);
                    }
                    break;

            }
        }
    }

    private boolean conditionsAreMet(long goldAmount, long gemAmount, long cashAmount) {
        return (goldAmount >= gemAmount && gemAmount >= cashAmount);
    }

    public void printByGroup(Type type) {
        Map<String, Long> valueByName = new TreeMap<>();
        items.stream().filter(e -> e.getType().equals(type))
                .forEach(e -> {
                            String name = e.getItemName();
                            valueByName.putIfAbsent(name, 0L);
                            valueByName.put(name, valueByName.get(name) + e.getAmount());
                        }
                );
        Map<String, Long> sortByAmount = new TreeMap<>(Collections.reverseOrder());
        valueByName.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(e -> sortByAmount.put(e.getKey(), e.getValue()));
        sortByAmount.forEach((key, value) -> System.out.printf("##%s - %s%n", key, value));
    }

    public void printContents() {
        if (getAmountPerType(GOLD) > 0) {
            System.out.printf("<Gold> $%s%n", getAmountPerType(GOLD));
            printByGroup(GOLD);
        }
        if (getAmountPerType(GEM) > 0) {
            System.out.printf("<Gem> $%s%n", getAmountPerType(GEM));
            printByGroup(GEM);
        }
        if (getAmountPerType(CASH) > 0) {
            System.out.printf("<Cash> $%s%n", getAmountPerType(CASH));
            printByGroup(CASH);

        }
    }


}
