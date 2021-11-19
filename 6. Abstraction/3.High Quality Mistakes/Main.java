import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Arrays.stream(Reflection.class.getDeclaredFields())
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(f -> System.out.println(
                        f.getName() + " must be private!"));


        Method[] declared = Arrays.stream(Reflection.class.getDeclaredMethods()).filter(m -> !m.getName().equals("toString")).toArray(Method[]::new);

        Arrays.stream(declared)
                .filter(m -> m.getReturnType() != void.class)
                .filter(m -> !Modifier.isPublic(m.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.println(
                        m.getName() + " have to be public!"));

        Arrays.stream(declared)
                .filter(m -> m.getReturnType() == void.class)
                .filter(m -> !Modifier.isPrivate(m.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.println(
                        m.getName() + " have to be private!"));
    }
}