import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
int n =Integer.parseInt (scanner.nextLine());
Map<String,Buyer> buyerPerName =new HashMap<>();
Buyer buyer;
while (n -->0) {
    String[] inputData = scanner.nextLine().split("\\s+");
    String name = inputData[0];
    int age = Integer.parseInt(inputData[1]);
    if (inputData.length == 3) {
        String group = inputData[2];
        buyer = new Rebel(name, age, group);
    } else {
        String id = inputData[2];
        String birthDate = inputData[3];
        buyer = new Citizen(name, age, id, birthDate);
    }

buyerPerName.put(name,buyer);

        }
        String input = scanner.nextLine();
while (!input.equals("End")){
    if (buyerPerName.containsKey(input)){
        buyerPerName.get(input).buyFood();
    }
    input= scanner.nextLine();
}
int foodSum = buyerPerName.values().stream().mapToInt(Buyer::getFood).sum();
        System.out.println(foodSum);
    }
}

