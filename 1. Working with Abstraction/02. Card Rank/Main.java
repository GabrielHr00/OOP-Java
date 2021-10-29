package softuni;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Card Ranks:");
        for (CardRank s : CardRank.values()){
            System.out.printf("Ordinal value: %d; Name value: %s%n", s.ordinal(), s.name());
        }
    }
}
