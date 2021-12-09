package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;

import java.util.Collection;
import java.util.List;

public class MissionImpl implements Mission{
    @Override
    public void explore(State state, Collection<Explorer> explorers) {
        Collection<String> exhib = state.getExhibits();
        for (var ex : explorers) {
            while(ex.canSearch() || exhib.iterator().hasNext()){
                String exi = exhib.iterator().next();
                ex.search();
                ex.getSuitcase().getExhibits().add(exi);
                exhib.remove(exi);
            }
        }
    }
}
