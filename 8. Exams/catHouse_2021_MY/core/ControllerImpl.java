package catHouse.core;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller{
    private ToyRepository toys;
    private Collection<House> houses;

    public ControllerImpl() {
        this.toys = new ToyRepository();
        this.houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {
        House h = null;
        if(type.equals("LongHouse")){
            h = new LongHouse(name);
        }else if(type.equals("ShortHouse")){
            h = new ShortHouse(name);
        }else{
            throw new NullPointerException(ExceptionMessages.INVALID_HOUSE_TYPE);
        }

        houses.add(h);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy = null;
        if(type.equals("Ball")){
            toy = new Ball();
        }
        else if(type.equals("Mouse")){
            toy = new Mouse();
        }
        else{
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TOY_TYPE);
        }

        toys.buyToy(toy);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy t = toys.findFirst(toyType);
        if(t == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_TOY_FOUND, toyType));
        }

        House h = houses.stream().filter(e -> e.getName().equals(houseName)).findFirst().get();
        h.buyToy(t);
        toys.removeToy(t);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat c = null;
        if(catType.equals("ShorthairCat")){
            c = new ShorthairCat(catName, catBreed, price);
        }
        else if(catType.equals("LonghairCat")){
            c = new LonghairCat(catName, catBreed, price);
        }
        else{
            throw new IllegalArgumentException(ExceptionMessages.INVALID_CAT_TYPE);
        }

        House h = houses.stream().filter(e -> e.getName().equals(houseName)).findFirst().get();
        try{
            h.addCat(c);
        }catch(IllegalArgumentException e){
            return e.getMessage();
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
    }

    @Override
    public String feedingCat(String houseName) {
        House h = houses.stream().filter(e -> e.getName().equals(houseName)).findFirst().get();
        int count = h.getCats().size();
        h.feeding();
        return String.format(ConstantMessages.FEEDING_CAT, count);
    }

    @Override
    public String sumOfAll(String houseName) {
        House h = houses.stream().filter(e -> e.getName().equals(houseName)).findFirst().get();
        double value = 0.0;
        double catsum = 0.0;
        for (Cat cat : h.getCats()) {
            catsum += cat.getPrice();
        }
        if(catsum > 0.0){
            value += catsum;
        }

        double toysum = 0.0;
        for (Toy toy : h.getToys()) {
            toysum += toy.getPrice();
        }
        if(toysum > 0.0){
            value += toysum;
        }
        return String.format(ConstantMessages.VALUE_HOUSE, houseName, value);
    }

    @Override
    public String getStatistics() {
        String res = "";
        for (House house : houses) {
            res += house.getStatistics();
            res += System.lineSeparator();
        }
        return res.trim();
    }
}
