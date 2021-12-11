package catHouse.entities.cat;

public class ShorthairCat extends BaseCat{
    public ShorthairCat(String name, String breed, double price) {
        super(name, breed, price);
        setKilograms(7);
    }

    // can only live in short houses

    @Override
    public void eating() {
        setKilograms(getKilograms() + 1);
    }
}
