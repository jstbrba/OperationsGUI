import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Timeline extends JPanel {
    ArrayList<EventPanel> events;
    public Timeline() {
        events = new ArrayList<>();
        setSize(640,60);
        setBackground(Color.BLUE);
        setLayout(null);

        events.add(new EventPanel(0,0,0,80));
        events.add(new EventPanel(0,0,80,50));
        events.add(new EventPanel(0,0,100,70));
        events.add(new EventPanel(0,0,200,100));

        for (EventPanel event : events) {
            add(event);
        }
    }
    public void addEvent(int start, int duration) {
        EventPanel ep = new EventPanel(0,0,start,duration);
        ep.setBounds(start,0,duration,60);
    }
}
