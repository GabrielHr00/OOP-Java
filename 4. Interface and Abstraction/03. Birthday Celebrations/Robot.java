public class Robot implements Identifiable{
    private String id;
    private String model;

    public Robot(String id, String model) {
        this.id = id;
        this.model = model;
    }

    public String getModel() {
        return this.model;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Robot " + model + " " + id;
    }
}
