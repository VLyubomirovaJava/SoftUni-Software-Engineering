package DefiningClasses_Exercise.PokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

//"{TrainerName} {PokemonName} {PokemonElement} {PokemonHealth}
        String input = scanner.nextLine();
        Map<String, List<Pokemon>> pokemonByTrainer = new LinkedHashMap<>();

        while (!input.equals("Tournament")) {
            String[] inputData = input.split("\\s+");
            // creating the pokemon
            Pokemon pokemon = new Pokemon(inputData[1], inputData[2], Integer.parseInt(inputData[3]));
            // adding who caught it in a map, so the collection is formed
            pokemonByTrainer.putIfAbsent(inputData[0], new ArrayList<>());
            pokemonByTrainer.get(inputData[0]).add(pokemon);

            input = scanner.nextLine();
        }
        List<Trainer> trainerList = pokemonByTrainer.entrySet()
                .stream()
                .map(t -> new Trainer(t.getKey(), t.getValue()))
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("End")) {

            for (Trainer trainer : trainerList) {
                trainer.commandExecuting(command);
            }
            command = scanner.nextLine();
        }
        // printing them in a sorted way, based off their badge count. Descending order

        trainerList.stream()
                .sorted(Comparator.comparingInt(Trainer::getBadgeCount).reversed())
                .forEach(System.out::println);
    }
}