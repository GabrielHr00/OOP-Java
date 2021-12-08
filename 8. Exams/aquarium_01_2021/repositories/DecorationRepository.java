package aquarium.repositories;

import aquarium.entities.decorations.Decoration;
import org.w3c.dom.css.Rect;

import java.util.Collection;
import java.util.LinkedList;

public class DecorationRepository implements aquarium.repositories.Repository {
    private Collection<Decoration> decorations;

    public DecorationRepository() {
        decorations = new LinkedList<>();
    }

    @Override
    public void add(Decoration decoration) {
        decorations.add(decoration);
    }

    @Override
    public boolean remove(Decoration decoration) {
        if(decorations.contains(decoration)){
            decorations.remove(decoration);
            return true;
        }
        return false;
    }

    @Override
    public Decoration findByType(String type) {
        return decorations.stream().filter(e -> e.getClass().getSimpleName().equals(type))
                .findFirst()
                .orElse(null);
    }
}
