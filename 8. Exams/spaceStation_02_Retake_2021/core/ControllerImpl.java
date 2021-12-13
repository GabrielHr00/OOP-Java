package spaceStation.core;

import spaceStation.common.ConstantMessages;
import spaceStation.common.ExceptionMessages;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private AstronautRepository astronautRepository;
    private PlanetRepository planetRepository;
    private int planets;

    public ControllerImpl() {
        astronautRepository = new AstronautRepository();
        planetRepository = new PlanetRepository();
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut as = null;
        if(type.equals("Biologist")){
            as = new Biologist(astronautName);
        } else if(type.equals("Geodesist")){
            as = new Geodesist(astronautName);
        }else if(type.equals("Meteorologist")){
            as = new Meteorologist(astronautName);
        }else{
            throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_INVALID_TYPE);
        }
        astronautRepository.add(as);
        return String.format(ConstantMessages.ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet pl = new PlanetImpl(planetName);
        for (var i : items) {
            pl.getItems().add(i);
        }
        planetRepository.add(pl);
        return String.format(ConstantMessages.PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut byName = astronautRepository.findByName(astronautName);
        if(byName == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }
        astronautRepository.remove(byName);
        return String.format(ConstantMessages.ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        Planet byName = planetRepository.findByName(planetName);
        List<Astronaut> astronauts = astronautRepository.getModels().stream().filter(e -> e.getOxygen() > 60).collect(Collectors.toList());
        if(astronauts.isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages.PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }
        Mission mission = new MissionImpl();
        mission.explore(byName, astronauts);
        planets++;
        long count = astronautRepository.getModels().stream().filter(e -> e.getOxygen() <= 0).count();
        return String.format(ConstantMessages.PLANET_EXPLORED, planetName, count);
    }

    @Override
    public String report() {
        StringBuilder res = new StringBuilder();
        res.append(String.format(ConstantMessages.REPORT_PLANET_EXPLORED, planets));
        res.append(System.lineSeparator());
        res.append(ConstantMessages.REPORT_ASTRONAUT_INFO);

        for (var a : astronautRepository.getModels()) {
            res.append(System.lineSeparator());
            res.append(String.format(ConstantMessages.REPORT_ASTRONAUT_NAME, a.getName()));
            res.append(System.lineSeparator());
            res.append(String.format(ConstantMessages.REPORT_ASTRONAUT_OXYGEN, a.getOxygen()));
            res.append(System.lineSeparator());
            if(a.getBag().getItems().isEmpty()){
                res.append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS, "none"));
            }else{
                String resi = a.getBag().getItems().stream().collect(Collectors.joining(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER));
                res.append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS, resi));
            }
        }
        return res.toString();
    }
}
