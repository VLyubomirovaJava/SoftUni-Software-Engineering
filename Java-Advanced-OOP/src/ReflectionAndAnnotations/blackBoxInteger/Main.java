package blackBoxInteger;
import java.lang.reflect.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> declaredConstructor = clazz.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        BlackBoxInt blackBoxInt = declaredConstructor.newInstance();
        Field hiddenValue = clazz.getDeclaredField("innerValue");
        hiddenValue.setAccessible(true);

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            // Read the next  input and value
            String[] inputData = input.split("_");
            String command = inputData[0];
            int value = Integer.parseInt(inputData[1]);
            Method method = clazz.getDeclaredMethod(command , int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt, value);
            System.out.println(hiddenValue.get(blackBoxInt));
            input = scanner.nextLine();
        }
    }
}