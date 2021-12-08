package aquarium.entities.aquariums;

import aquarium.common.ConstantMessages;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseAquarium implements aquarium.entities.aquariums.Aquarium {
    private String name;
    private int capacity;
    private List<Decoration> decorations;
    private List<Fish> fish;

    protected BaseAquarium(String name, int capacity) {
        this.setName(name);
        this.setCapacity(capacity);
        decorations = new LinkedList<>();
        fish = new LinkedList<>();
    }

    private void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new NullPointerException("Aquarium name cannot be null or empty.");
        }
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

        if(fish.getClass().getSimpleName().equals("FreshwaterFish") && this.getClass().getSimpleName().equals("FreshwaterAquarium")){
            this.fish.add(fish);
        }
        else if(fish.getClass().getSimpleName().equals("SaltwaterFish") && this.getClass().getSimpleName().equals("SaltwaterAquarium")){
            this.fish.add(fish);
        }
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
        String res = this.fish.size() == 0 ? "none" : this.fish.stream().map(e -> e.getName()).collect(Collectors.joining(" "));
        return String.format("%s (%s):%nFish: %s%nDecorations: %d%nComfort: %d",
                name, getClass().getSimpleName(),res, decorations.size(), calculateComfort());
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
