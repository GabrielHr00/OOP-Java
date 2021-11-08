import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String com = sc.nextLine();
        Car c = new Ferrari(com);
        System.out.println(c);
    }
}
