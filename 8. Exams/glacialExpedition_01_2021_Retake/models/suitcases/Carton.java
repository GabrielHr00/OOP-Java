package glacialExpedition.models.suitcases;

import java.util.Collection;
import java.util.LinkedList;

public class Carton implements Suitcase{
    private Collection<String> exhibits;

    public Carton() {
        this.exhibits = new LinkedList<>();
    }

    @Override
    public Collection<String> getExhibits() {
        return exhibits;
    }
}
