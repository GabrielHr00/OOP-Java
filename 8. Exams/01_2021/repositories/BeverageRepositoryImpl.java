package restaurant.repositories;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.repositories.interfaces.BeverageRepository;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class BeverageRepositoryImpl implements BeverageRepository<Beverages> {
    private List<Beverages> drinks;

    public BeverageRepositoryImpl() {
        this.drinks = new LinkedList<>();
    }

    @Override
    public Beverages beverageByName(String drinkName, String drinkBrand) {
        return drinks.stream()
                .filter(e -> e.getName().equals(drinkName) && e.getBrand().equals(drinkBrand))
                .findFirst().orElse(null);
    }

    @Override
    public Collection<Beverages> getAllEntities() {
        return drinks;
    }

    @Override
    public void add(Beverages entity) {
        drinks.add(entity);
    }
}
