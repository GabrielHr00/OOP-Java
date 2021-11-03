package pizza;

import java.util.HashMap;
import java.util.Map;

public class Topping {
    private static final int CALORIES_PER_GRAM = 2;
    private String toppingType;
    private double weight;

    private static final Map<String, Double> toppingParan = new HashMap<>() {{
        put("Meat", 1.2);
        put("Veggies", 0.8);
        put("Cheese", 1.1);
        put("Sauce", 0.9);
    }};

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if(!toppingParan.containsKey(toppingType)){
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if(weight <= 0 || weight > 50){
            throw new IllegalArgumentException(this.toppingType + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    public double calculateCalories(){
        return (CALORIES_PER_GRAM * this.weight) * toppingParan.get(this.toppingType);
    }
}

