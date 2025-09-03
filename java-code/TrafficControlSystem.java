public class TrafficControlSystem {

    // Traffic lights (simulated)
    static boolean R1 = true, G1 = false;
    static boolean R2 = true, G2 = false;
    static boolean R3 = true, G3 = false;
    static boolean R4 = true, G4 = false;

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            // Simulated sensor values (0 = vehicle present, 1 = no vehicle)
            int d1 = sensorRead(1);
            int d2 = sensorRead(2);
            int d3 = sensorRead(3);
            int d4 = sensorRead(4);

            if (d1 == 0) {
                setTraffic(1);
                Thread.sleep(5000);
            } else if (d2 == 0) {
                setTraffic(2);
                Thread.sleep(5000);
            } else if (d3 == 0) {
                setTraffic(3);
                Thread.sleep(5000);
            } else if (d4 == 0) {
                setTraffic(4);
                Thread.sleep(5000);
            } else {
                for (int i = 1; i <= 4; i++) {
                    setTraffic(i);
                    Thread.sleep(3000);
                }
            }
        }
    }

    // Function to simulate IR sensor readings
    static int sensorRead(int sensor) {
        // For demo: randomly generate vehicle presence (0) or absence (1)
        return Math.random() > 0.7 ? 0 : 1;
    }

    // Function to set traffic lights
    static void setTraffic(int road) {
        // Reset all to red
        R1 = R2 = R3 = R4 = true;
        G1 = G2 = G3 = G4 = false;

        // Activate selected road green
        switch (road) {
            case 1: R1 = false; G1 = true; break;
            case 2: R2 = false; G2 = true; break;
            case 3: R3 = false; G3 = true; break;
            case 4: R4 = false; G4 = true; break;
        }

        // Print current state
        System.out.println("Traffic Light Status:");
        System.out.println("Road1: " + (G1 ? "GREEN" : "RED"));
        System.out.println("Road2: " + (G2 ? "GREEN" : "RED"));
        System.out.println("Road3: " + (G3 ? "GREEN" : "RED"));
        System.out.println("Road4: " + (G4 ? "GREEN" : "RED"));
        System.out.println("-----------------------------");
    }
}
