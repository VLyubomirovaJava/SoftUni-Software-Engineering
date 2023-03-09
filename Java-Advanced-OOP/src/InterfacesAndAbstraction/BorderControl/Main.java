package InterfacesAndAbstraction.BorderControl;

import InterfacesAndAbstraction.BorderControl.Citizen;
import InterfacesAndAbstraction.BorderControl.Identifiable;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] idData = scanner.nextLine().split("\\s+");
        List<Identifiable> identifiableList = new ArrayList<>();
        while (!idData[0].equals("End")) {
            Identifiable identifiable;
            if (idData.length == 3) {

                String name = idData[0];
                int age = Integer.parseInt(idData[1]);
                String id = idData[2];
                identifiable = new Citizen(name, age, id);
            } else {
                String model = idData[0];
                String id = idData[1];
                identifiable = new Robot(model, id);
            }
            identifiableList.add(identifiable);
            idData = scanner.nextLine().split("\\s+");
        }
        String lastIDDigits = scanner.nextLine();
        identifiableList.stream().filter(i -> i.getId().endsWith(lastIDDigits))
                .forEach((Identifiable i) -> System.out.println(i.getId()));
    }
}