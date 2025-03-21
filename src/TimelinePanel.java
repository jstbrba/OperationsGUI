import javax.swing.*;
import java.awt.*;

public class TimelinePanel extends JPanel {

    private final GUI gui;
    private final int day;
    private final int month;

    public TimelinePanel(GUI gui, int day, int month) {
        this.gui = gui;
        this.day = day;
        this.month = month;

        String monthName = getMonthName(month);

        setLayout(null);
        setBounds(0,180,1080,360);

        setBackground(Color.DARK_GRAY);
        setBorder(BorderFactory.createLineBorder(GUI.backgroundColor));

        JLabel title = new JLabel(day + " " + monthName, SwingConstants.CENTER);
        title.setBounds(10,10,200,30);
        title.setForeground(Color.WHITE);
        add(title);

        JButton exit = new JButton("Exit");
        exit.setBounds(0,0,40,40);
        add(exit);

        JPanel timelineStack = new JPanel();
        timelineStack.setLayout(new BoxLayout(timelineStack, BoxLayout.Y_AXIS));

        timelineStack.add(createTimeline("Main hall"));
        timelineStack.add(createTimeline("Small Hall"));
        timelineStack.add(createTimeline("Meeting Room"));

        JScrollPane scroll = new JScrollPane(timelineStack);
        scroll.setBounds(40,50,gui.getWidth()-100,260);
        scroll.setBorder(BorderFactory.createLineBorder(GUI.accentColor));
        add(scroll);

        exit.addActionListener(e -> {
            gui.remove(TimelinePanel.this);
            gui.repaint();
            gui.getCalendarPanel().unpause();
            gui.getCalendarPanel().repaintDays();
        });
    }

    private JPanel createTimeline(String roomName){
        JPanel roomTimeline = new JPanel();
        roomTimeline.setLayout(new BoxLayout(roomTimeline, BoxLayout.X_AXIS));
        roomTimeline.setBackground(Color.BLUE);

        JLabel roomNameLabel = new JLabel(roomName);
        roomNameLabel.setForeground(Color.WHITE);
        roomTimeline.add(roomNameLabel);

        for (int i = 1; i <= 5; i++) {  // Example 5 events for each room
            JPanel eventPanel = new JPanel();
            eventPanel.setBackground(Color.CYAN);
            eventPanel.setPreferredSize(new Dimension(1040, 50));  // Event height
            eventPanel.add(new JLabel("Event " + i));
            roomTimeline.add(eventPanel);
        }
        return roomTimeline;
    }

    private static String getMonthName(int month) {
        String monthName = "January";
        switch (month) {
            case 1: monthName = "January"; break;
            case 2: monthName = "February"; break;
            case 3: monthName = "March"; break;
            case 4: monthName = "April"; break;
            case 5: monthName = "May"; break;
            case 6: monthName = "June"; break;
            case 7: monthName = "July"; break;
            case 8: monthName = "August"; break;
            case 9: monthName = "September"; break;
            case 10: monthName = "October"; break;
            case 11: monthName = "November"; break;
            case 12: monthName = "December"; break;
        }
        return monthName;
    }
}
