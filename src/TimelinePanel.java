import javax.swing.*;
import java.awt.*;

public class TimelinePanel extends JPanel {

    private final GUI gui;
    private final int day;
    private final int month;

    private final int eventHeight;
    private final int esWidth;

    public TimelinePanel(GUI gui, int day, int month) {
        this.gui = gui;
        this.day = day;
        this.month = month;

        eventHeight = gui.getHeight()/24;
        esWidth = gui.getWidth()-140;

        String monthName = getMonthName(month);

        setLayout(null);
        setBounds(0,90,1080,gui.getHeight()-125);
        JLabel dayLabel = new JLabel(day + " " + monthName);
        dayLabel.setBounds(30,0,80,30);
        dayLabel.setForeground(Color.WHITE);
        add(dayLabel);

        setBackground(GUI.backgroundColor);

        JPanel viewerPanel = new JPanel();
        viewerPanel.setLayout(null);
        viewerPanel.setBounds(gui.getWidth()/4,30,gui.getWidth()/2,gui.getHeight()/3);
        viewerPanel.setBackground(Color.WHITE);
        add(viewerPanel);

        // ROOM NAMES
        JPanel roomNamesPanel = new JPanel();
        roomNamesPanel.setLayout(null);
        roomNamesPanel.setBackground(Color.LIGHT_GRAY);
        roomNamesPanel.setBounds(10,gui.getHeight()/3 + 80, 80, gui.getHeight()/3);

        String[] roomNames = {"Main","Small","Rehearsal","M1","M2","M3","M4","M5"};
        for (int i = 0; i < roomNames.length; i++) {
            JLabel roomName = new JLabel(roomNames[i], SwingConstants.CENTER);
            roomName.setBounds(0,i*(gui.getHeight()/24), 80, gui.getHeight()/24);
            roomNamesPanel.add(roomName);

        }
        add(roomNamesPanel);

        // EVENT SCHEDULES
        JPanel eventSchedulePanel = new JPanel();
        eventSchedulePanel.setLayout(new BoxLayout(eventSchedulePanel, BoxLayout.Y_AXIS));
        eventSchedulePanel.setBounds(90,gui.getHeight()/3 + 80 ,esWidth,gui.getHeight()/3);
        eventSchedulePanel.setBackground(Color.WHITE);
        add(eventSchedulePanel);

        // EVENTS
        EventPanel eventPanel = new EventPanel(this);
        eventPanel.setBounds(1,0 ,esWidth,eventHeight);
        eventSchedulePanel.add(eventPanel);

        String[] times = {"10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00","00:00"};
        for (int i = 0; i < times.length; i++) {
            JLabel time = new JLabel(times[i], SwingConstants.CENTER);
            time.setForeground(Color.WHITE);
            time.setBounds(90 + i * esWidth/14,gui.getHeight()/3 + 55, 30, 30);
            add(time);

            JPanel divider = new JPanel();
            divider.setBackground(Color.LIGHT_GRAY);
            divider.setBounds(i * esWidth/14,0,1,gui.getHeight()/3);
            eventSchedulePanel.add(divider);
        }
        JPanel closedPanel = new JPanel();
        closedPanel.setBounds(90+esWidth, gui.getHeight()/3 + 80, 140, gui.getHeight()/3);
        closedPanel.setBackground(Color.LIGHT_GRAY);
        add(closedPanel);


        // EXIT BUTTON
        JButton exit = new JButton("Exit");
        exit.setBounds(0,0,20,20);
        add(exit);

        exit.addActionListener(e -> {
            gui.remove(TimelinePanel.this);
            gui.repaint();
            gui.getCalendarPanel().unpause();
            gui.getCalendarPanel().repaintDays();
        });
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
    public int getEventHeight() {
        return eventHeight;
    }
    public int getEsWidth() {
        return esWidth;
    }
}
