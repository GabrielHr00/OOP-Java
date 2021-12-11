package catHouse.entities.houses;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseHouse implements House{
    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    protected BaseHouse(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        toys = new ArrayList<>();
        cats = new ArrayList<>();
    }

    @Override
    public int sumSoftness() {
        int count = 0;
        for (Toy toy : toys) {
            count += toy.getSoftness();
        }
        return count;
    }

    @Override
    public void addCat(Cat cat) {
        if(cats.size() >= capacity){
            throw new IllegalArgumentException(ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT);
        }

        if(cat.getClass().getSimpleName().equals("LonghairCat") && getClass().getSimpleName().equals("LongHouse")){
            cats.add(cat);
        }
        else if(cat.getClass().getSimpleName().equals("ShorthairCat") && getClass().getSimpleName().equals("ShortHouse")){
            cats.add(cat);
        }
        else{
            throw new IllegalArgumentException(ConstantMessages.UNSUITABLE_HOUSE);
        }
    }

    @Override
    public void removeCat(Cat cat) {
        cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        toys.add(toy);
    }

    @Override
    public void feeding() {
        for (Cat cat : cats) {
            cat.eating();
        }
    }

    @Override
    public String getStatistics() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("%s %s:%n", name, getClass().getSimpleName()));
        if(cats.isEmpty()) {
            res.append(String.format("Cats: none%n"));
        }
        else {
            res.append(String.format("Cats: %s%n", cats.stream().map(e -> e.getName()).collect(Collectors.joining(" "))));
        }
        res.append(String.format("Toys: %d Softness: %d%n", toys.size(), sumSoftness()));
        String res1 = res.toString().trim();
        return res1;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Cat> getCats() {
        return cats;
    }

    @Override
    public Collection<Toy> getToys() {
        return toys;
    }
}
