public class TrafficControlTimer {
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            for (int i = 1; i <= 2; i++) {
                int density = (int)(Math.random() * 10);

                if (density > 7) {
                    System.out.println("Road " + i + " HIGH density → Extending GREEN");
                    Thread.sleep(6000);
                } else {
                    System.out.println("Road " + i + " GREEN for normal time");
                    Thread.sleep(3000);
                }
            }
        }
    }
}