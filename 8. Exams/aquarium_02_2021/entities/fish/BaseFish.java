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
        if(species == null || species.trim().isEmpty()){
            throw new NullPointerException("Fish species cannot be null or empty.");
        }
        this.species = species;
    }

    private void setPrice(double price) {
        if(price <= 0){
            throw new IllegalArgumentException("Fish price cannot be below or equal to 0.");
        }
        this.price = price;
    }

    @Override
    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new NullPointerException("Fish name cannot be null or empty.");
        }
        this.name = name;
    }

    @Override
    public void eat() {
        this.setSize(this.size + 5);
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
