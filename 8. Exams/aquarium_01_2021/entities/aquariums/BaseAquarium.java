package aquarium.entities.aquariums;

import aquarium.common.ConstantMessages;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseAquarium implements aquarium.entities.aquariums.Aquarium {
    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    protected BaseAquarium(String name, int capacity) {
        this.setName(name);
        this.setCapacity(capacity);
        decorations = new LinkedList<>();
        fish = new LinkedList<>();
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int calculateComfort() {
        return decorations.stream().mapToInt(e -> e.getComfort()).sum();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addFish(Fish fish) {
        if(this.fish.size() + 1 > this.capacity){
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY);
        }
        this.fish.add(fish);
    }

    @Override
    public void removeFish(Fish fish) {
        this.fish.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public void feed() {
        this.fish.stream().forEach(e -> e.eat());
    }

    @Override
    public String getInfo() {
        String res = name + " (" + getClass().getSimpleName() + "):%nFish: ";
        if(fish.isEmpty()){
            res += "none";
        }
        else{
            List<Fish> fishes = (List<Fish>) this.fish;
            for (int i = 0; i < fish.size(); i++) {
                if(i+1 == fish.size()){
                    res += fishes.get(i).getName();
                }
                else{
                    res += fishes.get(i).getName() + " ";
                }
            }
        }

        res += "%nDecorations: " + decorations.size() + "%nComfort: " + calculateComfort();
        return res;
    }

    @Override
    public Collection<Fish> getFish() {
        return fish;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return decorations;
    }
}
