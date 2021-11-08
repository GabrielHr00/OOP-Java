public abstract class BasePerson {
    private String name;

    protected BasePerson(String name) {
        this.name = name;
    }

    public abstract String getName();
    private void setName(){
        
    }
}
