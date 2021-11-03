public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private void setName(String name) {
        if(name.isEmpty() || name.equals("\\s+") || name == null){
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        if(age > 15 || age < 0){
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public double productPerDay(){
        return calculateProductPerDay();
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.", name, age, productPerDay());
    }

    private double calculateProductPerDay(){
        if(this.age >= 0 && this.age <= 5){
            return 2.00;
        }
        else if(this.age >= 6 && this.age <= 11){
            return 1.00;
        }else{
            return 0.75;
        }
    }
}
