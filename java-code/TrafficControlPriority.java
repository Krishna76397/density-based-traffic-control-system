public class TrafficControlPriority {
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            int d1 = (int)(Math.random() * 10); // Traffic density Road 1
            int d2 = (int)(Math.random() * 10); // Traffic density Road 2

            System.out.println("Density: Road1=" + d1 + " | Road2=" + d2);

            if (d1 > d2) {
                System.out.println("Road 1 GREEN for " + (d1 * 500) + " ms");
                Thread.sleep(d1 * 500);
            } else {
                System.out.println("Road 2 GREEN for " + (d2 * 500) + " ms");
                Thread.sleep(d2 * 500);
            }
        }
    }
}