import java.text.DecimalFormat;

public abstract class Vehicle {
    private double quantity;
    private double comsumption;

    public Vehicle(double km, double fuel) {
        this.quantity = km;
        setFuel(fuel);
    }

    public double getKm() {
        return quantity;
    }

    public void setKm(double km) {
        this.quantity = km;
    }

    public double getFuel() {
        return comsumption;
    }

    public void setFuel(double fuel) {
        this.comsumption = fuel;
    }

    public String drive(double km){
            double needed = km * getFuel();
            if(needed > getKm()){
                return getClass().getSimpleName() + " needs refueling";
            }
            setKm(getKm() - needed);
            DecimalFormat format = new DecimalFormat("##.##");
            return String.format(getClass().getSimpleName() + " travelled %s km", format.format(km));

    }

    public void refuel(double liters){
        this.quantity += liters;
    }
}
