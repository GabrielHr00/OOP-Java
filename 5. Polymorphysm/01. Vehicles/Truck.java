import java.text.DecimalFormat;

public class Truck extends Vehicle{
    public Truck(double km, double fuel) {
        super(km, fuel);
    }

    @Override
    public void setFuel(double fuel) {
        super.setFuel(fuel + 1.6);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(0.95*liters);
    }
}
