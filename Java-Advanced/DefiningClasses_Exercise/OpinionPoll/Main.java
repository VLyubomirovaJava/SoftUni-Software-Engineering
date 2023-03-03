package DefiningClasses_Exercise.OpinionPoll;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Person> peopleList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] personalData = scanner.nextLine().split("\\s+");
            String name = personalData[0];
            int age = Integer.parseInt(personalData[1]);
            Person person = new Person(name, age);
            peopleList.add(person);
        }

        //then prints all people whose age is more than 30 years,
        // sorted in alphabetical order.
        peopleList.stream()
                .filter(person -> person.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);

    }
}