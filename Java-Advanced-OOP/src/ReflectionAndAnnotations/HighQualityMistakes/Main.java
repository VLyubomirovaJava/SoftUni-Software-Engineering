package ReflectionAndAnnotations.GettersAndSetters.HighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Class<Reflection> clazz = Reflection.class;
        Method[] methods = clazz.getDeclaredMethods();
        Field[] fields = clazz.getDeclaredFields();
        Arrays.stream(fields)
                .filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(field ->
                        System.out.printf("%s must be private!%n", field.getName()));

        Method[] getters = Arrays.stream(methods)
                .filter(method -> method.getName().startsWith("get") &&
                        !Modifier.isPublic(method.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);
        Arrays.stream(getters).forEach(method ->
                System.out.printf("%s have to be public!%n", method.getName()));

        Method[] setters = Arrays.stream(methods)
                .filter(method -> method.getName().startsWith("set") &&
                        !Modifier.isPrivate(method.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);
        Arrays.stream(setters).forEach(method ->
                System.out.printf("%s have to be private!%n", method.getName()));
    }
}