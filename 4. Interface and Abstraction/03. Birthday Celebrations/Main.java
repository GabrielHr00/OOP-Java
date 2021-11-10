import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Citizen> list = new ArrayList<>();
        List<Pet> pets = new ArrayList<>();

        String com = sc.nextLine();
        while(!com.equals("End")){
            String[] co = com.split("\\s+");
            String object = co[0];
            switch(object){
                case "Citizen":
                    list.add(new Citizen(co[1], Integer.parseInt(co[2]), co[3], co[4]));
                    break;
                case "Pet":
                    pets.add(new Pet(co[1], co[2]));
                    break;
                case "Robot":
                    break;
            }
            com = sc.nextLine();
        }

        String year = sc.nextLine();
        list.stream().forEach(e -> {
            if(e.getBirthDate().endsWith(year)){
                System.out.println(e.getBirthDate());
            }
        });

        pets.stream().forEach(e -> {
            if(e.getBirthDate().endsWith(year)){
                System.out.println(e.getBirthDate());
            }
        });
    }
}
