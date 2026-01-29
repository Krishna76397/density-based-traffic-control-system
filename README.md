# Traffic Density Controller - Java Simulation

This Java project simulates the density-based traffic control logic (the Arduino sketch translated to Java).
It is designed to run in **VS Code** (or any Java IDE / command line).

## Project structure
```
traffic-density-controller-java/
└── src/
    └── traffic/
        ├── TrafficControllerJava.java
        └── SensorSimulator.java
```

## How to run (from project root)
1. Compile:
   ```bash
   javac -d out -sourcepath src src/traffic/TrafficControllerJava.java src/traffic/SensorSimulator.java
   ```
2. Run:
   ```bash
   java -cp out traffic.TrafficControllerJava
   ```

