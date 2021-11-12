public class Cat extends Animal{
    public Cat(String name, String favFood) {
        super(name, favFood);
    }

    @Override
    public String explainSelf() {
        return super.explainSelf() + System.lineSeparator() + "MEEOW";
    }
}
