public class Seat extends CarImpl implements Sellable{
    private Double price;

    public Seat(String model, String color, Integer hp, String country, Double price) {
        super(model, color, hp, country);
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return null;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() + super.getModel() + " sells for " + price;
    }
}
