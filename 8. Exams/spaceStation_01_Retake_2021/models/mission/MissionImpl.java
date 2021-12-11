package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.Collection;

public class MissionImpl implements Mission{
    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        Collection<String> items = planet.getItems();
        for (var a : astronauts) {
            while(a.canBreath() || items.iterator().hasNext()){
                String item = items.iterator().next();
                a.breath();
                a.getBag().getItems().add(item);
                items.remove(item);
            }
        }
    }
}
