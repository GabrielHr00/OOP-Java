package restaurant.entities.tables;

import restaurant.common.ExceptionMessages;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.tables.interfaces.Table;

import java.util.Collection;
import java.util.LinkedList;

import static restaurant.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;

public abstract class BaseTable implements Table {
    private Collection<HealthyFood> healthyFood;
    private Collection<Beverages> beverages;
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReservedTable;
    private double allPeople;

    protected BaseTable(int number, int size, double pricePerPerson) {
        setNumberOfPeople(number);
        setSize(size);
        setPricePerPerson(pricePerPerson);
        healthyFood = new LinkedList<>();
        beverages = new LinkedList<>();
    }

    private void setSize(int size) {
        if(size < 0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TABLE_SIZE);
        }
        this.size = size;
    }

    private void setNumberOfPeople(int numberOfPeople) {
        if(numberOfPeople <= 0){
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    private void setPricePerPerson(double pricePerPerson){
        this.pricePerPerson = pricePerPerson;
    }

    @Override
    public int getTableNumber() {
        return number;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int numberOfPeople() {
        return numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return isReservedTable;
    }

    @Override
    public double allPeople() {
        return allPeople;
    }

    @Override
    public void reserve(int numberOfPeople) {
        if(numberOfPeople <= 0){
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        isReservedTable = true;
        setNumberOfPeople(numberOfPeople);
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        this.healthyFood.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);
    }

    @Override
    public double bill() {
        double sumFood = healthyFood.stream().mapToDouble(f -> f.getPrice()).sum();
        double sumDrinks = beverages.stream().mapToDouble(f -> f.getPrice()).sum();
        double guests = numberOfPeople * pricePerPerson;
        return sumDrinks + sumFood + guests;
    }

    @Override
    public void clear() {
        this.beverages.clear();
        this.healthyFood.clear();
        isReservedTable = false;
        numberOfPeople = 0;
    }

    @Override
    public String tableInformation() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Table - ").append(getTableNumber()).append(System.lineSeparator())
                .append("Size - ").append(size).append(System.lineSeparator())
                .append("Type - ").append(getClass().getSimpleName()).append(System.lineSeparator())
                .append(String.format("All price - %.2f", pricePerPerson));
        return buffer.toString();
    }
}
