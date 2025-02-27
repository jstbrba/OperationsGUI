import javax.swing.*;
import java.awt.*;

public class EventPanel extends JPanel {
    private int start;
    private int duration;

    public EventPanel(int x, int y, int start, int duration) {
        this.start = start;
        this.duration = duration;
        setBackground(Color.CYAN);
        setBorder(BorderFactory.createLineBorder(Color.black));
        setBounds(start,x,duration,y);
        setLayout(new BorderLayout());
        setVisible(true);
    }
}
