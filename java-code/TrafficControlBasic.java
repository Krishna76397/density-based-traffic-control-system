public class TrafficControlBasic {
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            int d1 = sensorRead(); // Road 1
            int d2 = sensorRead(); // Road 2

            if (d1 == 0 && d2 == 1) {
                System.out.println("Road 1 GREEN, Road 2 RED");
            } else if (d2 == 0 && d1 == 1) {
                System.out.println("Road 2 GREEN, Road 1 RED");
            } else {
                System.out.println("Both RED - No traffic");
            }

            Thread.sleep(3000);
        }
    }

    static int sensorRead() {
        return Math.random() > 0.5 ? 0 : 1; // 0 = vehicle present
    }
}