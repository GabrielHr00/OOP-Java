package spaceStation.repositories;

import spaceStation.models.planets.Planet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class PlanetRepository implements Repository<Planet>{
    private Collection<Planet> planets;

    public PlanetRepository() {
        this.planets = new ArrayList<>();
    }

    @Override
    public Collection<Planet> getModels() {
        return Collections.unmodifiableCollection(this.planets);
    }

    @Override
    public void add(Planet model) {
        planets.add(model);
    }

    @Override
    public boolean remove(Planet model) {
        return planets.remove(model);
    }

    @Override
    public Planet findByName(String name) {
        return this.planets.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }
}
