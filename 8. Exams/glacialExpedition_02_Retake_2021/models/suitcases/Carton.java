package glacialExpedition.models.suitcases;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Carton implements Suitcase{
    private List<String> exhibits;

    public Carton() {
        this.exhibits = new LinkedList<>();
    }

    @Override
    public Collection<String> getExhibits() {
        return this.exhibits;
    }
}
