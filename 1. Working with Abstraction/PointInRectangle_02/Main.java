import org.w3c.dom.css.Rect;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] coms = sc.nextLine().split("\\s+");
        int n = Integer.parseInt(sc.nextLine());
        Rectangle r = new Rectangle(coms);

        while(n-- > 0){
            String[] coor = sc.nextLine().split("\\s+");

            System.out.println(r.contains(coor));
        }

    }
}
