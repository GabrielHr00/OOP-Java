public class Audi extends CarImpl implements Rentable{
    private Integer minRentDay;
    private Double pricePerDay;

    public Audi(String model, String color, Integer hp, String country, Integer minRentDay, Double pricePerDay) {
        super(model, color, hp, country);
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() + "Minimum rental period of " + getMinRentDay() + " days. Price per day " + pricePerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return this.minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return this.pricePerDay;
    }
}
