package task.sort;

import task.Person;
import task.Team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.nextLine());

        Team t = new Team("Black Eagles");
        while(n-- > 0){
            String[] input = sc.nextLine().split("\\s+");

            String first = input[0];
            String last = input[1];
            int age = Integer.parseInt(input[2]);
            double salar = Double.parseDouble(input[3]);
            Person p = new Person(first, last, age, salar);
            t.addPlayer(p);
        }

        System.out.println("First team have " + t.getFirstTeam().size() + "players");
        System.out.println("Reserve team have " + t.getReserveTeam().size() + "players");
//        List<Person> people = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            String[] input = reader.readLine().split(" ");
//            try{
//                people.add(new Person(input[0], input[1], Integer.parseInt(input[2]), Double.parseDouble(input[3])));
//            }catch(IllegalArgumentException e){
//                System.out.println(e.getMessage());
//            }
//        }
//        double bonus = Double.parseDouble(reader.readLine());
//        for (Person person : people) {
//            try{
//                person.increaseSalary(bonus);
//                DecimalFormat form = new DecimalFormat("#.0####");
//                System.out.printf("%s %s gets %s leva%n", person.getFirstName(), person.getLastName(), form.format(person.getSalary()));
//            }catch(IllegalArgumentException e){
//                System.out.println(e.getMessage());
//            }
//        }
    }
}
