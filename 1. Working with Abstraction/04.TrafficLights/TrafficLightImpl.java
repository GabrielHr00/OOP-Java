import java.util.Iterator;

public class TrafficLightImpl implements Iterator<Light> {

    private Light currentLight;

    public TrafficLightImpl(Light currentLight) {
        this.currentLight = currentLight;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Light next() {
        switch (this.currentLight.name()) {
            case "RED":
                this.currentLight = Light.valueOf("GREEN");
                break;
            case "GREEN":
                this.currentLight = Light.valueOf("YELLOW");
                break;
            default:
                this.currentLight = Light.valueOf("RED");
                break;
        }
        return this.currentLight;
    }
}
