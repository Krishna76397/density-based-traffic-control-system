import javax.swing.*;
import java.awt.*;

public class TrafficControlGUI extends JFrame {
    private JLabel road1Light, road2Light;

    public TrafficControlGUI() {
        setTitle("Traffic Control System");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));

        road1Light = new JLabel("Road 1: RED", SwingConstants.CENTER);
        road2Light = new JLabel("Road 2: RED", SwingConstants.CENTER);

        add(road1Light);
        add(road2Light);

        setVisible(true);

        new Thread(this::runSystem).start();
    }

    private void runSystem() {
        while (true) {
            try {
                road1Light.setText("Road 1: GREEN");
                road2Light.setText("Road 2: RED");
                Thread.sleep(3000);

                road1Light.setText("Road 1: RED");
                road2Light.setText("Road 2: GREEN");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new TrafficControlGUI();
    }
}