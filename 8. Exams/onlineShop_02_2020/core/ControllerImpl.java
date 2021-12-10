package onlineShop.core;

import onlineShop.common.constants.ExceptionMessages;
import onlineShop.common.constants.OutputMessages;
import onlineShop.core.interfaces.Controller;
import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private Collection<Computer> computers;
    private Collection<Component> components;
    private Collection<Peripheral> peripherals;

    public ControllerImpl() {
        computers = new ArrayList<>();
        components = new ArrayList<>();
        peripherals = new ArrayList<>();
    }

    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
        Computer computer = computers.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
        if(computer != null){
            throw new IllegalArgumentException(ExceptionMessages.EXISTING_COMPUTER_ID);
        }
        Computer newComp = null;
        if(computerType.equals("DesktopComputer")){
            newComp = new DesktopComputer(id, manufacturer, model, price);
        }
        else if(computerType.equals("Laptop")){
            newComp = new Laptop(id, manufacturer, model, price);
        }
        else{
            throw new IllegalArgumentException(ExceptionMessages.INVALID_COMPUTER_TYPE);
        }
        computers.add(newComp);
        return String.format(OutputMessages.ADDED_COMPUTER, id);
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        Computer computer = computers.stream().filter(e -> e.getId() == computerId).findFirst().orElse(null);
        if(computer == null){
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }
        Peripheral per = peripherals.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
        if(per != null){
            throw new IllegalArgumentException(ExceptionMessages.EXISTING_PERIPHERAL_ID);
        }

        if(peripheralType.equals("Headset")){
            per = new Headset(id, manufacturer, model, price, overallPerformance, connectionType);
        }else if(peripheralType.equals("Keyboard")){
            per = new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType);
        }else if(peripheralType.equals("Monitor")){
            per = new Monitor(id, manufacturer, model, price, overallPerformance, connectionType);
        }else if(peripheralType.equals("Mouse")){
            per = new Mouse(id, manufacturer, model, price, overallPerformance, connectionType);
        }else{
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PERIPHERAL_TYPE);
        }
        computer.addPeripheral(per);
        peripherals.add(per);
        return String.format(OutputMessages.ADDED_PERIPHERAL, peripheralType, id, computerId);
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        Computer computer = computers.stream().filter(e -> e.getId() == computerId).findFirst().orElse(null);
        if(computer == null){
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }
        Peripheral per = peripherals.stream().filter(e -> e.getClass().getSimpleName().equals(peripheralType)).findFirst().orElse(null);
        computer.removePeripheral(peripheralType);
        peripherals.remove(per);
        return String.format(OutputMessages.REMOVED_PERIPHERAL, peripheralType, computerId);

    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer, String model, double price, double overallPerformance, int generation) {
        Computer computer = computers.stream().filter(e -> e.getId() == computerId).findFirst().orElse(null);
        if(computer == null){
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }
        Component temp = components.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
        if(temp != null){
            throw new IllegalArgumentException(ExceptionMessages.EXISTING_COMPONENT_ID);
        }

        Component component = null;
        if(componentType.equals("Motherboard")){
            component = new Motherboard(id, manufacturer, model, price, overallPerformance, generation);
        } else if(componentType.equals("CentralProcessingUnit")){
            component = new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation);
        }else if(componentType.equals("PowerSupply")){
            component = new PowerSupply(id, manufacturer, model, price, overallPerformance, generation);
        }else if(componentType.equals("RandomAccessMemory")){
            component = new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation);
        }else if(componentType.equals("SolidStateDrive")){
            component = new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation);
        }else if(componentType.equals("VideoCard")){
            component = new VideoCard(id, manufacturer, model, price, overallPerformance, generation);
        }else{
            throw new IllegalArgumentException(ExceptionMessages.INVALID_COMPONENT_TYPE);
        }
        computer.addComponent(component);
        components.add(component);
        return String.format(OutputMessages.ADDED_COMPONENT, componentType, id, computerId);
    }

    @Override
    public String removeComponent(String componentType, int computerId) {
        Computer computer = computers.stream().filter(e -> e.getId() == computerId).findFirst().orElse(null);
        if(computer == null){
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }
        Component comp = components.stream().filter(e -> e.getClass().getSimpleName().equals(componentType)).findFirst().orElse(null);
        computer.removeComponent(componentType);
        components.remove(comp);
        return String.format(OutputMessages.REMOVED_COMPONENT, componentType, computerId);
    }

    @Override
    public String buyComputer(int id) {
        Computer computer = computers.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
        if(computer == null){
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }
        computers.remove(computer);
        return computer.toString();
    }

    @Override
    public String BuyBestComputer(double budget) {
        List<Computer> collect = computers.stream().filter(e -> e.getPrice() <= budget).collect(Collectors.toList());
        if(computers.isEmpty() || collect.isEmpty()){
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAN_NOT_BUY_COMPUTER, budget));
        }
        List<Computer> collect1 = collect.stream().sorted((a, b) -> Double.compare(b.getOverallPerformance(), a.getOverallPerformance())).collect(Collectors.toList());
        Computer c = collect1.get(0);
        computers.remove(c);
        return c.toString();
    }

    @Override
    public String getComputerData(int id) {
        Computer computer = computers.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
        if(computer == null){
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }
        return computer.toString();
    }
}
