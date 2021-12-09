package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;

import java.util.Collection;

public class MissionImpl implements Mission{


    @Override
    public void explore(State state, Collection<Explorer> explorers) {
        Collection<String> exhib = state.getExhibits();

        for (var ex : explorers) {
            if(ex.canSearch()) {
                for (var exh : exhib) {
                    if (ex.canSearch()) {
                        ex.search();
                        ex.getSuitcase().getExhibits().add(exh);
                        exhib.remove(exh);
                    }else{
                        break;
                    }
                }
            }
        }
    }
}
