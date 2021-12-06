package restaurant.repositories;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.repositories.interfaces.HealthFoodRepository;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class HealthFoodRepositoryImpl implements HealthFoodRepository<HealthyFood> {
    private List<HealthyFood> food;

    public HealthFoodRepositoryImpl() {
        this.food = new LinkedList<>();
    }

    @Override
    public HealthyFood foodByName(String name) {
        return food.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst().orElse(null);
    }

    @Override
    public Collection<HealthyFood> getAllEntities() {
        return this.food;
    }

    @Override
    public void add(HealthyFood entity) {
        food.add(entity);
    }
}
