package traffic;

import java.util.Random;

/**
 * SensorSimulator
 * Generates simulated distances for 4 sensors.
 * You can replace this with real serial-based readings if you attach sensors to a microcontroller.
 */
public class SensorSimulator {
    private final Random rand = new Random();

    /**
     * Return an array of 4 sensor readings in cm.
     * Values below ~50 indicate a vehicle close to the sensor.
     */
    public int[] getReadings() {
        int[] r = new int[4];
        for (int i = 0; i < 4; i++) {
            // 20% chance of a vehicle close (random distance 10..45 cm)
            if (rand.nextDouble() < 0.2) {
                r[i] = 10 + rand.nextInt(36);
            } else {
                // No vehicle => large distance
                r[i] = 200 + rand.nextInt(800);
            }
        }
        return r;
    }
}
