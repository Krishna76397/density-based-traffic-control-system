package traffic;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.Random;

/**
 * TrafficControllerJava
 * A Java simulation of the Density Based Traffic Control System.
 * - Simulates 4 ultrasonic sensors (or can be modified to read from serial)
 * - Controls 4 traffic signals (console output)
 * - Uses a scheduled executor for periodic sensor sampling (non-blocking)
 *
 * Run with: javac traffic/*.java && java traffic.TrafficControllerJava
 */

public class TrafficControllerJava {
    // Sensor readings in cm
    private volatile int S1 = 1000, S2 = 1000, S3 = 1000, S4 = 1000;
    private final int threshold = 50; // cm
    private final int greenDuration = 5000; // ms
    private final int yellowDuration = 2000; // ms

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final SensorSimulator simulator = new SensorSimulator();

    private volatile boolean running = true;

    public static void main(String[] args) throws Exception {
        TrafficControllerJava controller = new TrafficControllerJava();
        controller.start();
    }

    public void start() {
        System.out.println("Starting TrafficControllerJava simulation...");
        // Start periodic sensor updates (every 100 ms)
        scheduler.scheduleAtFixedRate(this::readSensors, 0, 100, TimeUnit.MILLISECONDS);

        // Main control loop runs on separate thread to avoid blocking sensor sampling
        Thread controlThread = new Thread(this::controlLoop);
        controlThread.start();
    }

    private void readSensors() {
        // Update sensor values (simulate)
        int[] readings = simulator.getReadings();
        S1 = readings[0];
        S2 = readings[1];
        S3 = readings[2];
        S4 = readings[3];
        // Uncomment to debug sensor values:
        // System.out.printf("Sensors: S1=%d S2=%d S3=%d S4=%d%n", S1, S2, S3, S4);
    }

    private void controlLoop() {
        while (running) {
            try {
                if (S1 > 0 && S1 < threshold) {
                    serveRoad(1);
                } else if (S2 > 0 && S2 < threshold) {
                    serveRoad(2);
                } else if (S3 > 0 && S3 < threshold) {
                    serveRoad(3);
                } else if (S4 > 0 && S4 < threshold) {
                    serveRoad(4);
                } else {
                    defaultCycle();
                }
                // small sleep to avoid busy-looping
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        scheduler.shutdown();
    }

    private void serveRoad(int road) throws InterruptedException {
        printState("GIVE GREEN TO ROAD " + road);
        // Simulate green
        printLights(road, "GREEN");
        Thread.sleep(greenDuration);

        // Yellow
        printLights(road, "YELLOW");
        Thread.sleep(yellowDuration);

        // Back to red
        printLights(road, "RED");
    }

    private void defaultCycle() throws InterruptedException {
        int shortGreen = 2000;
        int shortYellow = 800;
        for (int i = 1; i <= 4; i++) {
            printState("DEFAULT CYCLE - Road " + i + " short green");
            printLights(i, "GREEN");
            Thread.sleep(shortGreen);
            printLights(i, "YELLOW");
            Thread.sleep(shortYellow);
            printLights(i, "RED");
        }
    }

    private void printLights(int activeRoad, String color) {
        String s1 = activeRoad == 1 ? color : "RED";
        String s2 = activeRoad == 2 ? color : "RED";
        String s3 = activeRoad == 3 ? color : "RED";
        String s4 = activeRoad == 4 ? color : "RED";
        System.out.println("-----------------------------------------");
        System.out.printf("Road1: %s | Road2: %s | Road3: %s | Road4: %s%n", s1, s2, s3, s4);
        System.out.println("-----------------------------------------");
    }

    private void printState(String msg) {
        System.out.println("\n>> " + msg);
    }
}
