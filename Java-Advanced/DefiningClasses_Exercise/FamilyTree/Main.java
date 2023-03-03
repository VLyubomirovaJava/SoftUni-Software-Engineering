package DefiningClasses_Exercise.FamilyTree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
// saving the initial info, we receive, be it DOB or name.
        String information = input;
        input = scanner.nextLine();
        LinkedHashMap<String, List<String>> childrenByParents = new LinkedHashMap<>();
        List<Person> personList = new ArrayList<>();
        Set<String> inputSet = new LinkedHashSet<>();

        while (!input.equals("End")) {
            if (input.contains("-")) {
                String parentInfo = input.split(" - ")[0];
                String childInfo = input.split(" - ")[1];
                //•	"{day/month/year} – {day/month/year}"  -  parent DOB – kid DOB
                childrenByParents.putIfAbsent(parentInfo, new ArrayList<>());
                childrenByParents.get(parentInfo).add(childInfo);
                inputSet.add(parentInfo);
                inputSet.add(childInfo);
            } else {
                //•	"{FirstName} {LastName} {day/month/year}" - person's name and DOB
                String[] data = input.split("\\s+");
                String name = data[0] + " " + data[1];
                String dob = data[data.length - 1];
                Person person = new Person(name, dob);
                personList.add(person);
            }
            input = scanner.nextLine();
        }
        for (String inputInfo : inputSet) {
            Person currentPerson = getPerson(inputInfo, personList);
            for (Map.Entry<String, List<String>> entry : childrenByParents.entrySet()) {
                Person parent = getPerson(entry.getKey(), personList);

                for (String childInfo : entry.getValue()) {
                    Person child = getPerson(childInfo, personList);

                    if (currentPerson == child) {
                        currentPerson.addToParentList(parent);
                    } else if (currentPerson == parent) {
                        currentPerson.addToChildrenList(child);
                    }
                }
            }
        }
        System.out.println(getPerson(information, personList).toString());
    }

    private static Person getPerson(String information, List<Person> personList) {
        Person currentPerson = null;
        for (Person person : personList) {
            if (person.getName().equals(information) || person.getBirthday().equals(information)) {
                currentPerson = person;
            }
        }
        return currentPerson;
    }
}