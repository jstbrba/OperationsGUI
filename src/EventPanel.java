import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class EventPanel extends JPanel {

    private final ArrayList<Event> events;
    private final TimelinePanel tp;

    public EventPanel(TimelinePanel tp){
        this.tp = tp;
        events = new ArrayList<>();
        setLayout(null);
        setBackground(Color.WHITE);
        setFocusable(true);
        setPreferredSize(new Dimension(tp.getEsWidth(), tp.getEventHeight()));
        // Code to get events by date and room

        //------------------------------------
        Event e1 = new Event(LocalTime.of(10,0),Duration.ofMinutes(120));
        Event e2 = new Event(LocalTime.of(13,0),Duration.ofMinutes(60));
        Event e3 = new Event(LocalTime.of(15,0),Duration.ofMinutes(180));
        events.add(e1);
        events.add(e2);
        events.add(e3);

        System.out.println(e2.getDurationAsInt() + " " + e2.getTimeAsInt());

        for (Event e : events) {
            EventItem eventItem = new EventItem(e);
            eventItem.setBounds(e.getTimeAsInt() * tp.getEsWidth()/14,tp.getEventHeight()/4,e.getDurationAsInt() * tp.getEsWidth()/14, tp.getEventHeight()/2);
            setComponentZOrder(eventItem,0);
            add(eventItem);
        }
        revalidate();
        repaint();
    }
    private class EventItem extends JPanel {
        private Event event;

        public EventItem(Event event) {
            this.event = event;

            setBackground(GUI.accentColor);
            setOpaque(true);
            setFocusable(true);

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("CLICKED");
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    setBackground(GUI.accentColor.brighter());
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    setBackground(GUI.accentColor);
                }
            });
        }
    }

    public class Event {

        private final LocalTime time;
        private final Duration duration;
        // private final String roomName;

        public Event(LocalTime time, Duration duration) {
            this.time = time;
            this.duration = duration;
        }
        public int getTimeAsInt() {
            LocalTime baseTime = LocalTime.of(10,0);
            int minutesSinceBase = (int) Duration.between(baseTime, time).toMinutes();
            return minutesSinceBase / 60;
        }
        public int getDurationAsInt() {
            return (int)duration.toMinutes() / 60;
        }
        public LocalTime getTime() {
            return time;
        }
        public Duration getDuration() {
            return duration;
        }
    }
}
