import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Class<?> classy = RichSoilLand.class;
		Scanner sc = new Scanner(System.in);

		String com = sc.nextLine();
		Field[] fields = classy.getDeclaredFields();

		while(!com.equals("HARVEST")){
			switch(com){
				case "protected":
					for (var i : fields) {
						if(Modifier.isProtected(i.getModifiers())){
							System.out.println(Modifier.toString(i.getModifiers()) + " " + i.getType().getSimpleName() + " " + i.getName());
						}
					}
					break;
				case "private":
					for (var i : fields) {
						if(Modifier.isPrivate(i.getModifiers())){
							System.out.println(Modifier.toString(i.getModifiers()) + " " + i.getType().getSimpleName() + " " + i.getName());
						}
					}
					break;
				case "public":
					for (var i : fields) {
						if(Modifier.isPublic(i.getModifiers())){
							System.out.println(Modifier.toString(i.getModifiers()) + " " + i.getType().getSimpleName() + " " + i.getName());
						}
					}
					break;
				case "all":
					Arrays.stream(fields).forEach(e -> System.out.println(String.format("%s %s %s", Modifier.toString(e.getModifiers()), e.getType().getSimpleName(), e.getName())));
			}

			com = sc.nextLine();
		}



	}
}
