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
        List<Rebel> pets = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());


        while(n-- > 0){
            String com = sc.nextLine();
            String[] co = com.split("\\s+");

            if(co.length == 3){
                pets.add(new Rebel(co[0], Integer.parseInt(co[1]), co[2]));
            }else{
                list.add(new Citizen(co[0], Integer.parseInt(co[1]), co[2], co[3]));
            }
        }

        String com = sc.nextLine();

        while (!com.equals("End")){
            for (Citizen e : list) {
                if(e.getName().equals(com)){
                    e.buyFood();
                }
            }
            for (Rebel e : pets) {
                if(e.getName().equals(com)){
                    e.buyFood();
                }
            }
            com = sc.nextLine();
        }

        int sum = 0;
        for (Citizen e : list) {
            sum += e.getFood();
        }
        for (Rebel e : pets) {
            sum += e.getFood();
        }

        System.out.println(sum);

    }
}
