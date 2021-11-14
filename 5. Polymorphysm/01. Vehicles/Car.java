import java.text.DecimalFormat;

public class Car extends Vehicle{

    public Car(double quantity, double consumption) {
        super(quantity, consumption);
    }

    @Override
    public void setFuel(double fuel) {
        super.setFuel(fuel + 0.9);
    }

}
