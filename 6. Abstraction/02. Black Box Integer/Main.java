import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<?> clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> cons = (Constructor<BlackBoxInt>) clazz.getDeclaredConstructor();
        cons.setAccessible(true);
        BlackBoxInt bb = cons.newInstance();

        Scanner sc = new Scanner(System.in);

        String com = sc.nextLine();
        while(!com.equals("END")){
            String[] coms = com.split("_");
            String name = coms[0];
            int value = Integer.parseInt(coms[1]);

            Method me = clazz.getDeclaredMethod(name, int.class);
            me.setAccessible(true);
            me.invoke(bb, value);
            Field f = clazz.getDeclaredField("innerValue");
            f.setAccessible(true);
            System.out.println(f.get(bb));

            com = sc.nextLine();
        }
    }
}
