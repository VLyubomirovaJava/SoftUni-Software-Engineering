package Encapsulation.firstAndReserveTeam;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Team team = new Team("Black Eagles");
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");

            Person person = (new Person
                    (input[0], input[1], Integer.parseInt(input[2]), Double.parseDouble(input[3]))
            );
            team.addPlayer(person);

        }
        List<Person> firstTeam = team.getFirstTeam();
        firstTeam=firstTeam.stream()
                        .sorted(Comparator.comparing(Person::getAge))
                                .collect(Collectors.toList());
        List<Person> reserveTeam = team.getReserveTeam();
        reserveTeam=reserveTeam.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .collect(Collectors.toList());


        System.out.println("First team have " + firstTeam.size() + " players");
        System.out.println("Reserve team have " + reserveTeam.size() + " players");

    }
}

