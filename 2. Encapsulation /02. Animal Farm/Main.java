import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int age = Integer.parseInt(sc.nextLine());

        try{
            Chicken chi = new Chicken(name, age);
            System.out.println(chi);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
