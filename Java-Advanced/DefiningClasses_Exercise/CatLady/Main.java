package DefiningClasses_Exercise.CatLady;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String catInput = scanner.nextLine();
        Map<String, Cat> catCollection = new HashMap<>();
        while (!catInput.equals("End")) {
            String[] data = catInput.split("\\s+");
            String breed = data[0];
            Cat cat = null;
            switch (breed) {
                case "Siamese":
                    cat = new Siamese(data[1], Double.parseDouble(data[2]));
                    break;
                case "Cymric":
                    cat = new Cymric(data[1], Double.parseDouble(data[2]));
                    break;
                case "StreetExtraordinaire":
                    cat = new StreetExtraordinaire(data[1], Double.parseDouble(data[2]));
                    break;
                default:
                    throw new RuntimeException("Unknown breed!");
            }
            catCollection.put(data[1], cat);
            catInput = scanner.nextLine();
        }
        String name = scanner.nextLine();
        if (catCollection.containsKey(name)) {
            System.out.println(catCollection.get(name).toString());
        }
    }
}

