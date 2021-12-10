package onlineShop.models.products.computers;

import onlineShop.common.constants.ExceptionMessages;
import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseComputer extends BaseProduct implements Computer {
    private List<Component> components;
    private List<Peripheral> peripherals;

    protected BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        components = new ArrayList<>();
        peripherals = new ArrayList<>();
    }

    @Override
    public List<Component> getComponents() {
        return components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return peripherals;
    }

    @Override
    public void addComponent(Component component) {
        if(components.contains(component)){
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXISTING_COMPONENT, component.getClass().getSimpleName(), getClass().getSimpleName(), getId()));
        }
        components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {
        Component component = components.stream().filter(e -> e.getClass().getSimpleName().equals(componentType)).findAny().orElse(null);
        if(components.isEmpty() || component == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.NOT_EXISTING_COMPONENT, componentType, getClass().getSimpleName(), getId()));
        }
        components.remove(component);
        return component;
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        if(peripherals.contains(peripheral)){
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXISTING_PERIPHERAL, peripheral.getClass().getSimpleName(), getClass().getSimpleName(), getId()));
        }
        peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        Peripheral peri = peripherals.stream().filter(e -> e.getClass().getSimpleName().equals(peripheralType)).findAny().orElse(null);
        if(peripherals.isEmpty() || peri == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.NOT_EXISTING_PERIPHERAL, peripheralType, getClass().getSimpleName(), getId()));
        }
        peripherals.remove(peri);
        return peri;
    }

    @Override
    public double getOverallPerformance() {
        if(components.isEmpty()){
            return getOverallPerformance();
        }
        double sum = 0.0;
        for (var c:components) {
            sum += c.getOverallPerformance();
        }
        Double average = sum/components.size();
        return average + getOverallPerformance();
    }

    @Override
    public double getPrice() {
        double sumc = components.stream().mapToDouble(e -> e.getPrice()).sum();
        double sump = peripherals.stream().mapToDouble(e -> e.getPrice()).sum();
        return sumc + sump + getPrice();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Overall Performance: " + getOverallPerformance() + " Price: " + getPrice() + " - " + getClass().getSimpleName() + ": "
                        + getManufacturer() + " " + getModel() + " (Id: " + getId() + ")");
        res.append(" Components (" + components.size() + "):");
        for (var c : components) {
            res.append(System.lineSeparator());
            res.append("  " + c.toString());
        }
        res.append(System.lineSeparator());
        res.append(" Peripherals (" + peripherals.size() + "); Average Overall Performance (" + peripherals.stream().mapToDouble(e -> e.getOverallPerformance()).average() + "):");
        for (var c : peripherals) {
            res.append(System.lineSeparator());
            res.append("  " + c.toString());
        }
        return res.toString();
    }
}
