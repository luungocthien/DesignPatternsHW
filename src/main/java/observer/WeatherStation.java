package observer;

import java.util.Random;

public class WeatherStation extends Observable implements Runnable {
    private float temperature;
    private Random random = new Random();
    private final float minTemp = -30.0f;
    private final float maxTemp = 45.0f;

    public WeatherStation() {
        this.temperature = random.nextFloat() * (maxTemp - minTemp) + minTemp;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep((random.nextInt(5) + 1) * 1000);
                updateTemp();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateTemp() {
        float change = random.nextFloat() * 2 - 1; // -1 to +1
        temperature += change;
        if (temperature < minTemp) {
            temperature = minTemp;
        } else if (temperature > maxTemp) {
            temperature = maxTemp;
        }
        notifyObservers(temperature);
    }
}
