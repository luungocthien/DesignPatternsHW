package observer;

public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        Thread weatherThread = new Thread(weatherStation);
        weatherThread.start();

        WeatherObserver observer1 = new WeatherObserver("Observer 1");
        WeatherObserver observer2 = new WeatherObserver("Observer 2");
        WeatherObserver observer3 = new WeatherObserver("Observer 3");

        weatherStation.addObserver(observer1);
        weatherStation.addObserver(observer2);

        try {
            Thread.sleep(15000); // Let the simulation run for 20 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        weatherStation.removeObserver(observer2);
        System.out.println("Observer 2 removed");

        try {
            Thread.sleep(15000); // Let the simulation run for another 20 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        weatherStation.addObserver(observer3);
        System.out.println("Observer 3 added");
    }
}