import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String com = sc.nextLine();
        List<Identifiable> list = new ArrayList<>();

        while(!com.equals("End")){
            String[] comm = com.split("\\s+");

            if(comm.length == 2){
                list.add(new Robot(comm[0], comm[1]));
            }
            else{
                list.add(new Citizen(comm[0], Integer.parseInt(comm[1]), comm[2]));
            }
            com = sc.nextLine();
        }

        String fake = sc.nextLine();

        System.out.println(list.stream()
                .map(Identifiable::getId)
                .filter(e -> e.endsWith(fake))
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
