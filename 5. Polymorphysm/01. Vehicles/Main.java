import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] car = sc.nextLine().split("\\s+");
        String[] truck = sc.nextLine().split("\\s+");
        Car c = new Car(Double.parseDouble(car[1]), Double.parseDouble(car[2]));
        Truck t = new Truck(Double.parseDouble(truck[1]), Double.parseDouble(truck[2]));

        int n = Integer.parseInt(sc.nextLine());

        while(n-- > 0){
            String[] com = sc.nextLine().split("\\s+");
            if(com[0].equals("Drive")){
                if(com[1].equals("Car")){
                    System.out.println(c.drive(Double.parseDouble(com[2])));
                }else if(com[1].equals("Truck")){
                    System.out.println(t.drive(Double.parseDouble(com[2])));
                }
            }
            else if(com[0].equals("Refuel")){
                if(com[1].equals("Car")){
                    c.refuel(Double.parseDouble(com[2]));
                }else if(com[1].equals("Truck")){
                    t.refuel(Double.parseDouble(com[2]));
                }
            }
        }

        System.out.printf("Car: %.2f%n", c.getKm());
        System.out.printf("Truck: %.2f", t.getKm());

    }
}
