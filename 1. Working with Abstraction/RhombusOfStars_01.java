import java.util.Scanner;

public class RhombusOfStars_01{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        printTop(n);
        printBottom(n);
    }
    public static void printTop(int n ){
        for (int i = 1; i < n; i++) {
            printStars(n - i, " ");
            printStars(i, "* ");
            System.out.println();
        }
    }

    public static void printBottom(int n){
        for (int i = 0; i < n; i++) {
            printStars(i, " ");
            printStars(n - i, "* ");
            System.out.println();
        }
    }
    public static void printStars(int count, String string){
        for (int j = 0; j < count; j++) {
            System.out.print(string);
        }
    }
}
