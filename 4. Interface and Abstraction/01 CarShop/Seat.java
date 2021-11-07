public class Seat implements Car{
    private final String model;
    private final String color;
    private final Integer horsePower;
    private final String country;

    public Seat(String model, String color, Integer hp, String country) {
        this.model = model;
        this.color = color;
        this.horsePower = hp;
        this.country = country;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsePower;
    }

    @Override
    public String countryProduced() {
        return this.country;
    }

    @Override
    public String toString() {
        return "This is " + getModel() + " produced in " + countryProduced() + " and have " + Car.TIRES + " tires";
    }
}
