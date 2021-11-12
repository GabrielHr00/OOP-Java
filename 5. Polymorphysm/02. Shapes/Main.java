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
        Shape sh = new Circle(4.0);
        Shape sh1 = new Rectangle(13.0, 12.0);

        System.out.println(sh.calculateArea());
        System.out.println(sh.calculatePerimeter());
        System.out.println(sh1.calculateArea());
        System.out.println(sh1.calculatePerimeter());
        
    }
}
