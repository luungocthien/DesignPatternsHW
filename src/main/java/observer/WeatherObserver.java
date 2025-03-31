package observer;

public class WeatherObserver implements Observer {
    private final String name;

    public WeatherObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(float temperature) {
        System.out.println(name + " received update: Current temperature is " + temperature + "°C");
    }
}
