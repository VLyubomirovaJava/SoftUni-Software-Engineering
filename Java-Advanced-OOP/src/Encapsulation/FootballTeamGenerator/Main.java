package Encapsulation.FootballTeamGenerator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Team> teamMap = new LinkedHashMap<>();
        while (!input.equals("END")) {
            String[] commandInput = input.split(";");
            String command = commandInput[0];
            String teamName = commandInput[1];
            switch (command) {
                case "Encapsulation.FootballTeamGenerator.Team":
                    try {
                        Team team = new Team(teamName);
                        teamMap.put(teamName, team);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Add":
                    if (teamMap.containsKey(teamName)) {
                        String name = commandInput[2];
                        int Endurance = Integer.parseInt(commandInput[3]);
                        int Sprint = Integer.parseInt(commandInput[4]);
                        int Dribble = Integer.parseInt(commandInput[5]);
                        int Passing = Integer.parseInt(commandInput[6]);
                        int Shooting = Integer.parseInt(commandInput[7]);
                        try {
                            Player player = new Player(name, Endurance, Sprint, Dribble, Passing, Shooting);
                            teamMap.get(teamName).addPlayer(player);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        printMessage(teamName);
                    }
                    break;
                case "Remove":
                    String name = commandInput[2];
                    if (teamMap.containsKey(teamName)) {
                        try {
                            teamMap.get(teamName).removePlayer(name);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        printMessage(teamName);

                    }
                    break;
                case "Rating":
                    if (teamMap.containsKey(teamName)) {
                        System.out.printf("%s - %d%n", teamName, Math.round(teamMap.get(teamName).getRating()));

                    } else {
                        printMessage(teamName);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + command);
            }
            input = scanner.nextLine();
        }
    }

    private static void printMessage(String teamName) {
        System.out.println("Encapsulation.FootballTeamGenerator.Team " + teamName + " does not exist.");
    }
}
