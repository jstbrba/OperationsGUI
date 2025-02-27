import javax.swing.*;
import java.util.ArrayList;

public class TimelineWindow extends JFrame {

    private Timeline main;
    private Timeline small;

    public TimelineWindow(int day, int month) {
        setTitle("Timeline for: " + day + "/" + month);
        setSize(1080, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        //setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

        main = new Timeline();
        small = new Timeline();
        add(main);
    }
}
