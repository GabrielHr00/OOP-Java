package spaceStation.repositories;

import spaceStation.models.astronauts.Astronaut;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class AstronautRepository implements Repository<Astronaut>{
    private Collection<Astronaut> astronauts;

    public AstronautRepository(Collection<Astronaut> astronauts) {
        this.astronauts = new ArrayList<>();
    }

    @Override
    public Collection<Astronaut> getModels() {
        return Collections.unmodifiableCollection(astronauts);
    }

    @Override
    public void add(Astronaut model) {
        astronauts.add(model);
    }

    @Override
    public boolean remove(Astronaut model) {
        return astronauts.remove(model);
    }

    @Override
    public Astronaut findByName(String name) {
        return this.astronauts.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }
}