package workingWithAbstraction.TrafficLights;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<TrafficLight> trafficLightList = new ArrayList<>();
        String[] input = scanner.nextLine().split("\\s+");
        fillTrafficLight(trafficLightList, input);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            for (TrafficLight trafficlight : trafficLightList) {
                trafficlight.updateTrafficLight();
                System.out.print(trafficlight.signals.name() + " ");
            }
            System.out.println();
        }
    }

    private static void fillTrafficLight(List<TrafficLight> trafficLightList, String[] input) {
        for (String string : input) {
            Signals signals = Signals.parse(string);
            TrafficLight trafficLight = new TrafficLight(signals);
            trafficLightList.add(trafficLight);
        }
    }
}