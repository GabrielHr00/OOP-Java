package aquarium.core;

import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ControllerImpl implements Controller{
    private DecorationRepository decorations;
    private List<Aquarium> aquariums;

    public ControllerImpl() {
        decorations = new DecorationRepository();
        aquariums = new LinkedList<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        if(!aquariumType.equals("FreshwaterAquarium") && !aquariumType.equals("SaltwaterAquarium")){
            throw new NullPointerException("Invalid aquarium type.");
        }
        addAquariumSimple(aquariumType, aquariumName);
        return String.format("Successfully added %s.", aquariumType);
    }

    private void addAquariumSimple(String aquariumType, String aquariumName) {
        if(aquariumType.equals("FreshwaterAquarium")){
            aquariums.add(new FreshwaterAquarium(aquariumName));
        }
        else if(aquariumType.equals("SaltwaterAquarium")){
            aquariums.add(new SaltwaterAquarium(aquariumName));
        }
    }

    @Override
    public String addDecoration(String type) {
        if(!type.equals("Ornament") && !type.equals("Plant")){
            throw new IllegalArgumentException("Invalid decoration type.");
        }
        addDecorationSimple(type);
        return String.format("Successfully added %s.", type);
    }

    private void addDecorationSimple(String type) {
        if(type.equals("Ornament")){
            decorations.add(new Ornament());
        }
        else if(type.equals("Plant")){
            decorations.add(new Plant());
        }
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration dec = decorations.findByType(decorationType);
        if(dec == null){
            throw new IllegalArgumentException("There isn't a decoration of type " + decorationType + ".");
        }

        for (var i : aquariums) {
            if(i.getName().equals(aquariumName)){
                i.addDecoration(dec);
                decorations.remove(dec);
                break;
            }
        }
        return String.format("Successfully added %s to %s.", decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        if(!fishType.equals("FreshwaterFish") && !fishType.equals("SaltwaterFish")){
            throw new IllegalArgumentException("Invalid fish type.");
        }

        Aquarium aq = null;
        for (var i : aquariums) {
            if(i.getName().equals(aquariumName)){
                aq = i;
            }
        }

        if(!(fishType.getClass().getSimpleName().equals("FreshwaterFish") && aq.getClass().getSimpleName().equals("FreshwaterAquarium"))
                && !(fishType.getClass().getSimpleName().equals("SaltwaterFish") && aq.getClass().getSimpleName().equals("SaltwaterAquarium"))){
            return "Water not suitable.";
        }
        try{
            if(fishType.equals("FreshwaterFish")){
                aq.addFish(new FreshwaterFish(fishName, fishSpecies, price));
            }
            else if(fishType.equals("SaltwaterFish")){
                aq.addFish(new SaltwaterFish(fishName, fishSpecies, price));
            }
        }catch(IllegalStateException e){
            return "Not enough capacity.";
        }
        return String.format("Successfully added %s to %s.", fishType, aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {
        int size = 0;
        for (var i : aquariums) {
            if (i.getName().equals(aquariumName)) {
                size = i.getFish().size();
                i.feed();
                break;
            }
        }
        return String.format("Fish fed: %d", size);
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aq = null;
        for (var i : aquariums) {
            if(i.getName().equals(aquariumName)){
                aq = i;
            }
        }

        double value1 = aq.getFish().stream().mapToDouble(e -> e.getPrice()).sum();
        double value2 = aq.getDecorations().stream().mapToDouble(e -> e.getPrice()).sum();
        double value = value1 + value2;
        return String.format("The value of Aquarium %s is %.2f.", aquariumName, value);
    }

    @Override
    public String report() {
        String res = "";
        for (int i = 0; i < aquariums.size(); i++) {
            if(i + 1 == aquariums.size()){
                res += aquariums.get(i).getInfo();
            }
            else{
                res += aquariums.get(i).getInfo() + System.lineSeparator();
            }
        }
        return res;
    }
}
