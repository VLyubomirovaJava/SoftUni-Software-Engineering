package DefiningClasses_Exercise.Google;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Map<String, Person> peopleInfo = new HashMap<>();
        while (!command.equals("End")) {
            String[] commandData = command.split("\\s+");
            String personName = commandData[0];
            if (!peopleInfo.containsKey(personName)) {
                peopleInfo.put(personName, new Person());
            }
            String typeCommand = commandData[1];
            switch (typeCommand) {
                case "company":
                    String companyName = commandData[2];
                    String department = commandData[3];
                    Double salary = Double.parseDouble(commandData[4]);
                    // filling in the info for the company and linking it to the person from the map
                    Company company = new Company(companyName, department, salary);
                    peopleInfo.get(personName).setCompany(company);
                    break;
                case "car":
                    String carModel = commandData[2];
                    int speed = Integer.parseInt(commandData[3]);
                    Car car = new Car(carModel, speed);
                    peopleInfo.get(personName).setCar(car);
                    break;
                case "pokemon":
                    String name = commandData[2];
                    String type = commandData[3];
                    Pokemon pokemon = new Pokemon(name, type);
                    peopleInfo.get(personName).getPokemonList().add(pokemon);
                    break;
                case "parents":
                    String nameOfParent = commandData[2];
                    String birthday = commandData[3];
                    Parents parents = new Parents(nameOfParent, birthday);
                    peopleInfo.get(personName).getParentsList().add(parents);
                    break;
                case "children":
                    String nameOfkid = commandData[2];
                    String birthdayOfKid = commandData[3];
                    Children children = new Children(nameOfkid, birthdayOfKid);
                    peopleInfo.get(personName).getChildrenList().add(children);
                    break;
            }


            command = scanner.nextLine();
        }
        String searchedPerson = scanner.nextLine();
        System.out.println(searchedPerson);

        Person personalInfo = peopleInfo.get(searchedPerson);
        System.out.println(personalInfo);
    }
}