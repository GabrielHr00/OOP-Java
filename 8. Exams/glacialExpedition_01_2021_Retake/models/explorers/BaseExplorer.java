package glacialExpedition.models.explorers;

import glacialExpedition.models.suitcases.Suitcase;

public abstract class BaseExplorer implements Explorer{
    private String name;
    private double energy;
    private Suitcase suitcase;

    protected BaseExplorer(String name, double energy) {
        this.setName(name);
        this.setEnergy(energy);
    }

    private void setName(String name) {
        this.name = name;
    }

    protected void setEnergy(double energy) {
        this.energy = energy;
    }

    private void setSuitcase(Suitcase suitcase) {
        this.suitcase = suitcase;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getEnergy() {
        return energy;
    }

    @Override
    public boolean canSearch() {
        return energy > 0;
    }

    @Override
    public Suitcase getSuitcase() {
        return suitcase;
    }

    @Override
    public void search() {
        if(this.energy - 15 < 0){
            setEnergy(0);
        }else{
            setEnergy(this.energy - 15);
        }
    }
}
