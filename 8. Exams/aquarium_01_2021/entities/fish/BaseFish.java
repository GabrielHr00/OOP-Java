package aquarium.entities.fish;

public abstract class BaseFish implements Fish{
    private String name;
    private String species;
    private int size;
    private double price;

    protected BaseFish(String name, String species, double price) {
        this.name = name;
        this.setSpecies(species);
        this.setPrice(price);
    }

    protected void setSize(int size) {
        this.size = size;
    }

    private void setSpecies(String species) {
        this.species = species;
    }

    private void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public void eat() {

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
