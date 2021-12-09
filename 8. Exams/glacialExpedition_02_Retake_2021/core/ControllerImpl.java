package glacialExpedition.core;

import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.StateRepository;

import java.util.*;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private ExplorerRepository explorerRepository;
    private int totalStates;
    private StateRepository stateRepository;

    public ControllerImpl() {
        explorerRepository = new ExplorerRepository();
        stateRepository = new StateRepository();
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer ex = null;
        if(type.equals("AnimalExplorer")){
            ex = new AnimalExplorer(explorerName);
        }else if(type.equals("GlacierExplorer")){
            ex = new GlacierExplorer(explorerName);
        }else if(type.equals("NaturalExplorer")){
            ex = new NaturalExplorer(explorerName);
        }else{
            throw new IllegalArgumentException("Explorer type doesn't exists.");
        }

        explorerRepository.add(ex);
        return String.format("Added %s: %s.", type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName);
        Collection<String> exhibites = state.getExhibits();
        Collections.addAll(exhibites, exhibits);
        stateRepository.add(state);
        return String.format("Added state: %s.", stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer explorer = explorerRepository.byName(explorerName);
        if(explorer == null){
            throw new IllegalArgumentException("Explorer " + explorerName+ " doesn't exists.");
        }
        explorerRepository.remove(explorer);
        return String.format("Explorer %s has retired!", explorerName);
    }

    @Override
    public String exploreState(String stateName) {
        State s = stateRepository.byName(stateName);
        List<Explorer> collect = explorerRepository.getCollection().stream().filter(e -> e.getEnergy() > 50).collect(Collectors.toList());

        if(collect.isEmpty()){
            throw new IllegalArgumentException("You must have at least one explorer to explore the state.");
        }
        Mission mission = new MissionImpl();
        mission.explore(s, collect);
        long retired = collect.stream().filter(e -> e.getEnergy() == 0).count();
        totalStates += 1;
        return String.format("The state %s was explored. %d researchers have retired on this mission.", stateName, retired);
    }

    @Override
    public String finalResult() {
        String res = String.format("%d states were explored.%nInformation for the explorers:%n", totalStates);
        for (var i : explorerRepository.getCollection()) {
            res += printExplorer(i);
        }
        return res;
    }

    private String printExplorer(Explorer ex){
        String res = String.format("Name: %s%nEnergy: %.0f%nSuitcase exhibits: ", ex.getName(), ex.getEnergy());
        if(ex.getSuitcase().getExhibits().isEmpty()){
            res += String.format("None%n");
        }else{
            res += ex.getSuitcase().getExhibits().stream().collect(Collectors.joining(", "));
            res += System.lineSeparator();
        }
        return res;
    }
}
