import org.w3c.dom.css.Rect;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] com = sc.nextLine().split("\\s+");
        PriceCalculator calc = new PriceCalculator(Double.parseDouble(com[0]), Integer.parseInt(com[1]), Season.valueOf(com[2]), Discount.valueOf(com[3]));

        double price = calc.getPricePerDay() * (calc.getSeason().ordinal() + 1);
        price = price * calc.getDays();
        price -= price * calc.getDiscount().getPerc();
        System.out.printf("%.2f", price);
    }
}
